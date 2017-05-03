package nl.bsoft.repository;

import nl.bsoft.fun01.FunObject;
import nl.bsoft.fun01.FunPrijs;
import nl.bsoft.fun01.FunProject;
import nl.bsoft.fun01.FunPromoLabelObject;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by bvpelt on 4/15/17.
 */

@Entity
@Table(indexes = {
        @Index(name = "ID_INDEX", columnList = "FUNOBJECT_ID", unique = true),
        @Index(name = "globalId_Index", columnList = "globalId", unique = true)
})
public class FunObjectDTO implements Serializable {
    @Transient
    private final Logger log = LoggerFactory.getLogger(FunObjectDTO.class);

    @GenericGenerator(
            name = "objectSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "OBJECT_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "objectSequenceGenerator")
    @Column(name = "FUNOBJECT_ID")
    private Long id;

    private String aangebodenSindsTekst;         // : 2 weken,

    private Date aanmeldDatum;                   // : /Date(1262300400000+0100)/,

    private Integer aantalKamers;                // : 3,

    private Integer aantalKavels;                //: null,

    private String adres;                        //: Dr. Colijnstraat 15 B,

    private Integer afstand;                     //: 0,

    private String bronCode;                     //: NVM,

    @OneToMany(mappedBy = "funObject", cascade = CascadeType.ALL)
    private List<FunListDTO> childrenObjects = new ArrayList<FunListDTO>();    //: [],

    private Date datumOndertekeningAkte;         //: null,

    private String foto;                         //: http://cloud.funda.nl/valentina_media/078/540/166_klein.jpg,

    private String fotoLarge;                    //: http://cloud.funda.nl/valentina_media/078/540/166_groot.jpg,

    private String fotoLargest;                  //: http://cloud.funda.nl/valentina_media/078/540/166_grotere.jpg,

    private String fotoMedium;                   //: http://cloud.funda.nl/valentina_media/078/540/166_middel.jpg,

    private String fotoSecure;                   //: http://cloud.funda.nl/valentina_media/078/540/166_klein.jpg,

    private Date gewijzigdDatum;                 //: null,

    @Column(name = "globalId")
    private Integer globalId;                    //: 3743895,

    private String groupByObjectType;            //: 7ec20275-185a-488c-9c84-9ebb08f2e23c,

    private Boolean heeft360GradenFoto;          //: true,

    private Boolean heeftBrochure;               //: true,

    private Boolean heeftOpenhuizenTopper;       //: false,

    private Boolean heeftOverbruggingsgrarantie; //: false,

    private Boolean heeftPlattegrond;            //: true,

    private Boolean heeftTophuis;                //: false,

    private Boolean heeftVeiling;                //: false,

    private Boolean heeftVideo;                  //: true,

    private Integer huurPrijsTot;                //: null,

    private Integer huurprijs;                   //: null,

    private String huurprijsFormaat;             //: null,

    private String uuid;                         //: 7ec20275-185a-488c-9c84-9ebb08f2e23c,

    private String inUnitsVanaf;                 //: null,

    private Boolean indProjectObjectType;        //: false,

    private String indTransactieMakelaarTonen;   //: null,

    private Boolean isSearchable;                //: true,

    private Boolean isVerhuurd;                  //: false,

    private Boolean isVerkocht;                  //: false,

    private Boolean isVerkochtOfVerhuurd;        //: false,

    private Integer koopprijs;                   //: 209000,

    private String koopprijsFormaat;             //: <[KoopPrijs]> <{kosten koper|kort}>,

    private Integer koopprijsTot;                //: 209000,

    private Integer makelaarId;                  //: 18140,

    private String makelaarNaam;                 //: Van Dijk Van Essen,

    private String mobileURL;                    //: http://m.funda.nl/obj.aspx?goi=3743895,

    private String note;                         //: null,

    @OneToMany(mappedBy = "funObject", cascade = CascadeType.ALL)
    private List<FunListDTO> openHuis = new ArrayList<FunListDTO>();               //: [],

    private Integer oppervlakte;                 //: 0,

    private String perceeloppervlakte;           //: null,

