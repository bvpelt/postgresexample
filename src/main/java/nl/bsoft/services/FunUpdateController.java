package nl.bsoft.services;

import nl.bsoft.fun01.FunObject;
import nl.bsoft.fun01.FunReader;
import nl.bsoft.fun01.FunResponse;
import nl.bsoft.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bvpelt on 4/17/17.
 */
@RestController
public class FunUpdateController {
    private final Logger log = LoggerFactory.getLogger(FunUpdateController.class);

    private int numObjectsRead = 0;
    private int numObjectsWritten = 0;
    private int numObjectsUpdated = 0;
    private int status = -1;


    private FunObjectRepository repository;
    private FunListRepository listRepository;
    private FunProductRepository productRepository;
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


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //    @Bean
    ItemReader<FunResponse> funReader(String url,
                                      RestTemplate restTemplate) {
        return new FunReader(
                url,
                restTemplate
        );
    }

    @RequestMapping("/update")
    public FunUpdateResult update() {
        log.info("Start updating data");

        int page = 1;
        boolean goOn = true;

        while (goOn) {
            log.info("Reading page {}", page);
            FunResponse response = readFunda(page);
            if (response == null) {
                goOn = false;
            } else {
                for (FunObject f : response.getObjects()) {
                    incNumObjectsRead();
                    log.info("number objects read: {}", getNumObjectsRead());
                    storeObject(f);
                }
                page++;
                if (page > response.getPaging().getAantalPaginas().intValue()) {
                    goOn = false;
                }
            }
        }

        FunUpdateResult fur = new FunUpdateResult();
        fur.setNumObjectsRead(getNumObjectsRead());
        fur.setNumObjectsWritten(getNumObjectsWritten());
        fur.setNumObjectsUpdated(getNumObjectsUpdated());
        fur.setStatus(status);

        return fur;
    }


    private FunResponse readFunda(int page) {
        log.info("Start reading page: {}", page);

        String url = "http://partnerapi.funda.nl/feeds/Aanbod.svc/json/a001e6c3ee6e4853ab18fe44cc1494de/?type=koop&zo=/veenendaal/appartement/&page=";
        String myUrl = url + Integer.toString(page);
        ItemReader<FunResponse> reader = funReader(myUrl, restTemplate());
        FunResponse fobj = null;

        String fileName = "/tmp/funda_data.log";
        File fileOutput = new File(fileName);
        boolean append = false;
        if (fileOutput.exists()) {
            append = true;
        } else {
            try {
                fileOutput.createNewFile();
                append = true;
                log.info("Created new file: {}", fileName);
            } catch (IOException e) {
                log.error("Couldnot create file: {} {}", fileName, e);
            }
        }
        log.info("Check if file: {} exists, result: {}", fileName, append);
        FileWriter file = null;
        try {
            log.info("Writing output to file: {}, append: {}", fileName, append);
            file = new FileWriter(fileName, append);

            fobj = reader.read();
            file.write("Writing page: " + Integer.toString(page) + "\n");
            for (FunObject f : fobj.getObjects()) {
                file.write(f.toJsonString());
                file.write("\n");
            }

            log.info("Aantal paginas : {}", fobj.getPaging().getAantalPaginas());
            log.info("Huidige pagina : {}", fobj.getPaging().getHuidigePagina());
            log.info("Volgende pagina: {}", fobj.getPaging().getVolgendeUrl());
        } catch (Exception e) {
            log.error("No object found", e);
        } finally {
            try {
                file.flush();
            } catch (IOException e) {
                log.error("Cannot flush to file: {} {}", fileName, e);
            }
        }
        log.info("End   reading page: {}", page);
        return fobj;
    }

    // using transactions in spring boot http://stackoverflow.com/questions/28606518/spring-boot-spring-data-jpa-transactions-not-working-properly

    /*
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
*/

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

    public int getNumObjectsRead() {
        return numObjectsRead;
    }

    public void setNumObjectsRead(int numObjectsRead) {
        this.numObjectsRead = numObjectsRead;
    }

    public void incNumObjectsRead() {
        numObjectsRead++;
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
