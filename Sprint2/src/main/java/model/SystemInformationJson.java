package model;

public class SystemInformationJson {
    private String last_updated;
    private int ttl;
    private SystemInformationEntity data;

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public SystemInformationEntity getData() {
        return data;
    }

    public void setData(SystemInformationEntity data) {
        this.data = data;
    }
}
