package genericEconomy.data.resource;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import genericEconomy.data.location.Sector;


@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @NotNull
    private int amount = 0;

    private boolean naturalResource;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isNaturalResource() {
        return naturalResource;
    }
}
