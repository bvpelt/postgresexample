package nl.bsoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.bsoft.fun01.FunObject;
import nl.bsoft.fun01.FunResponse;
import nl.bsoft.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bvpelt on 4/15/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class FunMapper {
    private static final Logger log = LoggerFactory.getLogger(FunMapper.class);

    private FunObjectRepository repository;
    private FunListRepository listRepository;
    private FunProductRepository productRepository;
    private FunProjectRepository projectRepository;
    private FunPromoLabelObjectRepository promolabelRepository;
    private FunPrijsRepository prijsRepository;
    private int numObjectsWritten = 0;

    @Autowired
    public void setRepository(FunObjectRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setListRepository(FunListRepository repository) {
        this.listRepository = repository;
    }

    @Autowired
    public void setProductRepository(FunProductRepository repository) {
        this.productRepository = repository;
    }

    @Autowired
    public void setProjectRepository(FunProjectRepository repository) {
        this.projectRepository = repository;
    }

    @Autowired
    public void setPromoLabelObjectRepository(FunPromoLabelObjectRepository repository) {
        this.promolabelRepository = repository;
    }

    @Autowired
    public void setPrijsRepository(FunPrijsRepository repository) {
        this.prijsRepository = repository;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void atestDateConversion() {
        String inputDate = "/Date(1262300400000+0100)/";
        Date outputDate = null;

        outputDate = DotNetDateToJavaDate.convert(inputDate);
    }

    @Test
    public void doTest() {
        //read json file data to String

        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("example-response.json").toURI()));
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //convert json string to object
            FunResponse response = objectMapper.readValue(jsonData, FunResponse.class);

            for (FunObject f : response.getObjects()) {
                log.info("retrieved huis {}, adres: {}", f.getGlobalId(), f.getAdres());
                storeObject(f);
            }

            System.out.println("Response: " + response);
            System.out.println("Next page: " + response.getPaging().getVolgendeUrl());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    private void storeObject(FunObject f) {
        log.info("retrieved huis {}, adres: {}", f.getGlobalId(), f.getAdres());
        FunObjectDTO fdto = new FunObjectDTO(f);

        List<FunListDTO> fchilddto = null;
        List<FunListDTO> fopenhuisdto = null;
        FunProjectDTO fprojectdto = null;
        FunPromoLabelObjectDTO fpromo = null;
        FunPrijsDTO fpdto = null;

        //
        // If there already exists a fdto with current globalid it already exists, so do not write
        //
        FunObjectDTO existDTO = repository.findByGlobalId(f.getGlobalId());

        if (existDTO == null) {
            log.info("Object did not exist, inserting new object");
            fchilddto = fdto.getChildrenObjects();
            fopenhuisdto = fdto.getOpenHuis();
            fprojectdto = fdto.getProject();
            fpromo = fdto.getPromoLabel();
            fpdto = fdto.getPrijs();

            projectRepository.save(fprojectdto);
            promolabelRepository.save(fpromo);

            if (fchilddto != null) {
                for (FunListDTO f1 : fchilddto) {
                    f1.setFunObject(fdto);
                    listRepository.save(f1);
                }
            }
            if (fopenhuisdto != null) {
                for (FunListDTO f2 : fopenhuisdto) {
                    f2.setFunObject(fdto);
                    listRepository.save(f2);
                }
            }

            prijsRepository.save(fpdto);

            Set<FunProductListDTO> prodList = new HashSet<FunProductListDTO>();
            for (String s : f.getProducten()) {
                FunProductListDTO oldProd = productRepository.findByValue(s);
                if (null == oldProd) {
                    FunProductListDTO prod = new FunProductListDTO();
                    prod.setValue(s);
                    prod.addObject(fdto);
                    prodList.add(prod);
                    productRepository.save(prod);
                } else {
                    oldProd.addObject(fdto);
                    productRepository.save(oldProd);
                }
            }
            repository.save(fdto);
            numObjectsWritten++;
            log.info("number objects written: {}", numObjectsWritten);
        } else {
            log.info("Object did exist, globalId {} try ", f.getGlobalId());

        }
    }

}
