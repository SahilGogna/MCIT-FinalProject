package model;

public class StationInformationJson {
    private Long last_updated;
    private int ttl;
    private StationInformationAux data;

    public StationInformationJson() {
    }

    public StationInformationJson(Long last_updated, int ttl, StationInformationAux data) {
        this.last_updated = last_updated;
        this.ttl = ttl;
        this.data = data;
    }

    public Long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Long last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public StationInformationAux getData() {
        return data;
    }

    public void setData(StationInformationAux data) {
        this.data = data;
    }
}
