package genericEconomy.data.resource;

public enum BuildingType {

    LUMBERJACK("Holzfäller"),
    STONEQUARRY("Steinbruch");

    String name;

    BuildingType(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
