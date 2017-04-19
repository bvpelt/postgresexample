package nl.bsoft.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */
public interface FunObjectRepository extends CrudRepository<FunObjectDTO, Long> {

    List<FunObjectDTO> findByWoonOppervlakte(Integer woonOppervlakte);

    FunObjectDTO findByGlobalId(Integer globalId);
}
