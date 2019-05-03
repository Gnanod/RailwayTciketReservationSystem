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
public class ReservationSheetDetailDto extends SuperDto{
    private ReservationDto reservation;
    private SheetDto sheetEntity;

    public ReservationSheetDetailDto() {
    }

    public ReservationSheetDetailDto(ReservationDto reservation, SheetDto sheetEntity) {
        this.reservation = reservation;
        this.sheetEntity = sheetEntity;
    }

    /**
     * @return the reservation
     */
    public ReservationDto getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(ReservationDto reservation) {
        this.reservation = reservation;
    }

    /**
     * @return the sheetEntity
     */
    public SheetDto getSheetEntity() {
        return sheetEntity;
    }

    /**
     * @param sheetEntity the sheetEntity to set
     */
    public void setSheetEntity(SheetDto sheetEntity) {
        this.sheetEntity = sheetEntity;
    }
  
    
}
