package nl.bsoft.repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.CascadeType.*;

/**
 * Created by bvpelt on 5/6/17.
 * <p>
 * Purpose:
 * Get price of a harvested object when date changes.
 */
@Entity
public class FunKoopPrijsDTO implements Serializable {
    @GenericGenerator(
            name = "koopPrijsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "KOOPPRIJS_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "koopPrijsSequenceGenerator")
    @Column(name = "FUNKOOPPRIJS_ID")
    private Long id;

    private Date opslagDatum;

    private Integer koopprijs;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "FUNOBJECT_ID")
    private FunObjectDTO funObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpslagDatum() {
        return opslagDatum;
    }

    public void setOpslagDatum(Date opslagDatum) {
        this.opslagDatum = opslagDatum;
    }

    public Integer getKoopprijs() {
        return koopprijs;
    }

    public void setKoopprijs(Integer koopprijs) {
        this.koopprijs = koopprijs;
    }

    public FunObjectDTO getFunObject() {
        return funObject;
    }

    public void setFunObject(FunObjectDTO funObject) {
        this.funObject = funObject;
    }
}
