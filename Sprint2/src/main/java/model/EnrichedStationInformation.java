package model;

import model.StationInformationEntity;
import model.SystemInformationEntity;

public class EnrichedStationInformation {
    private StationInformationEntity stationInformationEntity;
    private SystemInformationEntity systemInformationEntity;

    public EnrichedStationInformation(){}

    public EnrichedStationInformation(StationInformationEntity stationInformationEntity, SystemInformationEntity systemInformationEntity) {
        this.stationInformationEntity = stationInformationEntity;
        this.systemInformationEntity = systemInformationEntity;
    }

    public StationInformationEntity getStationInformationEntity() {
        return stationInformationEntity;
    }

    public void setStationInformationEntity(StationInformationEntity stationInformationEntity) {
        this.stationInformationEntity = stationInformationEntity;
    }

    public SystemInformationEntity getSystemInformationEntity() {
        return systemInformationEntity;
    }

    public void setSystemInformationEntity(SystemInformationEntity systemInformationEntity) {
        this.systemInformationEntity = systemInformationEntity;
    }
}
