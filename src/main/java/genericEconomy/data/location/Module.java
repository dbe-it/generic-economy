package genericEconomy.data.location;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import genericEconomy.data.resource.BuildingType;


@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    private int buildingLevel = 0;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public Module(){}

    public long getId() {
        return id;
    }

    public String getBuildingName() {

        return (hasBuilding() ? buildingType.getName() : null);
    }

    public int getBuildingLevel() { return buildingLevel; }

    public boolean hasBuilding(){
        return buildingType == null ? false : true;
    }

}
