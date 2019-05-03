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
public class ReservationDto extends SuperDto{

    private int reservationId;
    private int adults;
    private int children;
    private String startStation;
    private String endStation;
    private String time;
    private String date;
    private PassengerDto passengerEntity;
    private RouteDto routeEntity;

    public ReservationDto() {
    }

    public ReservationDto(int reservationId, int adults, int children, String startStation, String endStation, String time, PassengerDto passengerEntity, RouteDto routeEntity) {
        this.reservationId = reservationId;
        this.adults = adults;
        this.children = children;
        this.startStation = startStation;
        this.endStation = endStation;
        this.time = time;
        this.passengerEntity = passengerEntity;
        this.routeEntity = routeEntity;
    }

    public ReservationDto(int reservationId, int adults, int children, String startStation, String endStation, String time, String date, PassengerDto passengerEntity, RouteDto routeEntity) {
        this.reservationId = reservationId;
        this.adults = adults;
        this.children = children;
        this.startStation = startStation;
        this.endStation = endStation;
        this.time = time;
        this.date = date;
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
    public PassengerDto getPassengerEntity() {
        return passengerEntity;
    }

    /**
     * @param passengerEntity the passengerEntity to set
     */
    public void setPassengerEntity(PassengerDto passengerEntity) {
        this.passengerEntity = passengerEntity;
    }

    /**
     * @return the routeEntity
     */
    public RouteDto getRouteEntity() {
        return routeEntity;
    }

    /**
     * @param routeEntity the routeEntity to set
     */
    public void setRouteEntity(RouteDto routeEntity) {
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
