package nl.bsoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.bsoft.fun01.FunObject;
import nl.bsoft.fun01.FunProcessor;
import nl.bsoft.fun01.FunResponse;
import nl.bsoft.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

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
    private FunKoopPrijsRepository koopPrijsRepository;

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

    @Autowired
    public void setKoopPrijsRepository(FunKoopPrijsRepository repository) {
        this.koopPrijsRepository = repository;
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
        String fileName = "example-response.json";
        //String fileName = "example-response-02.json";
        //String fileName = "example-response-03.json";

        FunProcessor processor = new FunProcessor();
        processor.setRepository(repository);
        processor.setPrijsRepository(prijsRepository);
        processor.setProductRepository(productRepository);
        processor.setPromolabelRepository(promolabelRepository);
        processor.setProjectRepository(projectRepository);
        processor.setListRepository(listRepository);
        processor.setKoopPrijsRepository(koopPrijsRepository);


        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //convert json string to object
            FunResponse response = objectMapper.readValue(jsonData, FunResponse.class);

            for (FunObject f : response.getObjects()) {
                log.info("retrieved huis {}, adres: {}", f.getGlobalId(), f.getAdres());
                processor.storeObject(f);
                //storeObject(f);
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
