package nl.bsoft.fun01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */

public class FunObject {
    private final Logger log = LoggerFactory.getLogger(FunObject.class);

    @JsonProperty(value = "AangebodenSindsTekst")
    private String aangebodenSindsTekst;         // : 2 weken,

    @JsonProperty(value = "AanmeldDatum")
    private String aanmeldDatum;                 // : /Date(1262300400000+0100)/,

    @JsonProperty(value = "AantalKamers")
    private Integer aantalKamers;                // : 3,

    @JsonProperty(value = "AantalKavels")
    private Integer aantalKavels;                //: null,

    @JsonProperty(value = "Adres")
    private String adres;                        //: Dr. Colijnstraat 15 B,

    @JsonProperty(value = "Afstand")
    private Integer afstand;                     //: 0,

    @JsonProperty(value = "BronCode")
    private String bronCode;                     //: NVM,

    @JsonProperty(value = "ChildrenObjects")
    private List<String> childrenObjects;        //: [],

    @JsonProperty(value = "DatumOndertekeningAkte")
    private String datumOndertekeningAkte;       //: null,

    @JsonProperty(value = "Foto")
    private String foto;                         //: http://cloud.funda.nl/valentina_media/078/540/166_klein.jpg,

    @JsonProperty(value = "FotoLarge")
    private String fotoLarge;                    //: http://cloud.funda.nl/valentina_media/078/540/166_groot.jpg,

    @JsonProperty(value = "FotoLargest")
    private String fotoLargest;                  //: http://cloud.funda.nl/valentina_media/078/540/166_grotere.jpg,

    @JsonProperty(value = "FotoMedium")
    private String fotoMedium;                   //: http://cloud.funda.nl/valentina_media/078/540/166_middel.jpg,

    @JsonProperty(value = "FotoSecure")
    private String fotoSecure;                   //: http://cloud.funda.nl/valentina_media/078/540/166_klein.jpg,

    @JsonProperty(value = "GewijzigdDatum")
    private String gewijzigdDatum;               //: null,

    @JsonProperty(value = "GlobalId")
    private Integer globalId;                    //: 3743895,

    @JsonProperty(value = "GroupByObjectType")
    private String groupByObjectType;            //: 7ec20275-185a-488c-9c84-9ebb08f2e23c,

    @JsonProperty(value = "Heeft360GradenFoto")
    private Boolean heeft360GradenFoto;          //: true,

    @JsonProperty(value = "HeeftBrochure")
    private Boolean heeftBrochure;               //: true,

    @JsonProperty(value = "HeeftOpenhuizenTopper")
    private Boolean heeftOpenhuizenTopper;       //: false,

    @JsonProperty(value = "HeeftOverbruggingsgrarantie")
    private Boolean heeftOverbruggingsgrarantie; //: false,

    @JsonProperty(value = "HeeftPlattegrond")
    private Boolean heeftPlattegrond;            //: true,

    @JsonProperty(value = "HeeftTophuis")
    private Boolean heeftTophuis;                //: false,

    @JsonProperty(value = "HeeftVeiling")
    private Boolean heeftVeiling;                //: false,

    @JsonProperty(value = "HeeftVideo")
    private Boolean heeftVideo;                  //: true,

    @JsonProperty(value = "HuurPrijsTot")
    private Integer huurPrijsTot;                //: null,

    @JsonProperty(value = "Huurprijs")
    private Integer huurprijs;                   //: null,

    @JsonProperty(value = "HuurprijsFormaat")
    private String huurprijsFormaat;             //: null,

    @JsonProperty(value = "Id")
    private String uuid;                           //: 7ec20275-185a-488c-9c84-9ebb08f2e23c,

    @JsonProperty(value = "InUnitsVanaf")
    private String inUnitsVanaf;                 //: null,

    @JsonProperty(value = "IndProjectObjectType")
    private Boolean indProjectObjectType;        //: false,

