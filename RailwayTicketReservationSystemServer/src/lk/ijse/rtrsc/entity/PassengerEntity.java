/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class PassengerEntity {

    @Id
   
    private String passengerId;
    private String passengerName;
    private String passengerTp;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ReservationEntity> reservation;

    public PassengerEntity() {
    }

    public PassengerEntity(String passengerId, String passengerName, String passengerTp, List<ReservationEntity> reservation) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerTp = passengerTp;
        this.reservation = reservation;
    }

    /**
     * @return the passengerId
     */
    public String getPassengerId() {
        return passengerId;
    }

    /**
     * @param passengerId the passengerId to set
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * @return the passengerName
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * @param passengerName the passengerName to set
     */
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    /**
     * @return the passengerTp
     */
    public String getPassengerTp() {
        return passengerTp;
    }

    /**
     * @param passengerTp the passengerTp to set
     */
    public void setPassengerTp(String passengerTp) {
        this.passengerTp = passengerTp;
    }

    /**
     * @return the reservation
     */
    public List<ReservationEntity> getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(List<ReservationEntity> reservation) {
        this.reservation = reservation;
    }

   
    
    
}
