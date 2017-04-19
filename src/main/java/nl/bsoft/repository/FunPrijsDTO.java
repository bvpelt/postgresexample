package nl.bsoft.repository;

import nl.bsoft.fun01.FunPrijs;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


/**
 * Created by bvpelt on 4/15/17.
 */
@Entity
public class FunPrijsDTO {
    @GenericGenerator(
            name = "prijsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "PRIJS_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "prijsSequenceGenerator")
    @Column(name = "PRIJS_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "prijs")
    @JoinColumn(name = "FUNOBJECT_ID")
    private FunObjectDTO funObject;

    private Boolean geenExtraKosten;        //: false,

    private String huurAbbreviation;        //: ,

    private Integer huurprijs;              //: null,

    private String huurprijsOpAanvraag;     //: ,

    private Integer huurprijsTot;           //: null,

    private String koopAbbreviation;        //: k.k.,

    private Integer koopprijs;              //: 209000,

    private String koopprijsOpAanvraag;     //: ,

    private Integer koopprijsTot;           //: 209000,

    private Integer originelePrijs;         //: null,

    private String veilingText;             //:

    public FunPrijsDTO(FunPrijs f) {
        setGeenExtraKosten(f.getGeenExtraKosten());
        setHuurAbbreviation(f.getHuurAbbreviation());
        setHuurprijs(f.getHuurprijs());
        setHuurprijsOpAanvraag(f.getHuurprijsOpAanvraag());
        setHuurprijsTot(f.getHuurprijsTot());
        setKoopAbbreviation(f.getKoopAbbreviation());
        setKoopprijs(f.getKoopprijs());
        setKoopprijsOpAanvraag(f.getKoopprijsOpAanvraag());
        setKoopprijsTot(f.getKoopprijsTot());
        setOriginelePrijs(f.getOriginelePrijs());
        setVeilingText(f.getVeilingText());
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
