//package genericEconomy.data.location;
//
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//
//import genericEconomy.data.resource.ResourceType;
//
//
//@Entity
//public class Storage {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Enumerated(EnumType.STRING)
//    private ResourceType resourceType;
//
//    @NotNull
//    private int amount = 0;
//
//    public Storage() { }
//
//    public String getResourceName() {
//        return hasResource() ? resourceType.getName() : null;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public boolean hasResource(){
//        return resourceType == null ? false : true;
//    }
//}
