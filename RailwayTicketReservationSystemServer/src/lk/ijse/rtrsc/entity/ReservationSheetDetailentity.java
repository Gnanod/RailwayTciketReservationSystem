/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

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
public class ReservationSheetDetailentity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId", insertable = false, updatable = false)
    private ReservationEntity reservation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sheetID", referencedColumnName = "sheetID", insertable = false, updatable = false)
    private SheetEntity sheetEntity;
    @EmbeddedId
    private ReservationSheetDetail_pkEntity reservationSheetDetail_pkEntity;

    public ReservationSheetDetailentity() {
    }

    public ReservationSheetDetailentity(String sheetID,int reservationId,ReservationEntity reservation, SheetEntity sheetEntity, ReservationSheetDetail_pkEntity reservationSheetDetail_pkEntity) {
        this.reservation = reservation;
        this.sheetEntity = sheetEntity;
        this.reservationSheetDetail_pkEntity = new ReservationSheetDetail_pkEntity(reservationId, reservationId);
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
     * @return the sheetEntity
     */
    public SheetEntity getSheetEntity() {
        return sheetEntity;
    }

    /**
     * @param sheetEntity the sheetEntity to set
     */
    public void setSheetEntity(SheetEntity sheetEntity) {
        this.sheetEntity = sheetEntity;
    }

    /**
     * @return the reservationSheetDetail_pkEntity
     */
    public ReservationSheetDetail_pkEntity getReservationSheetDetail_pkEntity() {
        return reservationSheetDetail_pkEntity;
    }

    /**
     * @param reservationSheetDetail_pkEntity the reservationSheetDetail_pkEntity to set
     */
    public void setReservationSheetDetail_pkEntity(ReservationSheetDetail_pkEntity reservationSheetDetail_pkEntity) {
        this.reservationSheetDetail_pkEntity = reservationSheetDetail_pkEntity;
    }
    
    
}
