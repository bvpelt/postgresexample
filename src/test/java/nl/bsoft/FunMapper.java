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

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class FunMapper {
    private static final Logger log = LoggerFactory.getLogger(FunMapper.class);

    private FunObjectRepository repository;
    private FunListRepository listRepository;
    private FunProjectRepository projectRepository;
    private FunPromoLabelObjectRepository promolabelRepository;
    private FunPrijsRepository prijsRepository;

    @Autowired
    public void setRepository(FunObjectRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setListRepository(FunListRepository repository) {
        this.listRepository = repository;
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

    /*
    public static void main(String[] args) throws IOException {
        FunMapper fm = new FunMapper();
        fm.doTest();
    }
*/

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
                FunObjectDTO fdto = new FunObjectDTO(f);

                List<FunListDTO> fchilddto = fdto.getChildrenObjects();
                List<FunListDTO> fopenhuisdto = fdto.getOpenHuis();
                List<FunListDTO> fproductendto = fdto.getProducten();
                FunProjectDTO fprojectdto = fdto.getProject();
                FunPromoLabelObjectDTO fpromo = fdto.getPromoLabel();
                FunPrijsDTO fpdto = fdto.getPrijs();

                if (fchilddto != null) {
                    for (FunListDTO f1 : fchilddto) {
                        listRepository.save(f1);
                    }
                }
                if (fopenhuisdto != null) {
                    for (FunListDTO f2 : fopenhuisdto) {
                        listRepository.save(f2);
                    }
                }
                prijsRepository.save(fpdto);
                if (fproductendto != null) {
                    for (FunListDTO f3 : fproductendto) {
                        listRepository.save(f3);
                    }
                }
                projectRepository.save(fprojectdto);
                promolabelRepository.save(fpromo);

                repository.save(fdto);
            }

            System.out.println("Response: " + response);
            System.out.println("Next page: " + response.getPaging().getVolgendeUrl());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


}
