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
import java.util.*;

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
    private int numObjectsUpdated = 0;

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

        //String fileName = "example-response-01.json";
        //String fileName = "example-response.json";
        String fileName = "example-response-02.json";

        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
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
        log.info("storeObject -- retrieved huis {}, adres: {}", f.getGlobalId(), f.getAdres());
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
            storeNewObject(f, fdto);
        } else {
            log.info("Object did exist, globalId {} try ", f.getGlobalId());
            storeExistingObject(f, existDTO);
        }
    }

    private void storeNewObject(FunObject f, FunObjectDTO fdto) {
        log.info("Object did not exist, inserting new object");

        List<FunListDTO> fchilddto = fdto.getChildrenObjects();
        List<FunListDTO> fopenhuisdto = fdto.getOpenHuis();
        FunProjectDTO fprojectdto = fdto.getProject();
        FunPromoLabelObjectDTO fpromo = fdto.getPromoLabel();
        FunPrijsDTO fpdto = fdto.getPrijs();

        projectRepository.save(fprojectdto);
        promolabelRepository.save(fpromo);

        for (FunListDTO f1 : fchilddto) {
            f1.setFunObject(fdto);
            listRepository.save(f1);
        }

        for (FunListDTO f2 : fopenhuisdto) {
            f2.setFunObject(fdto);
            listRepository.save(f2);
        }

        prijsRepository.save(fpdto);

        Iterator<FunProductListDTO> i = fdto.getProducten().iterator();
        while (i.hasNext()) {
            FunProductListDTO curProduct = i.next();
            productRepository.save(curProduct);
        }

        repository.save(fdto);
        incNumObjectsWritten();
        log.info("number objects written: {}", getNumObjectsWritten());
    }

    private void storeExistingObject(FunObject f, FunObjectDTO oldFdto) {
        log.info("Object existed, update object");

        oldFdto.updateObject(f);
        List<FunListDTO> fchilddto = oldFdto.getChildrenObjects();
        List<FunListDTO> fopenhuisdto = oldFdto.getOpenHuis();
        FunProjectDTO fprojectdto = oldFdto.getProject();
        FunPromoLabelObjectDTO fpromo = oldFdto.getPromoLabel();
        FunPrijsDTO fpdto = oldFdto.getPrijs();

        projectRepository.save(fprojectdto);
        promolabelRepository.save(fpromo);

        for (FunListDTO f1 : fchilddto) {
            listRepository.save(f1);
        }

        // problem mapping list or array if it already exists. fe openhuis.
        for (FunListDTO f2 : fopenhuisdto) {
            listRepository.save(f2);
        }

        prijsRepository.save(fpdto);

        Iterator<FunProductListDTO> i = oldFdto.getProducten().iterator();
        while (i.hasNext()) {
            FunProductListDTO curProduct = i.next();
            productRepository.save(curProduct);
        }

        repository.save(oldFdto);
        incNumObjectsUpdated();
        log.info("number objects updated: {}", getNumObjectsUpdated());
    }

    public void incNumObjectsWritten() {
        numObjectsWritten++;
    }

    public int getNumObjectsWritten() {
        return numObjectsWritten;
    }

    public void setNumObjectsWritten(int numObjectsWritten) {
        this.numObjectsWritten = numObjectsWritten;
    }

    public void incNumObjectsUpdated() {
        numObjectsUpdated++;
    }

    public int getNumObjectsUpdated() {
        return numObjectsUpdated;
    }

    public void setNumObjectsUpdated(int numObjectsUpdated) {
        this.numObjectsUpdated = numObjectsUpdated;
    }
}
