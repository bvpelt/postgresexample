package nl.bsoft.repository;

import nl.bsoft.fun01.FunPromoLabelObject;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */
@Entity
public class FunPromoLabelObjectDTO implements Serializable {
    @GenericGenerator(
            name = "promoLabelSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "PROMOLABEL_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "promoLabelSequenceGenerator")
    @Column(name = "PROMOLABEL_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "promoLabel")
    private FunObjectDTO funObject;

    private Boolean hasPromotionLabel;    //: false,

    @OneToMany(mappedBy = "promoLabelObject")
    private List<FunPhotoListDTO> promotionPhotos;     //: [],

    private String promotionPhotosSecure; //: null,

    private Integer promotionType;        //: 0,

    private Integer ribbonColor;          //: 0,

    private String ribbonText;            //: null,

    private String tagline;               //: null

    public FunPromoLabelObjectDTO() {
    }

    public FunPromoLabelObjectDTO(FunPromoLabelObject f) {
        setHasPromotionLabel(f.getHasPromotionLabel());

        List<String> fls_p = f.getPromotionPhotos();
        List<FunPhotoListDTO> fld_p = null;
        if ((fls_p != null) && (fls_p.size() > 0)) {
            fld_p = new ArrayList<FunPhotoListDTO>();
            for (String s : fls_p) {
                FunPhotoListDTO fod = new FunPhotoListDTO();
                fod.setValue(s);
                fld_p.add(fod);
            }
        }
        setPromotionPhotos(fld_p);
        setPromotionPhotosSecure(f.getPromotionPhotosSecure());
        setPromotionType(f.getPromotionType());
        setRibbonColor(f.getRibbonColor());
        setRibbonText(f.getRibbonText());
        setTagline(f.getTagline());
    }

    // --- Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FunObjectDTO getFunObject() {
        return funObject;
    }

    public void setFunObject(FunObjectDTO funObject) {
        this.funObject = funObject;
    }

    public Boolean getHasPromotionLabel() {
        return hasPromotionLabel;
    }

    public void setHasPromotionLabel(Boolean hasPromotionLabel) {
        this.hasPromotionLabel = hasPromotionLabel;
    }

    public List<FunPhotoListDTO> getPromotionPhotos() {
        return promotionPhotos;
    }

    public void setPromotionPhotos(List<FunPhotoListDTO> promotionPhotos) {
        this.promotionPhotos = promotionPhotos;
    }

    public String getPromotionPhotosSecure() {
        return promotionPhotosSecure;
    }

    public void setPromotionPhotosSecure(String promotionPhotosSecure) {
        this.promotionPhotosSecure = promotionPhotosSecure;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getRibbonColor() {
        return ribbonColor;
    }

    public void setRibbonColor(Integer ribbonColor) {
        this.ribbonColor = ribbonColor;
    }

    public String getRibbonText() {
        return ribbonText;
    }

    public void setRibbonText(String ribbonText) {
        this.ribbonText = ribbonText;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