    @JsonProperty(value = "IndTransactieMakelaarTonen")
    private String indTransactieMakelaarTonen;   //: null,

    @JsonProperty(value = "IsSearchable")
    private Boolean isSearchable;                //: true,

    @JsonProperty(value = "IsVerhuurd")
    private Boolean isVerhuurd;                  //: false,

    @JsonProperty(value = "IsVerkocht")
    private Boolean isVerkocht;                  //: false,

    @JsonProperty(value = "IsVerkochtOfVerhuurd")
    private Boolean isVerkochtOfVerhuurd;        //: false,

    @JsonProperty(value = "Koopprijs")
    private Integer koopprijs;                   //: 209000,

    @JsonProperty(value = "KoopprijsFormaat")
    private String koopprijsFormaat;             //: <[KoopPrijs]> <{kosten koper|kort}>,

    @JsonProperty(value = "KoopprijsTot")
    private Integer koopprijsTot;                //: 209000,

    @JsonProperty(value = "MakelaarId")
    private Integer makelaarId;                  //: 18140,

    @JsonProperty(value = "MakelaarNaam")
    private String makelaarNaam;                 //: Van Dijk Van Essen,

    @JsonProperty(value = "MobileURL")
    private String mobileURL;                    //: http://m.funda.nl/obj.aspx?goi=3743895,

    @JsonProperty(value = "Note")
    private String note;                         //: null,

    @JsonProperty(value = "OpenHuis")
    private List<String> openHuis;               //: [],

    @JsonProperty(value = "Oppervlakte")
    private Integer oppervlakte;                 //: 0,

    @JsonProperty(value = "Perceeloppervlakte")
    private String perceeloppervlakte;           //: null,

    @JsonProperty(value = "Postcode")
    private String postcode;                     //: 3904EL,

    @JsonProperty(value = "Prijs")
    private FunPrijs prijs;                   /*:
        GeenExtraKosten: false,
        HuurAbbreviation: ,
        Huurprijs: null,
        HuurprijsOpAanvraag: ,
        HuurprijsTot: null,
        KoopAbbreviation: k.k.,
        Koopprijs: 209000,
        KoopprijsOpAanvraag: ,
        KoopprijsTot: 209000,
        OriginelePrijs: null,
        VeilingText:
    */

    @JsonProperty(value = "PrijsGeformatteerdHtml")
    private String prijsGeformatteerdHtml;       //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    @JsonProperty(value = "PrijsGeformatteerdTextHuur")
    private String prijsGeformatteerdTextHuur;   //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    @JsonProperty(value = "PrijsGeformatteerdTextKoop")
    private String prijsGeformatteerdTextKoop;   //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    @JsonProperty(value = "Producten")
    private List<String> producten;              //: [Video,Plattegrond,360-fotos,Brochure],

    @JsonProperty(value = "Project")
    private FunProject project;               /*:          {
        AantalKamersTotEnMet: null,
        AantalKamersVan: null,
        AantalKavels: null,
        Adres: null,
        FriendlyUrl: null,
        GewijzigdDatum: null,
        GlobalId: null,
        HoofdFoto: /img/thumbs/thumb-geen-foto.gif,
        IndIpix: false,
        IndPDF: false,
        IndPlattegrond: false,
        IndTop: false,
        IndVideo: false,
        InternalId: 00000000-0000-0000-0000-000000000000,
        MaxWoonoppervlakte: null,
        MinWoonoppervlakte: null,
        Naam: null,
        Omschrijving: null,
        OpenHuizen: [],
        Plaats: null,
        Prijs: null,
        PrijsGeformatteerd: null,
        PublicatieDatum: null,
        Type: 0,
        Woningtypen: null
    },*/

    @JsonProperty(value = "ProjectNaam")
    private String projectNaam;            //: null,

