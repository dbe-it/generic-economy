package genericEconomy.exception;

public class BiomNotFoundException extends RuntimeException {
    private long biomId;

    public BiomNotFoundException(long biomId) {
        this.biomId = biomId;
    }

    public long getBiomId() {
        return biomId;
    }
}