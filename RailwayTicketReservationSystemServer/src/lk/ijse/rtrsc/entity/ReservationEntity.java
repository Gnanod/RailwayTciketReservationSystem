/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    private int adults;
    private int children;
    private String startStation;
    private String date;
    private String endStation;
    private String time;
    @ManyToOne(cascade = CascadeType.ALL)
    private PassengerEntity passengerEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    private RouteEntity routeEntity;

    public ReservationEntity() {
    }

    public ReservationEntity(int reservationId, int adults, int children, String startStation, String endStation, String time, PassengerEntity passengerEntity, RouteEntity routeEntity) {
        this.reservationId = reservationId;
        this.adults = adults;
        this.children = children;
        this.startStation = startStation;
        this.endStation = endStation;
        this.time = time;
        this.passengerEntity = passengerEntity;
        this.routeEntity = routeEntity;
    }

    public ReservationEntity(int reservationId, int adults, int children, String startStation, String date, String endStation, String time, PassengerEntity passengerEntity, RouteEntity routeEntity) {
        this.reservationId = reservationId;
        this.adults = adults;
        this.children = children;
        this.startStation = startStation;
        this.date = date;
        this.endStation = endStation;
        this.time = time;
        this.passengerEntity = passengerEntity;
        this.routeEntity = routeEntity;
    }
    
    

    /**
     * @return the reservationId
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * @return the adults
     */
    public int getAdults() {
        return adults;
    }

    /**
     * @param adults the adults to set
     */
    public void setAdults(int adults) {
        this.adults = adults;
    }

    /**
     * @return the children
     */
    public int getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * @return the startStation
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * @param startStation the startStation to set
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    /**
     * @return the endStation
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * @param endStation the endStation to set
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the passengerEntity
     */
    public PassengerEntity getPassengerEntity() {
        return passengerEntity;
    }

    /**
     * @param passengerEntity the passengerEntity to set
     */
    public void setPassengerEntity(PassengerEntity passengerEntity) {
        this.passengerEntity = passengerEntity;
    }

    /**
     * @return the routeEntity
     */
    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    /**
     * @param routeEntity the routeEntity to set
     */
    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