    @JsonProperty(value = "PromoLabel")
    private FunPromoLabelObject promoLabel;   /* :          {
        HasPromotionLabel: false,
        PromotionPhotos: [],
        PromotionPhotosSecure: null,
        PromotionType: 0,
        RibbonColor: 0,
        RibbonText: null,
        Tagline: null
    },*/

    @JsonProperty(value = "PublicatieDatum")
    private String publicatieDatum;         //: /Date(1490830506000+0200)/,

    @JsonProperty(value = "PublicatieStatus")
    private Integer publicatieStatus;       //: 0,

    @JsonProperty(value = "SavedDate")
    private String savedDate;               //: null,

    @JsonProperty(value = "Soort-aanbod")
    private String soortAanbod;            //: appartement,

    @JsonProperty(value = "SoortAanbod")
    private Integer soortAanbodType;            //: 10,

    @JsonProperty(value = "StartOplevering")
    private String startOplevering;         //: null,

    @JsonProperty(value = "TimeAgoText")
    private String timeAgoText;             //: null,

    @JsonProperty(value = "TransactieAfmeldDatum")
    private String transactieAfmeldDatum;   //: null,

    @JsonProperty(value = "TransactieMakelaarId")
    private String transactieMakelaarId;    //: null,

    @JsonProperty(value = "TransactieMakelaarNaam")
    private String transactieMakelaarNaam;  //: null,

    @JsonProperty(value = "TypeProject")
    private Integer typeProject;            //: 0,

    @JsonProperty(value = "URL")
    private String uRL;                     //: http://www.funda.nl/koop/veenendaal/appartement-49198258-dr-colijnstraat-15-b/,

    @JsonProperty(value = "VerkoopStatus")
    private String verkoopStatus;           //: StatusBeschikbaar,

    @JsonProperty(value = "WGS84_X")
    private Double wGS84_X;                 //: 5.541398,

    @JsonProperty(value = "WGS84_Y")
    private Double wGS84_Y;                 //: 52.01925,

    @JsonProperty(value = "WoonOppervlakteTot")
    private Integer woonOppervlakteTot;     //: 80,

    @JsonProperty(value = "Woonoppervlakte")
    private Integer woonOppervlakte;        //: 80,

    @JsonProperty(value = "Woonplaats")
    private String woonPlaats;              //: Veenendaal,

    @JsonProperty(value = "ZoekType")
    private Integer[] zoekType;             //: [10]

    public String toJsonString() {
        String json = null;

        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("Cannot generate json: ", e);
        }

