package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */

public class FunProject {

    @JsonProperty(value = "AantalKamersTotEnMet")
    private Integer aantalKamersTotEnMet;               //: null,

    @JsonProperty(value = "AantalKamersVan")
    private Integer aantalKamersVan;                    //: null,

    @JsonProperty(value = "AantalKavels")
    private Integer aantalKavels;                       //: null,

    @JsonProperty(value = "Adres")
    private String adres;                               //: null,

    @JsonProperty(value = "FriendlyUrl")
    private String friendlyUrl;                         //: null,

    @JsonProperty(value = "GewijzigdDatum")
    private String gewijzigdDatum;                      //: null,

    @JsonProperty(value = "GlobalId")
    private String globalId;                            //: null,

    @JsonProperty(value = "HoofdFoto")
    private String hoofdFoto;                           //: /img/thumbs/thumb-geen-foto.gif,

    @JsonProperty(value = "IndIpix")
    private Boolean indIpix;                            //: false,

    @JsonProperty(value = "IndPDF")
    private Boolean indPDF;                             //: false,

    @JsonProperty(value = "IndPlattegrond")
    private Boolean indPlattegrond;                     //: false,

    @JsonProperty(value = "IndTop")
    private Boolean indTop;                             //: false,

    @JsonProperty(value = "IndVideo")
    private Boolean indVideo;                           //: false,

    @JsonProperty(value = "InternalId")
    private String internalId;                          //: 00000000-0000-0000-0000-000000000000,

    @JsonProperty(value = "MaxWoonoppervlakte")
    private Integer maxWoonoppervlakte;                 //: null,

    @JsonProperty(value = "MinWoonoppervlakte")
    private Integer minWoonoppervlakte;                 //: null,

    @JsonProperty(value = "Naam")
    private String naam;                                //: null,

    @JsonProperty(value = "Omschrijving")
    private String omschrijving;                        //: null,

    @JsonProperty(value = "OpenHuizen")
    private List<String> openHuizen;                    //: [],

    @JsonProperty(value = "Plaats")
    private String plaats;                              //: null,

    @JsonProperty(value = "Prijs")
    private Integer prijs;                              //: null,

    @JsonProperty(value = "PrijsGeformatteerd")
    private String prijsGeformatteerd;                  //: null,

    @JsonProperty(value = "PublicatieDatum")
    private String publicatieDatum;                     //: null,

    @JsonProperty(value = "Type")
    private Integer type;                               //: 0,

    @JsonProperty(value = "Woningtypen")
    private String woningtypen;                         //: null

    // --- Getters and Setters


    public Integer getAantalKamersTotEnMet() {
        return aantalKamersTotEnMet;
    }

    public void setAantalKamersTotEnMet(Integer aantalKamersTotEnMet) {
        this.aantalKamersTotEnMet = aantalKamersTotEnMet;
    }

    public Integer getAantalKamersVan() {
        return aantalKamersVan;
    }

    public void setAantalKamersVan(Integer aantalKamersVan) {
        this.aantalKamersVan = aantalKamersVan;
    }

    public Integer getAantalKavels() {
        return aantalKavels;
    }

    public void setAantalKavels(Integer aantalKavels) {
        this.aantalKavels = aantalKavels;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getFriendlyUrl() {
        return friendlyUrl;
    }

    public void setFriendlyUrl(String friendlyUrl) {
        this.friendlyUrl = friendlyUrl;
    }

    public String getGewijzigdDatum() {
        return gewijzigdDatum;
    }

    public void setGewijzigdDatum(String gewijzigdDatum) {
        this.gewijzigdDatum = gewijzigdDatum;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getHoofdFoto() {
        return hoofdFoto;
    }

    public void setHoofdFoto(String hoofdFoto) {
        this.hoofdFoto = hoofdFoto;
    }

    public Boolean getIndIpix() {
        return indIpix;
    }

    public void setIndIpix(Boolean indIpix) {
        this.indIpix = indIpix;
    }

    public Boolean getIndPDF() {
        return indPDF;
    }

    public void setIndPDF(Boolean indPDF) {
        this.indPDF = indPDF;
    }

    public Boolean getIndPlattegrond() {
        return indPlattegrond;
    }

    public void setIndPlattegrond(Boolean indPlattegrond) {
        this.indPlattegrond = indPlattegrond;
    }

    public Boolean getIndTop() {
        return indTop;
    }

    public void setIndTop(Boolean indTop) {
        this.indTop = indTop;
    }

    public Boolean getIndVideo() {
        return indVideo;
    }

    public void setIndVideo(Boolean indVideo) {
        this.indVideo = indVideo;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public Integer getMaxWoonoppervlakte() {
        return maxWoonoppervlakte;
    }

    public void setMaxWoonoppervlakte(Integer maxWoonoppervlakte) {
        this.maxWoonoppervlakte = maxWoonoppervlakte;
    }

    public Integer getMinWoonoppervlakte() {
        return minWoonoppervlakte;
    }

    public void setMinWoonoppervlakte(Integer minWoonoppervlakte) {
        this.minWoonoppervlakte = minWoonoppervlakte;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public List<String> getOpenHuizen() {
        return openHuizen;
    }

    public void setOpenHuizen(List<String> openHuizen) {
        this.openHuizen = openHuizen;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public Integer getPrijs() {
        return prijs;
    }

    public void setPrijs(Integer prijs) {
        this.prijs = prijs;
    }

    public String getPrijsGeformatteerd() {
        return prijsGeformatteerd;
    }

    public void setPrijsGeformatteerd(String prijsGeformatteerd) {
        this.prijsGeformatteerd = prijsGeformatteerd;
    }

    public String getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(String publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWoningtypen() {
        return woningtypen;
    }

    public void setWoningtypen(String woningtypen) {
        this.woningtypen = woningtypen;
    }
}
