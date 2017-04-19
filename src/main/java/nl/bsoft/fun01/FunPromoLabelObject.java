package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */

public class FunPromoLabelObject {
    @JsonProperty(value = "HasPromotionLabel")
    private Boolean hasPromotionLabel;    //: false,

    @JsonProperty(value = "PromotionPhotos")
    private List<String> promotionPhotos;     //: [],

    @JsonProperty(value = "PromotionPhotosSecure")
    private String promotionPhotosSecure; //: null,

    @JsonProperty(value = "PromotionType")
    private Integer promotionType;        //: 0,

    @JsonProperty(value = "RibbonColor")
    private Integer ribbonColor;          //: 0,

    @JsonProperty(value = "RibbonText")
    private String ribbonText;            //: null,

    @JsonProperty(value = "Tagline")
    private String tagline;               //: null

    // --- Getters and Setters


    public Boolean getHasPromotionLabel() {
        return hasPromotionLabel;
    }

    public void setHasPromotionLabel(Boolean hasPromotionLabel) {
        this.hasPromotionLabel = hasPromotionLabel;
    }

    public List<String> getPromotionPhotos() {
        return promotionPhotos;
    }

    public void setPromotionPhotos(List<String> promotionPhotos) {
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
