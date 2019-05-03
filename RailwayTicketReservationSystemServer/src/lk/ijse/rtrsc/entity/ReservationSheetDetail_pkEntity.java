/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Gnanod-PC
 */
@Embeddable
public class ReservationSheetDetail_pkEntity implements Serializable{
    private int reservationId;
    private int sheetID;

    public ReservationSheetDetail_pkEntity() {
    }

    public ReservationSheetDetail_pkEntity(int reservationId, int sheetID) {
        this.reservationId = reservationId;
        this.sheetID = sheetID;
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
     * @return the sheetID
     */
    public int getSheetID() {
        return sheetID;
    }

    /**
     * @param sheetID the sheetID to set
     */
    public void setSheetID(int sheetID) {
        this.sheetID = sheetID;
    }

    
    
}