    private String postcode;                     //: 3904EL,

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRIJS_ID")
    private FunPrijsDTO prijs;
    // @formatter:off
    /*:
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
    // @formatter:on

    private String prijsGeformatteerdHtml;       //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    private String prijsGeformatteerdTextHuur;   //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    private String prijsGeformatteerdTextKoop;   //: <span class=\price-wrapper\><span class=\price\>&euro;&nbsp;209.000<\/span> <abbr class=\price-ext\>k.k.<\/abbr><\/span>,

    // JPA Cascade types: DETACH, MERGE, PERSIST, REFRESH, REMOVE, ALL
    @ManyToMany(cascade = CascadeType.ALL)
    //@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "object_product",
            joinColumns = @JoinColumn(name = "OBJECT_ID", referencedColumnName = "FUNOBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCTLIST_ID", referencedColumnName = "FUN_PRODUCTLIST_ID"))
    private Set<FunProductListDTO> producten = new HashSet<FunProductListDTO>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private FunProjectDTO project;
    // @formatter:off
    /*:
    {
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
    },
    */
    // @formatter:on
    private String projectNaam;            //: null,

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROMOLABEL_ID")
    private FunPromoLabelObjectDTO promoLabel;
    // @formatter:off
    /*
    {
        HasPromotionLabel: false,
        PromotionPhotos: [],
        PromotionPhotosSecure: null,
        PromotionType: 0,
        RibbonColor: 0,
        RibbonText: null,
        Tagline: null
    },
    */
    // @formatter:on
    private Date publicatieDatum;         //: /Date(1490830506000+0200)/,

    private Integer publicatieStatus;       //: 0,

    private Date savedDate;               //: null,

    private String soortAanbod;            //: appartement,

    private Integer soortAanbodType;            //: 10,

    private String startOplevering;         //: null,

    private String timeAgoText;             //: null,

    private Date transactieAfmeldDatum;   //: null,

    private String transactieMakelaarId;    //: null,

    private String transactieMakelaarNaam;  //: null,

    private Integer typeProject;            //: 0,

    private String uRL;                     //: http://www.funda.nl/koop/veenendaal/appartement-49198258-dr-colijnstraat-15-b/,

    private String verkoopStatus;           //: StatusBeschikbaar,

    private Double wGS84_X;                 //: 5.541398,

    private Double wGS84_Y;                 //: 52.01925,

    private Integer woonOppervlakteTot;     //: 80,

    private Integer woonOppervlakte;        //: 80,

    private String woonPlaats;              //: Veenendaal,

    private Integer[] zoekType;             //: [10]

    public FunObjectDTO() {
    }

    public FunObjectDTO(FunObject f) {
        updateObject(f);
    }

    public void updateObject(FunObject f) {
        setAangebodenSindsTekst(f.getAangebodenSindsTekst());
        setAanmeldDatum(DotNetDateToJavaDate.convert(f.getAanmeldDatum()));
        setAantalKamers(f.getAantalKamers());
        setAantalKavels(f.getAantalKavels());
        setAdres(f.getAdres());
        setAfstand(f.getAfstand());
        setBronCode(f.getBronCode());

        // Add or Update children objects
        setChildrenObjects(updateList(childrenObjects, f.getChildrenObjects()));

        setDatumOndertekeningAkte(DotNetDateToJavaDate.convert(f.getDatumOndertekeningAkte()));
        setFoto(f.getFoto());
        setFotoLarge(f.getFotoLarge());
        setFotoLargest(f.getFotoLargest());
        setFotoMedium(f.getFotoMedium());
        setFotoSecure(f.getFotoSecure());
        setGewijzigdDatum(DotNetDateToJavaDate.convert(f.getGewijzigdDatum()));
        setGlobalId(f.getGlobalId());
        setGroupByObjectType(f.getGroupByObjectType());
        setHeeft360GradenFoto(f.getHeeft360GradenFoto());
        setHeeftBrochure(f.getHeeftBrochure());
        setHeeftOpenhuizenTopper(f.getHeeftOpenhuizenTopper());
        setHeeftOverbruggingsgrarantie(f.getHeeftOverbruggingsgrarantie());
        setHeeftPlattegrond(f.getHeeftPlattegrond());
        setHeeftTophuis(f.getHeeftTophuis());
        setHeeftVeiling(f.getHeeftVeiling());
        setHeeftVideo(f.getHeeftVideo());
        setHuurPrijsTot(f.getHuurPrijsTot());
        setHuurprijs(f.getHuurprijs());
        setHuurprijsFormaat(f.getHuurprijsFormaat());
        // internal id unique
        setUuid(f.getUuid());
        setInUnitsVanaf(f.getInUnitsVanaf());
        setIndProjectObjectType(f.getIndProjectObjectType());
        setIndTransactieMakelaarTonen(f.getIndTransactieMakelaarTonen());
        setSearchable(f.getSearchable());
        setVerhuurd(f.getVerhuurd());
        setVerkocht(f.getVerkocht());
        setVerkochtOfVerhuurd(f.getVerkochtOfVerhuurd());
        setKoopprijs(f.getKoopprijs());
        setKoopprijsFormaat(f.getKoopprijsFormaat());
        setKoopprijsTot(f.getKoopprijsTot());
        setMakelaarId(f.getMakelaarId());
        setMakelaarNaam(f.getMakelaarNaam());
        setMobileURL(f.getMobileURL());
        setNote(f.getNote());

        setOpenHuis(updateList(openHuis, f.getOpenHuis()));

        setOppervlakte(f.getOppervlakte());
        setPerceeloppervlakte(f.getPerceeloppervlakte());
        setPostcode(f.getPostcode());

        setPrijs(updatePrijs(prijs, f.getPrijs()));

        setPrijsGeformatteerdHtml(f.getPrijsGeformatteerdHtml());
        setPrijsGeformatteerdTextHuur(f.getPrijsGeformatteerdTextHuur());
        setPrijsGeformatteerdTextKoop(f.getPrijsGeformatteerdTextKoop());

        // Update producten
        setProducten(updateProducten(producten, f.getProducten()));

        setProject(updateProject(project, f.getProject()));
        //project.setFunObject(this);

        setProjectNaam(f.getProjectNaam());

        setPromoLabel(updatePromoLabel(promoLabel, f.getPromoLabel()));
        //promoLabel.setFunObject(this);

        setPublicatieDatum(DotNetDateToJavaDate.convert(f.getPublicatieDatum()));
        setPublicatieStatus(f.getPublicatieStatus());
        setSavedDate(DotNetDateToJavaDate.convert(f.getSavedDate()));

        setSoortAanbod(f.getSoortAanbod());
        setSoortAanbodType(f.getSoortAanbodType());
        setStartOplevering(f.getStartOplevering());
        setTimeAgoText(f.getTimeAgoText());
        setTransactieAfmeldDatum(DotNetDateToJavaDate.convert(f.getTransactieAfmeldDatum()));
        setTransactieMakelaarId(f.getTransactieMakelaarId());
        setTransactieMakelaarNaam(f.getTransactieMakelaarNaam());
        setTypeProject(f.getTypeProject());
        setuRL(f.getuRL());
        setVerkoopStatus(f.getVerkoopStatus());
        setwGS84_X(f.getwGS84_X());
        setwGS84_Y(f.getwGS84_Y());
        setWoonOppervlakte(f.getWoonOppervlakte());
        setWoonOppervlakteTot(f.getWoonOppervlakteTot());
        setWoonPlaats(f.getWoonPlaats());
        setZoekType(f.getZoekType());
    }

