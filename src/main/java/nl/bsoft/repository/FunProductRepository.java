package nl.bsoft.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by bvpelt on 4/15/17.
 */
public interface FunProductRepository extends CrudRepository<FunProductListDTO, Long> {
    FunProductListDTO findById(Long Id);

    FunProductListDTO findByValue(String Value);
}
