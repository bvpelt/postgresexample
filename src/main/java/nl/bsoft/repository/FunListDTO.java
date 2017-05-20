package nl.bsoft.repository;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.*;


/**
 * Created by bvpelt on 4/17/17.
 */
@Entity
public class FunListDTO implements Serializable {
    @GenericGenerator(
            name = "listSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "LIST_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "listSequenceGenerator")
    @Column(name = "LIST_ID")
    private Long id;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name = "FUNOBJECT_ID")
    private FunObjectDTO funObject;

    public FunListDTO() {

    }

    // -- Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FunObjectDTO getFunObject() {
        return funObject;
    }

    public void setFunObject(FunObjectDTO funObject) {
        this.funObject = funObject;
    }


}
