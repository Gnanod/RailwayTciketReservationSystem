/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class RouteEntity implements Serializable{
    
    @Id
    private String routeId;
    private String routeName;
    private String depatureTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainId", referencedColumnName = "trainId", insertable = false, updatable = false)
    private TrainEntity train;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dateId", referencedColumnName = "dateId", insertable = false, updatable = false)
    private DayEntity dayEntity;
   
   // @EmbeddedId
    private Route_PkEntity route_PkEntity;
    public RouteEntity() {
    }

    public RouteEntity(String trainId,String dateId,String routeId, String routeName, String depatureTime, TrainEntity train, DayEntity dayEntity, Route_PkEntity route_PkEntity) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.depatureTime = depatureTime;
        this.train = train;
        this.dayEntity = dayEntity;
        this.route_PkEntity = new Route_PkEntity(trainId,dateId);
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
     * @return the routeName
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * @param routeName the routeName to set
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * @return the depatureTime
     */
    public String getDepatureTime() {
        return depatureTime;
    }

    /**
     * @param depatureTime the depatureTime to set
     */
    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

    /**
     * @return the train
     */
    public TrainEntity getTrain() {
        return train;
    }

    /**
     * @param train the train to set
     */
    public void setTrain(TrainEntity train) {
        this.train = train;
    }

    /**
     * @return the dayEntity
     */
    public DayEntity getDayEntity() {
        return dayEntity;
    }

    /**
     * @param dayEntity the dayEntity to set
     */
    public void setDayEntity(DayEntity dayEntity) {
        this.dayEntity = dayEntity;
    }

    /**
     * @return the route_PkEntity
     */
    public Route_PkEntity getRoute_PkEntity() {
        return route_PkEntity;
    }

    /**
     * @param route_PkEntity the route_PkEntity to set
     */
    public void setRoute_PkEntity(Route_PkEntity route_PkEntity) {
        this.route_PkEntity = route_PkEntity;
    }

    /**
     * @return the stationRoutesDetailEntity
     */
   

   

    
    
    

}
