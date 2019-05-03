/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class StationRoutesDetailEntity {
   
    private String stationStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "routeId", referencedColumnName = "routeId", insertable = false, updatable = false)
    private RouteEntity route;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId", referencedColumnName = "stationId", insertable = false, updatable = false)
    private StationEntity stationEntity;
    
    @EmbeddedId
    private StationRouteDetail_PkEntity stationRouteDetail_PkEntity;

    public StationRoutesDetailEntity() {
    }

    public StationRoutesDetailEntity(String routeId,String stationId,String stationStatus, RouteEntity route, StationEntity stationEntity, StationRouteDetail_PkEntity stationRouteDetail_PkDto) {
        this.stationStatus = stationStatus;
        this.route = route;
        this.stationEntity = stationEntity;
        this.stationRouteDetail_PkEntity = new StationRouteDetail_PkEntity(routeId,stationId);
    }

    /**
     * @return the stationStatus
     */
    public String getStationStatus() {
        return stationStatus;
    }

    /**
     * @param stationStatus the stationStatus to set
     */
    public void setStationStatus(String stationStatus) {
        this.stationStatus = stationStatus;
    }

    /**
     * @return the route
     */
    public RouteEntity getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    /**
     * @return the stationEntity
     */
    public StationEntity getStationEntity() {
        return stationEntity;
    }

    /**
     * @param stationEntity the stationEntity to set
     */
    public void setStationEntity(StationEntity stationEntity) {
        this.stationEntity = stationEntity;
    }

    /**
     * @return the stationRouteDetail_PkDto
     */
    public StationRouteDetail_PkEntity getStationRouteDetail_PkEntity() {
        return stationRouteDetail_PkEntity;
    }

    /**
     * @param stationRouteDetail_PkDto the stationRouteDetail_PkDto to set
     */
    public void setStationRouteDetail_PkEntity(StationRouteDetail_PkEntity stationRouteDetail_PkDto) {
        this.stationRouteDetail_PkEntity = stationRouteDetail_PkDto;
    }

    @Override
    public String toString() {
        return "StationRouteDetailEntity{" + "stationStatus=" + stationStatus + ", route=" + route + ", stationEntity=" + stationEntity + ", stationRouteDetail_PkDto=" + stationRouteDetail_PkEntity + '}';
    }
    
    
}
