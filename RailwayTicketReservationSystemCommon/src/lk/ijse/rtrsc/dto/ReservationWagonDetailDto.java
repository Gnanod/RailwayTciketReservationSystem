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
public class ReservationWagonDetailDto extends SuperDto{

    private ReservationDto reservationDto;
    private WagonDto wagonDto;

    public ReservationWagonDetailDto() {
    }

    public ReservationWagonDetailDto(ReservationDto reservationDto, WagonDto wagonDto) {
        this.reservationDto = reservationDto;
        this.wagonDto = wagonDto;
    }

    /**
     * @return the reservationDto
     */
    public ReservationDto getReservationDto() {
        return reservationDto;
    }

    /**
     * @param reservationDto the reservationDto to set
     */
    public void setReservationDto(ReservationDto reservationDto) {
        this.reservationDto = reservationDto;
    }

    /**
     * @return the wagonDto
     */
    public WagonDto getWagonDto() {
        return wagonDto;
    }

    /**
     * @param wagonDto the wagonDto to set
     */
    public void setWagonDto(WagonDto wagonDto) {
        this.wagonDto = wagonDto;
    }

}
