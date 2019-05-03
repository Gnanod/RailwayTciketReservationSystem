/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gnanod-PC
 */
@Embeddable
public class StationRouteDetail_PkEntity implements Serializable{
    @Column(length = 10)
    private String routeId;
    @Column(length = 10)
    private String stationId;

    public StationRouteDetail_PkEntity() {
    }

    public StationRouteDetail_PkEntity(String routeId, String stationId) {
        this.routeId = routeId;
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

    
    
    
    
    
   
    
}
