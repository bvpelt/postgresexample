package nl.bsoft.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by bvpelt on 4/15/17.
 */
public interface FunKoopPrijsRepository extends CrudRepository<FunKoopPrijsDTO, Long> {

/*
    @Query("SELECT t FROM fun_koop_prijsdto t where t.funobject_id = :funobject_id order by t.opslag_datum desc limit 1")
    public Optional<FunKoopPrijsDTO> findLastRelatedKoopPrijs(@Param("funobject_id") Long id);
*/

    //@Query("SELECT t FROM fun_koop_prijsdto t where t.funobject_id = :funobject_id")
    public List<FunKoopPrijsDTO> findByFunObjectId(@Param("funobject_id") Long id, Pageable pageable);

    public List<FunKoopPrijsDTO> findByFunObjectIdOrderByOpslagDatumDesc(@Param("funobject_id") Long id, Pageable pageable);
}
