package nl.bsoft.repository;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by bvpelt on 4/17/17.
 */
@Entity
public class FunHuizenListDTO implements Serializable {

    @GenericGenerator(
            name = "huizenSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "HUIZEN_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "huizenSequenceGenerator")
    @Column(name = "HUIZEN_ID")
    private Long id;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private FunProjectDTO funProject;

    public FunHuizenListDTO() {
    }

    void addProject(FunProjectDTO project) {
        this.funProject = project;
    }

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

    public FunProjectDTO getFunProject() {
        return funProject;
    }

    public void setFunProject(FunProjectDTO funProject) {
        this.funProject = funProject;
    }
}