        return json;
    }

    // -- Getters and Setters


    public String getAangebodenSindsTekst() {
        return aangebodenSindsTekst;
    }

    public void setAangebodenSindsTekst(String aangebodenSindsTekst) {
        this.aangebodenSindsTekst = aangebodenSindsTekst;
    }

    public String getAanmeldDatum() {
        return aanmeldDatum;
    }

    public void setAanmeldDatum(String aanmeldDatum) {
        this.aanmeldDatum = aanmeldDatum;
    }

    public Integer getAantalKamers() {
        return aantalKamers;
    }

    public void setAantalKamers(Integer aantalKamers) {
        this.aantalKamers = aantalKamers;
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

    public Integer getAfstand() {
        return afstand;
    }

    public void setAfstand(Integer afstand) {
        this.afstand = afstand;
    }

    public String getBronCode() {
        return bronCode;
    }

    public void setBronCode(String bronCode) {
        this.bronCode = bronCode;
    }

    public List<String> getChildrenObjects() {
        return childrenObjects;
    }

    public void setChildrenObjects(List<String> childrenObjects) {
        this.childrenObjects = childrenObjects;
    }

    public String getDatumOndertekeningAkte() {
        return datumOndertekeningAkte;
    }

    public void setDatumOndertekeningAkte(String datumOndertekeningAkte) {
        this.datumOndertekeningAkte = datumOndertekeningAkte;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoLarge() {
        return fotoLarge;
    }

    public void setFotoLarge(String fotoLarge) {
        this.fotoLarge = fotoLarge;
    }

    public String getFotoLargest() {
        return fotoLargest;
    }

    public void setFotoLargest(String fotoLargest) {
        this.fotoLargest = fotoLargest;
    }

    public String getFotoMedium() {
        return fotoMedium;
    }

    public void setFotoMedium(String fotoMedium) {
        this.fotoMedium = fotoMedium;
    }

    public String getFotoSecure() {
        return fotoSecure;
    }

    public void setFotoSecure(String fotoSecure) {
        this.fotoSecure = fotoSecure;
    }

    public String getGewijzigdDatum() {
        return gewijzigdDatum;
    }

    public void setGewijzigdDatum(String gewijzigdDatum) {
        this.gewijzigdDatum = gewijzigdDatum;
    }

    public Integer getGlobalId() {
        return globalId;
    }

    public void setGlobalId(Integer globalId) {
        this.globalId = globalId;
    }

    public String getGroupByObjectType() {
        return groupByObjectType;
    }

    public void setGroupByObjectType(String groupByObjectType) {
        this.groupByObjectType = groupByObjectType;
    }

    public Boolean getHeeft360GradenFoto() {
        return heeft360GradenFoto;
    }

    public void setHeeft360GradenFoto(Boolean heeft360GradenFoto) {
        this.heeft360GradenFoto = heeft360GradenFoto;
    }

    public Boolean getHeeftBrochure() {
        return heeftBrochure;
    }

    public void setHeeftBrochure(Boolean heeftBrochure) {
        this.heeftBrochure = heeftBrochure;
    }

    public Boolean getHeeftOpenhuizenTopper() {
        return heeftOpenhuizenTopper;
    }

    public void setHeeftOpenhuizenTopper(Boolean heeftOpenhuizenTopper) {
        this.heeftOpenhuizenTopper = heeftOpenhuizenTopper;
    }

    public Boolean getHeeftOverbruggingsgrarantie() {
        return heeftOverbruggingsgrarantie;
    }

    public void setHeeftOverbruggingsgrarantie(Boolean heeftOverbruggingsgrarantie) {
        this.heeftOverbruggingsgrarantie = heeftOverbruggingsgrarantie;
    }

    public Boolean getHeeftPlattegrond() {
        return heeftPlattegrond;
    }

    public void setHeeftPlattegrond(Boolean heeftPlattegrond) {
        this.heeftPlattegrond = heeftPlattegrond;
    }

    public Boolean getHeeftTophuis() {
        return heeftTophuis;
    }

    public void setHeeftTophuis(Boolean heeftTophuis) {
        this.heeftTophuis = heeftTophuis;
    }

    public Boolean getHeeftVeiling() {
        return heeftVeiling;
    }

    public void setHeeftVeiling(Boolean heeftVeiling) {
        this.heeftVeiling = heeftVeiling;
    }

    public Boolean getHeeftVideo() {
        return heeftVideo;
    }

    public void setHeeftVideo(Boolean heeftVideo) {
        this.heeftVideo = heeftVideo;
    }

    public Integer getHuurPrijsTot() {
        return huurPrijsTot;
    }

    public void setHuurPrijsTot(Integer huurPrijsTot) {
        this.huurPrijsTot = huurPrijsTot;
    }

    public Integer getHuurprijs() {
        return huurprijs;
    }

    public void setHuurprijs(Integer huurprijs) {
        this.huurprijs = huurprijs;
    }

    public String getHuurprijsFormaat() {
        return huurprijsFormaat;
    }

    public void setHuurprijsFormaat(String huurprijsFormaat) {
        this.huurprijsFormaat = huurprijsFormaat;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInUnitsVanaf() {
        return inUnitsVanaf;
    }

    public void setInUnitsVanaf(String inUnitsVanaf) {
        this.inUnitsVanaf = inUnitsVanaf;
    }

    public Boolean getIndProjectObjectType() {
        return indProjectObjectType;
    }

    public void setIndProjectObjectType(Boolean indProjectObjectType) {
        this.indProjectObjectType = indProjectObjectType;
    }

    public String getIndTransactieMakelaarTonen() {
        return indTransactieMakelaarTonen;
    }

    public void setIndTransactieMakelaarTonen(String indTransactieMakelaarTonen) {
        this.indTransactieMakelaarTonen = indTransactieMakelaarTonen;
    }

    public Boolean getSearchable() {
        return isSearchable;
    }

    public void setSearchable(Boolean searchable) {
        isSearchable = searchable;
    }

    public Boolean getVerhuurd() {
        return isVerhuurd;
    }

    public void setVerhuurd(Boolean verhuurd) {
        isVerhuurd = verhuurd;
    }

    public Boolean getVerkocht() {
        return isVerkocht;
    }

    public void setVerkocht(Boolean verkocht) {
        isVerkocht = verkocht;
    }

    public Boolean getVerkochtOfVerhuurd() {
        return isVerkochtOfVerhuurd;
    }

    public void setVerkochtOfVerhuurd(Boolean verkochtOfVerhuurd) {
        isVerkochtOfVerhuurd = verkochtOfVerhuurd;
    }

    public Integer getKoopprijs() {
        return koopprijs;
    }

    public void setKoopprijs(Integer koopprijs) {
        this.koopprijs = koopprijs;
    }

    public String getKoopprijsFormaat() {
        return koopprijsFormaat;
    }

    public void setKoopprijsFormaat(String koopprijsFormaat) {
        this.koopprijsFormaat = koopprijsFormaat;
    }

    public Integer getKoopprijsTot() {
        return koopprijsTot;
    }

    public void setKoopprijsTot(Integer koopprijsTot) {
        this.koopprijsTot = koopprijsTot;
    }

    public Integer getMakelaarId() {
        return makelaarId;
    }

    public void setMakelaarId(Integer makelaarId) {
        this.makelaarId = makelaarId;
    }

    public String getMakelaarNaam() {
        return makelaarNaam;
    }

    public void setMakelaarNaam(String makelaarNaam) {
        this.makelaarNaam = makelaarNaam;
    }

    public String getMobileURL() {
        return mobileURL;
    }

    public void setMobileURL(String mobileURL) {
        this.mobileURL = mobileURL;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getOpenHuis() {
        return openHuis;
    }

    public void setOpenHuis(List<String> openHuis) {
        this.openHuis = openHuis;
    }

    public Integer getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(Integer oppervlakte) {
        this.oppervlakte = oppervlakte;
    }

    public String getPerceeloppervlakte() {
        return perceeloppervlakte;
    }

    public void setPerceeloppervlakte(String perceeloppervlakte) {
        this.perceeloppervlakte = perceeloppervlakte;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public FunPrijs getPrijs() {
        return prijs;
    }

    public void setPrijs(FunPrijs prijs) {
        this.prijs = prijs;
    }

    public String getPrijsGeformatteerdHtml() {
        return prijsGeformatteerdHtml;
    }

    public void setPrijsGeformatteerdHtml(String prijsGeformatteerdHtml) {
        this.prijsGeformatteerdHtml = prijsGeformatteerdHtml;
    }

    public String getPrijsGeformatteerdTextHuur() {
        return prijsGeformatteerdTextHuur;
    }

    public void setPrijsGeformatteerdTextHuur(String prijsGeformatteerdTextHuur) {
        this.prijsGeformatteerdTextHuur = prijsGeformatteerdTextHuur;
    }

    public String getPrijsGeformatteerdTextKoop() {
        return prijsGeformatteerdTextKoop;
    }

    public void setPrijsGeformatteerdTextKoop(String prijsGeformatteerdTextKoop) {
        this.prijsGeformatteerdTextKoop = prijsGeformatteerdTextKoop;
    }

    public List<String> getProducten() {
        return producten;
    }

    public void setProducten(List<String> producten) {
        this.producten = producten;
    }

    public FunProject getProject() {
        return project;
    }

    public void setProject(FunProject project) {
        this.project = project;
    }

    public String getProjectNaam() {
        return projectNaam;
    }

    public void setProjectNaam(String projectNaam) {
        this.projectNaam = projectNaam;
    }

    public FunPromoLabelObject getPromoLabel() {
        return promoLabel;
    }

    public void setPromoLabel(FunPromoLabelObject promoLabel) {
        this.promoLabel = promoLabel;
    }

    public String getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(String publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public Integer getPublicatieStatus() {
        return publicatieStatus;
    }

    public void setPublicatieStatus(Integer publicatieStatus) {
        this.publicatieStatus = publicatieStatus;
    }

    public String getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(String savedDate) {
        this.savedDate = savedDate;
    }


    public String getSoortAanbod() {
        return soortAanbod;
    }

    public void setSoortAanbod(String soortAanbod) {
        this.soortAanbod = soortAanbod;
    }

    public Integer getSoortAanbodType() {
        return soortAanbodType;
    }

    public void setSoortAanbodType(Integer soortAanbodType) {
        this.soortAanbodType = soortAanbodType;
    }

    public String getStartOplevering() {
        return startOplevering;
    }

    public void setStartOplevering(String startOplevering) {
        this.startOplevering = startOplevering;
    }

    public String getTimeAgoText() {
        return timeAgoText;
    }

    public void setTimeAgoText(String timeAgoText) {
        this.timeAgoText = timeAgoText;
    }

    public String getTransactieAfmeldDatum() {
        return transactieAfmeldDatum;
    }

    public void setTransactieAfmeldDatum(String transactieAfmeldDatum) {
        this.transactieAfmeldDatum = transactieAfmeldDatum;
    }

    public String getTransactieMakelaarId() {
        return transactieMakelaarId;
    }

    public void setTransactieMakelaarId(String transactieMakelaarId) {
        this.transactieMakelaarId = transactieMakelaarId;
    }

    public String getTransactieMakelaarNaam() {
        return transactieMakelaarNaam;
    }

    public void setTransactieMakelaarNaam(String transactieMakelaarNaam) {
        this.transactieMakelaarNaam = transactieMakelaarNaam;
    }

    public Integer getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(Integer typeProject) {
        this.typeProject = typeProject;
    }

    public String getuRL() {
        return uRL;
    }

    public void setuRL(String uRL) {
        this.uRL = uRL;
    }

    public String getVerkoopStatus() {
        return verkoopStatus;
    }

    public void setVerkoopStatus(String verkoopStatus) {
        this.verkoopStatus = verkoopStatus;
    }

    public Double getwGS84_X() {
        return wGS84_X;
    }

    public void setwGS84_X(Double wGS84_X) {
        this.wGS84_X = wGS84_X;
    }

    public Double getwGS84_Y() {
        return wGS84_Y;
    }

    public void setwGS84_Y(Double wGS84_Y) {
        this.wGS84_Y = wGS84_Y;
    }

    public Integer getWoonOppervlakteTot() {
        return woonOppervlakteTot;
    }

    public void setWoonOppervlakteTot(Integer woonOppervlakteTot) {
        this.woonOppervlakteTot = woonOppervlakteTot;
    }

    public Integer getWoonOppervlakte() {
        return woonOppervlakte;
    }

    public void setWoonOppervlakte(Integer woonOppervlakte) {
        this.woonOppervlakte = woonOppervlakte;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }

    public Integer[] getZoekType() {
        return zoekType;
    }

    public void setZoekType(Integer[] zoekType) {
        this.zoekType = zoekType;
    }
}
