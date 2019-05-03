/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

/**
 *
 * @author Gnanod-PC
 */
public class StationRouteDetail_PkDto extends SuperDto{
    private String stationId;
    private String routeId;

    public StationRouteDetail_PkDto() {
    }

    public StationRouteDetail_PkDto(String stationId, String routeId) {
        this.stationId = stationId;
        this.routeId = routeId;
    }

    /**
     * @return the stationId
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the routeId
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the routeId to set
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
}
