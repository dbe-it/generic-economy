package genericEconomy.data.location;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import genericEconomy.data.resource.UserAccount;


@Entity
public class Biom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 20)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "biom")
    private List<Sector> sectors;

    @OneToOne
    private UserAccount userAccount;

    @Transient
    private Sector selectedSector;

    public Biom() { }

    public String getTitle() {
        return title;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public Long getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Sector getSelectedSector() {
        System.out.println("GETTER USED:" + selectedSector);
        return selectedSector;
    }

    public void setSelectedSector(Sector selectedSector) {
        System.out.println("SETTER USED:" + selectedSector);
        this.selectedSector = selectedSector;
    }

}
