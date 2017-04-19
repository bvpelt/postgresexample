package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bvpelt on 4/15/17.
 */

public class FunPrijs {

    @JsonProperty(value = "GeenExtraKosten")
    private Boolean geenExtraKosten;        //: false,

    @JsonProperty(value = "HuurAbbreviation")
    private String huurAbbreviation;        //: ,

    @JsonProperty(value = "Huurprijs")
    private Integer huurprijs;              //: null,

    @JsonProperty(value = "HuurprijsOpAanvraag")
    private String huurprijsOpAanvraag;     //: ,

    @JsonProperty(value = "HuurprijsTot")
    private Integer huurprijsTot;           //: null,

    @JsonProperty(value = "KoopAbbreviation")
    private String koopAbbreviation;        //: k.k.,

    @JsonProperty(value = "Koopprijs")
    private Integer koopprijs;              //: 209000,

    @JsonProperty(value = "KoopprijsOpAanvraag")
    private String koopprijsOpAanvraag;     //: ,

    @JsonProperty(value = "KoopprijsTot")
    private Integer koopprijsTot;           //: 209000,

    @JsonProperty(value = "OriginelePrijs")
    private Integer originelePrijs;         //: null,

    @JsonProperty(value = "VeilingText")
    private String veilingText;             //:

    // --- Getters and Setters


    public Boolean getGeenExtraKosten() {
        return geenExtraKosten;
    }

    public void setGeenExtraKosten(Boolean geenExtraKosten) {
        this.geenExtraKosten = geenExtraKosten;
    }

    public String getHuurAbbreviation() {
        return huurAbbreviation;
    }

    public void setHuurAbbreviation(String huurAbbreviation) {
        this.huurAbbreviation = huurAbbreviation;
    }

    public Integer getHuurprijs() {
        return huurprijs;
    }

    public void setHuurprijs(Integer huurprijs) {
        this.huurprijs = huurprijs;
    }

    public String getHuurprijsOpAanvraag() {
        return huurprijsOpAanvraag;
    }

    public void setHuurprijsOpAanvraag(String huurprijsOpAanvraag) {
        this.huurprijsOpAanvraag = huurprijsOpAanvraag;
    }

    public Integer getHuurprijsTot() {
        return huurprijsTot;
    }

    public void setHuurprijsTot(Integer huurprijsTot) {
        this.huurprijsTot = huurprijsTot;
    }

    public String getKoopAbbreviation() {
        return koopAbbreviation;
    }

    public void setKoopAbbreviation(String koopAbbreviation) {
        this.koopAbbreviation = koopAbbreviation;
    }

    public Integer getKoopprijs() {
        return koopprijs;
    }

    public void setKoopprijs(Integer koopprijs) {
        this.koopprijs = koopprijs;
    }

    public String getKoopprijsOpAanvraag() {
        return koopprijsOpAanvraag;
    }

    public void setKoopprijsOpAanvraag(String koopprijsOpAanvraag) {
        this.koopprijsOpAanvraag = koopprijsOpAanvraag;
    }

    public Integer getKoopprijsTot() {
        return koopprijsTot;
    }

    public void setKoopprijsTot(Integer koopprijsTot) {
        this.koopprijsTot = koopprijsTot;
    }

    public Integer getOriginelePrijs() {
        return originelePrijs;
    }

    public void setOriginelePrijs(Integer originelePrijs) {
        this.originelePrijs = originelePrijs;
    }

    public String getVeilingText() {
        return veilingText;
    }

    public void setVeilingText(String veilingText) {
        this.veilingText = veilingText;
    }
}
