package nl.bsoft.fun01;

import nl.bsoft.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bvpelt on 5/20/17.
 */

public class FunProcessor {
    private static final Logger log = LoggerFactory.getLogger(FunProcessor.class);

    private FunObjectRepository repository;
    private FunListRepository listRepository;
    private FunProductRepository productRepository;
    private FunProjectRepository projectRepository;
    private FunPromoLabelObjectRepository promolabelRepository;
    private FunPrijsRepository prijsRepository;
    private FunKoopPrijsRepository koopPrijsRepository;
    private int numObjectsWritten = 0;
    private int numObjectsUpdated = 0;
    private int status = 1; // 1 - success; -1 - failure

    /*
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
*/
    @Transactional
    public void storeObject(FunObject f) {
        log.info("storeObject -- retrieved huis {}, adres: {}", f.getGlobalId(), f.getAdres());

        try {
            //
            // If there already exists a fdto with current globalid it already exists, so do not write
            //
            FunObjectDTO existDTO = repository.findByGlobalId(f.getGlobalId());

            if (existDTO == null) {
                FunObjectDTO fdto = new FunObjectDTO(f);
                storeNewObject(f, fdto);
            } else {
                log.info("Object did exist, globalId {} try ", f.getGlobalId());
                storeExistingObject(f, existDTO);
            }
        } catch (Exception e) {
            log.error("Error during processing: {}", e);
            status = -1;
        }
    }

    private void storeNewObject(FunObject f, FunObjectDTO fdto) {
        log.info("Object did not exist, inserting new object");

        List<FunListDTO> fchilddto = fdto.getChildrenObjects();
        List<FunListDTO> fopenhuisdto = fdto.getOpenHuis();
        FunProjectDTO fprojectdto = fdto.getProject();
        FunPromoLabelObjectDTO fpromo = fdto.getPromoLabel();
        FunPrijsDTO fpdto = fdto.getPrijs();
       // List<FunKoopPrijsDTO> fkoopPrijzen = fdto.getKoopPrijzen();

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

        // No prizes recorded, insert known price
        FunKoopPrijsDTO lastKnownPrijs = new FunKoopPrijsDTO();
        lastKnownPrijs.setKoopprijs(fdto.getKoopprijs());
        lastKnownPrijs.setOpslagDatum(fdto.getPublicatieDatum());
        fdto.addKoopPrijs(lastKnownPrijs);
        koopPrijsRepository.save(lastKnownPrijs);

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
       // List<FunKoopPrijsDTO> fkoopPrijzen = oldFdto.getKoopPrijzen();

        projectRepository.save(fprojectdto);
        promolabelRepository.save(fpromo);

        for (FunListDTO f1 : fchilddto) {
            f1.setFunObject(oldFdto);
            listRepository.save(f1);
        }

        // problem mapping list or array if it already exists. fe openhuis.
        for (FunListDTO f2 : fopenhuisdto) {
            f2.setFunObject(oldFdto);
            listRepository.save(f2);
        }

        prijsRepository.save(fpdto);

        Iterator<FunProductListDTO> i = oldFdto.getProducten().iterator();
        while (i.hasNext()) {
            FunProductListDTO curProduct = i.next();
            productRepository.save(curProduct);
        }

        Pageable pageable = new PageRequest(0,1);
        List<FunKoopPrijsDTO> lastPrijs;
        lastPrijs = koopPrijsRepository.findByFunObjectIdOrderByOpslagDatumDesc(oldFdto.getId(), pageable);

        if ((null == lastPrijs) || (lastPrijs.size() == 0)){
            // No prizes recorded, insert known price
            FunKoopPrijsDTO lastKnownPrijs = new FunKoopPrijsDTO();
            lastKnownPrijs.setKoopprijs(oldFdto.getKoopprijs());
            lastKnownPrijs.setOpslagDatum(oldFdto.getPublicatieDatum());
            oldFdto.addKoopPrijs(lastKnownPrijs);
            koopPrijsRepository.save(lastKnownPrijs);
        } else {
            if (oldFdto.getKoopprijs().compareTo(lastPrijs.get(0).getKoopprijs()) != 0) {
                FunKoopPrijsDTO lastKnownPrijs = new FunKoopPrijsDTO();
                lastKnownPrijs.setKoopprijs(oldFdto.getKoopprijs());
                Date now = Calendar.getInstance().getTime();
                lastKnownPrijs.setOpslagDatum(now);
                oldFdto.addKoopPrijs(lastKnownPrijs);
                koopPrijsRepository.save(lastKnownPrijs);
            }
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

    public FunObjectRepository getRepository() {
        return repository;
    }

    public void setRepository(FunObjectRepository repository) {
        this.repository = repository;
    }

    public FunListRepository getListRepository() {
        return listRepository;
    }

    public void setListRepository(FunListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public FunProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(FunProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public FunProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(FunProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public FunPromoLabelObjectRepository getPromolabelRepository() {
        return promolabelRepository;
    }

    public void setPromolabelRepository(FunPromoLabelObjectRepository promolabelRepository) {
        this.promolabelRepository = promolabelRepository;
    }

    public FunPrijsRepository getPrijsRepository() {
        return prijsRepository;
    }

    public void setPrijsRepository(FunPrijsRepository prijsRepository) {
        this.prijsRepository = prijsRepository;
    }

    public FunKoopPrijsRepository getKoopPrijsRepository() {
        return koopPrijsRepository;
    }

    public void setKoopPrijsRepository(FunKoopPrijsRepository koopPrijsRepository) {
        this.koopPrijsRepository = koopPrijsRepository;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
