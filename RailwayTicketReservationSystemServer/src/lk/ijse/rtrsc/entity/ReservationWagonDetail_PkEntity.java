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
public class ReservationWagonDetail_PkEntity implements Serializable{

    @Column(length = 10)
    private int reservationId;
    @Column(length = 10)
    private String wagonDetailId;

    public ReservationWagonDetail_PkEntity() {
    }

    public ReservationWagonDetail_PkEntity(int reservationId, String wagonDetailId) {
        this.reservationId = reservationId;
        this.wagonDetailId = wagonDetailId;
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
     * @return the wagonDetailId
     */
    public String getWagonDetailId() {
        return wagonDetailId;
    }

    /**
     * @param wagonDetailId the wagonDetailId to set
     */
    public void setWagonDetailId(String wagonDetailId) {
        this.wagonDetailId = wagonDetailId;
    }

}
