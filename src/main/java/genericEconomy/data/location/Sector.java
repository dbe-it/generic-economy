package genericEconomy.data.location;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import genericEconomy.data.resource.Resource;


@Entity
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "biom_id")
    private Biom biom;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sector")
    @OrderBy("id ASC")
    private List<Module> modules;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sector")
    private List<Resource> resources;

    public Sector(){ }

    public long getId() {
        return id;
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Resource> getNaturalResources() {

        return resources.stream().filter(resource -> resource.isNaturalResource()).collect(Collectors.toList());
    }

    public List<Resource> getStoredResources() {

        return resources.stream().filter(resource -> !resource.isNaturalResource()).collect(Collectors.toList());
    }
}
