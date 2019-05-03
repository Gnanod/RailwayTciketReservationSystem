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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class ReservationWagonDetailEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId", insertable = false, updatable = false)
    private ReservationEntity reservation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wagonId", referencedColumnName = "wagonId", insertable = false, updatable = false)
    private WagonEntity wagonEntity;
    @EmbeddedId
    private ReservationWagonDetail_PkEntity pkEntity;

    public ReservationWagonDetailEntity() {
    }

    public ReservationWagonDetailEntity(String wagonId,int reservationId,ReservationEntity reservation, WagonEntity wagonEntity, ReservationWagonDetail_PkEntity pkEntity) {
        this.reservation = reservation;
        this.wagonEntity = wagonEntity;
        this.pkEntity = new ReservationWagonDetail_PkEntity(reservationId,wagonId);
    }

    /**
     * @return the reservation
     */
    public ReservationEntity getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    /**
     * @return the wagonEntity
     */
    public WagonEntity getWagonEntity() {
        return wagonEntity;
    }

    /**
     * @param wagonEntity the wagonEntity to set
     */
    public void setWagonEntity(WagonEntity wagonEntity) {
        this.wagonEntity = wagonEntity;
    }

    /**
     * @return the pkEntity
     */
    public ReservationWagonDetail_PkEntity getPkEntity() {
        return pkEntity;
    }

    /**
     * @param pkEntity the pkEntity to set
     */
    public void setPkEntity(ReservationWagonDetail_PkEntity pkEntity) {
        this.pkEntity = pkEntity;
    }
    
    
}
