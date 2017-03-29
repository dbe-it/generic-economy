package genericEconomy.exception;

public class SectorNotFoundException extends RuntimeException {
    private long sectorId;

    public SectorNotFoundException(long sectorId) {
        this.sectorId = sectorId;
    }

    public long getSectorId() {
        return sectorId;
    }
}