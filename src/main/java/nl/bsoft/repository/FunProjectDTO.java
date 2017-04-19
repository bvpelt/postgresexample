package nl.bsoft.repository;

import nl.bsoft.fun01.FunProject;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bvpelt on 4/15/17.
 */
@Entity
public class FunProjectDTO {
    @GenericGenerator(
            name = "projectSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "PROJECT_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "projectSequenceGenerator")
    @Column(name = "PROJECT_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "project")
    private FunObjectDTO funObject;

    private Integer aantalKamersTotEnMet;               //: null,

    private Integer aantalKamersVan;                    //: null,

    private Integer aantalKavels;                       //: null,

    private String adres;                               //: null,

    private String friendlyUrl;                         //: null,

    private String gewijzigdDatum;                      //: null,

    private String globalId;                            //: null,

    private String hoofdFoto;                           //: /img/thumbs/thumb-geen-foto.gif,

    private Boolean indIpix;                            //: false,

    private Boolean indPDF;                             //: false,

    private Boolean indPlattegrond;                     //: false,

    private Boolean indTop;                             //: false,

    private Boolean indVideo;                           //: false,

    private String internalId;                          //: 00000000-0000-0000-0000-000000000000,

    private Integer maxWoonoppervlakte;                 //: null,

    private Integer minWoonoppervlakte;                 //: null,

    private String naam;                                //: null,

    private String omschrijving;                        //: null,

    @OneToMany(mappedBy = "funProject")
    private List<FunHuizenListDTO> openHuizen;                    //: [],

    private String plaats;                              //: null,

    private Integer prijs;                              //: null,

    private String prijsGeformatteerd;                  //: null,

    private String publicatieDatum;                     //: null,

    private Integer type;                               //: 0,

    private String woningtypen;                         //: null

    public FunProjectDTO(FunProject f) {
        setAantalKamersTotEnMet(f.getAantalKamersTotEnMet());
        setAantalKamersVan(f.getAantalKamersVan());
        setAantalKavels(f.getAantalKavels());
        setAdres(f.getAdres());
        setFriendlyUrl(f.getFriendlyUrl());
        setGewijzigdDatum(f.getGewijzigdDatum());
        setGlobalId(f.getGlobalId());
        setHoofdFoto(f.getHoofdFoto());
        setIndIpix(f.getIndIpix());
        setIndPDF(f.getIndPDF());
        setIndPlattegrond(f.getIndPlattegrond());
        setIndTop(f.getIndTop());
        setIndVideo(f.getIndVideo());
        setInternalId(f.getInternalId());
        setMaxWoonoppervlakte(f.getMaxWoonoppervlakte());
        setMinWoonoppervlakte(f.getMinWoonoppervlakte());
        setNaam(f.getNaam());
        setOmschrijving(f.getOmschrijving());

        List<String> fls_h = f.getOpenHuizen();
        List<FunHuizenListDTO> fld_h = null;
        if ((fls_h != null) && (fls_h.size() > 0)) {
            for (String s : fls_h) {
                FunHuizenListDTO fod = new FunHuizenListDTO();
                fod.setValue(s);
                fld_h.add(fod);
            }
        }
        setOpenHuizen(fld_h);

        setPlaats(f.getPlaats());
        setPrijs(f.getPrijs());
        setPrijsGeformatteerd(f.getPrijsGeformatteerd());
        setPublicatieDatum(f.getPublicatieDatum());
        setType(f.getType());
        setWoningtypen(f.getWoningtypen());
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

    public List<FunHuizenListDTO> getOpenHuizen() {
        return openHuizen;
    }

    public void setOpenHuizen(List<FunHuizenListDTO> openHuizen) {
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
