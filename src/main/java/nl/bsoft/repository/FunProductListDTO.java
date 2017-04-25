package nl.bsoft.repository;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by bvpelt on 4/17/17.
 */
@Entity
public class FunProductListDTO {
    @Transient
    private final Logger log = LoggerFactory.getLogger(FunProductListDTO.class);

    @GenericGenerator(
            name = "productListSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "PRODUCT_LIST_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "productListSequenceGenerator")
    @Column(name = "FUN_PRODUCTLIST_ID")
    private Long id;
    private String value;

    @ManyToMany(mappedBy = "producten", fetch = FetchType.EAGER)
    private Set<FunObjectDTO> funObjecten = new HashSet<FunObjectDTO>();

    public FunProductListDTO() {

    }

    public void addObject(FunObjectDTO object) {
        // prevent endless loop
        if (funObjecten.contains(object)) {
            return;
        }
        // add new follower
        funObjecten.add(object);
        // set myset into object
        object.addProduct(this);
    }

    public void removeObject(FunObjectDTO object) {
        // prevent endless loop
        if (!funObjecten.contains(object))
            return;
        // remove the object
        funObjecten.remove(object);
        // remove myself from the object
        object.removeProduct(this);
    }

    public Long getId() {
        return id;
    }


    // --- Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        log.info("Set value: {} for id: {}", value, id);

        Set<FunObjectDTO> allFunObjecten = new HashSet<FunObjectDTO>(funObjecten);

        for (FunObjectDTO f : allFunObjecten) {
            log.info("Set value: {} for id: {} removed object: {} with id: {}", value, id, f, f.getId());
            f.removeProduct(this);
        }

        this.value = value;

        for (FunObjectDTO f : allFunObjecten) {
            log.info("Set value: {} for id: {} add product to object: {} with id: {}", value, id, f, f.getId());
            f.addProduct(this);
        }
    }

    public Set<FunObjectDTO> getFunObjecten() {
        return funObjecten;
    }

    public void setFunObjecten(Set<FunObjectDTO> funObjecten) {
        this.funObjecten = funObjecten;
    }
}