    private Set<FunProductListDTO> updateProducten(Set<FunProductListDTO> oldDto, List<String> products) {
        Set<FunProductListDTO> retDTO = new HashSet<FunProductListDTO>();

        // for each element of products
        //   if element in oldDto add element to retDTO
        //   if element not in oldDto create new element in retDTO
        //
        for (String s : products) {
            FunProductListDTO check = null;
            check = findStringInProductList(s, oldDto);

            if (null == check) {
                FunProductListDTO prod = new FunProductListDTO();
                prod.setValue(s);
                prod.addObject(this);
                retDTO.add(prod);
            } else {
                retDTO.add(check);
            }
        }

        return retDTO;
    }

    private FunProductListDTO findStringInProductList(String s, Set<FunProductListDTO> oldDto) {
        FunProductListDTO matchedProduct = null;
        boolean found = false;
        Iterator<FunProductListDTO> i = oldDto.iterator();
        while (!found && i.hasNext()) {
            matchedProduct = i.next();
            found = matchedProduct.getValue().equals(s);
        }
        if (!found) {
            matchedProduct = null;
        }
        return matchedProduct;
    }

    private FunPrijsDTO updatePrijs(FunPrijsDTO oldDto, FunPrijs prijs) {
        FunPrijsDTO retDTO = null;
        if (null == oldDto) {
            retDTO = new FunPrijsDTO(prijs);
        } else {
            retDTO = oldDto;
            retDTO.update(prijs);
        }
        return retDTO;
    }

    private FunPromoLabelObjectDTO updatePromoLabel(FunPromoLabelObjectDTO oldDto, FunPromoLabelObject promolabel) {
        FunPromoLabelObjectDTO retDTO = null;
        if (null == oldDto) {
            retDTO = new FunPromoLabelObjectDTO(promolabel);
        } else {
            retDTO = oldDto;
            retDTO.update(promolabel);
        }
        return retDTO;
    }

    private FunProjectDTO updateProject(FunProjectDTO oldDto, FunProject project) {
        FunProjectDTO retDTO = null;
        if (null == oldDto) {
            retDTO = new FunProjectDTO(project);
        } else {
            retDTO = oldDto;
            retDTO.update(project);
        }
        return retDTO;
    }

