package nl.bsoft.repository;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


/**
 * Created by bvpelt on 4/17/17.
 */
@Entity
public class FunPhotoListDTO {
    @GenericGenerator(
            name = "photoListSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "PHOTOLIST_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "photoListSequenceGenerator")
    @Column(name = "PHOTO_ID")
    private Long id;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private FunPromoLabelObjectDTO promoLabelObject;

    // --- Getters and Setters

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

    public FunPromoLabelObjectDTO getPromoLabelObject() {
        return promoLabelObject;
    }

    public void setPromoLabelObject(FunPromoLabelObjectDTO promoLabelObject) {
        this.promoLabelObject = promoLabelObject;
    }
}
