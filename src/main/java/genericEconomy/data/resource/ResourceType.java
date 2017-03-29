package genericEconomy.data.resource;

public enum ResourceType {

    WOOD("Holz"),
    STONE("Stein");

    String name;

    ResourceType(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