    private List<FunListDTO> updateList(List<FunListDTO> dtoList, List<String> strList) {
        List<FunListDTO> dtoReturn = dtoList;

        if (dtoList == null) {
            dtoList = new ArrayList<FunListDTO>();
            dtoReturn = dtoList;
        }
        if (dtoList.size() == 0) { // add elements
            for (String s : strList) {
                FunListDTO fdto = new FunListDTO();
                fdto.setFunObject(this);
                fdto.setValue(s);
                dtoList.add(fdto);
            }
        } else { // update elements
            // foreach element
            //   if s in oldlist put s in dtoReturn
            //   if s not in oldlist create new element and put in dtoReturn
            dtoReturn = new ArrayList<FunListDTO>();

            for (String s : strList) {
                int i = listContains(dtoList, s);
                if (i < dtoList.size()) {
                    dtoReturn.add(dtoList.get(i));
                } else {
                    FunListDTO fdto = new FunListDTO();
                    fdto.setFunObject(this);
                    fdto.setValue(s);
                    dtoReturn.add(fdto);
                }
            }
        }

        return dtoReturn;
    }

    private int listContains(List<FunListDTO> dtoList, String s) {
        boolean found = false;

        int size = dtoList.size();
        int i = 0;
        while (!found && (i < size)) {
            found = s.equals(dtoList.get(i).getValue());
        }
        return i;
    }

    public void addProduct(FunProductListDTO product) {
        log.info("Add product {} with id: {}", product, product.getId());
        //prevent endless loop
        if (producten.contains(product)) {
            log.info("Add product {} with id: {} - already exists", product, product.getId());
            return;
        }
        //add new product
        log.info("Add product {} with id: {} - new", product, product.getId());
        producten.add(product);
        //set myself into the funObjectn;
        product.addObject(this);
    }

    public void removeProduct(FunProductListDTO product) {
        log.info("remove product {} with id: {}", product, product.getId());
        //prevent endless loop
        if (!producten.contains(product)) {
            log.info("remove product {} with id: {} - not found", product, product.getId());
            return;
        }
        //remove the product
        log.info("remove product {} with id: {} - removed", product, product.getId());
        producten.remove(product.getValue());
        //remove myself from the funObjecten
        product.removeObject(this);
    }


    // -- Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAangebodenSindsTekst() {
        return aangebodenSindsTekst;
    }

    public void setAangebodenSindsTekst(String aangebodenSindsTekst) {
        this.aangebodenSindsTekst = aangebodenSindsTekst;
    }

    public Date getAanmeldDatum() {
        return aanmeldDatum;
    }

    public void setAanmeldDatum(Date aanmeldDatum) {
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

    public List<FunListDTO> getChildrenObjects() {
        return childrenObjects;
    }

    public void setChildrenObjects(List<FunListDTO> childrenObjects) {
        this.childrenObjects = childrenObjects;
    }

    public Date getDatumOndertekeningAkte() {
        return datumOndertekeningAkte;
    }

    public void setDatumOndertekeningAkte(Date datumOndertekeningAkte) {
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

    public Date getGewijzigdDatum() {
        return gewijzigdDatum;
    }

    public void setGewijzigdDatum(Date gewijzigdDatum) {
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

    public List<FunListDTO> getOpenHuis() {
        return openHuis;
    }

    public void setOpenHuis(List<FunListDTO> openHuis) {
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

    public FunPrijsDTO getPrijs() {
        return prijs;
    }

    public void setPrijs(FunPrijsDTO prijs) {
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

    public Set<FunProductListDTO> getProducten() {
        return producten;
    }

    public void setProducten(Set<FunProductListDTO> producten) {
        this.producten = producten;
    }

    public FunProjectDTO getProject() {
        return project;
    }

    public void setProject(FunProjectDTO project) {
        this.project = project;
    }

    public String getProjectNaam() {
        return projectNaam;
    }

    public void setProjectNaam(String projectNaam) {
        this.projectNaam = projectNaam;
    }

    public FunPromoLabelObjectDTO getPromoLabel() {
        return promoLabel;
    }

    public void setPromoLabel(FunPromoLabelObjectDTO promoLabel) {
        this.promoLabel = promoLabel;
    }

    public Date getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(Date publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public Integer getPublicatieStatus() {
        return publicatieStatus;
    }

    public void setPublicatieStatus(Integer publicatieStatus) {
        this.publicatieStatus = publicatieStatus;
    }

    public Date getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(Date savedDate) {
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

    public Date getTransactieAfmeldDatum() {
        return transactieAfmeldDatum;
    }

    public void setTransactieAfmeldDatum(Date transactieAfmeldDatum) {
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
