/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

import java.util.List;
import lk.ijse.rtrsc.dto.PassengerDto;
import lk.ijse.rtrsc.dto.PaymentDto;
import lk.ijse.rtrsc.dto.ReservationDto;

/**
 *
 * @author Gnanod-PC
 */
public class ReservationTransactionDto extends SuperDto{
    private PassengerDto passengerDto;
    private ReservationDto reservationDto;
    private PaymentDto paymentDto;
    private DayDto dayDto;
    private List<ReservationWagonDetailDto> reservationWagonDetail;
    private List<ReservationSheetDetailDto> reservationSheetDetail;
    private List<SheetDto> sheetList;
    public ReservationTransactionDto() {
    }

    public ReservationTransactionDto(PassengerDto passengerDto, ReservationDto reservationDto, PaymentDto paymentDto, DayDto dayDto, List<ReservationWagonDetailDto> reservationWagonDetail, List<ReservationSheetDetailDto> reservationSheetDetail, List<SheetDto> sheetList) {
        this.passengerDto = passengerDto;
        this.reservationDto = reservationDto;
        this.paymentDto = paymentDto;
        this.dayDto = dayDto;
        this.reservationWagonDetail = reservationWagonDetail;
        this.reservationSheetDetail = reservationSheetDetail;
        this.sheetList = sheetList;
    }

    
    public ReservationTransactionDto(PassengerDto passengerDto, ReservationDto reservationDto, PaymentDto paymentDto, DayDto dayDto, List<ReservationWagonDetailDto> reservationWagonDetail, List<SheetDto> sheetList) {
        this.passengerDto = passengerDto;
        this.reservationDto = reservationDto;
        this.paymentDto = paymentDto;
        this.dayDto = dayDto;
        this.reservationWagonDetail = reservationWagonDetail;
        this.sheetList = sheetList;
    }

    

    /**
     * @return the passengerDto
     */
    public PassengerDto getPassengerDto() {
        return passengerDto;
    }

    /**
     * @param passengerDto the passengerDto to set
     */
    public void setPassengerDto(PassengerDto passengerDto) {
        this.passengerDto = passengerDto;
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
     * @return the paymentDto
     */
    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    /**
     * @param paymentDto the paymentDto to set
     */
    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
    }

    /**
     * @return the reservationWagonDetail
     */
    public List<ReservationWagonDetailDto> getReservationWagonDetail() {
        return reservationWagonDetail;
    }

    /**
     * @param reservationWagonDetail the reservationWagonDetail to set
     */
    public void setReservationWagonDetail(List<ReservationWagonDetailDto> reservationWagonDetail) {
        this.reservationWagonDetail = reservationWagonDetail;
    }

    /**
     * @return the dayDto
     */
    public DayDto getDayDto() {
        return dayDto;
    }

    /**
     * @param dayDto the dayDto to set
     */
    public void setDayDto(DayDto dayDto) {
        this.dayDto = dayDto;
    }

    /**
     * @return the sheetList
     */
    public List<SheetDto> getSheetList() {
        return sheetList;
    }

    /**
     * @param sheetList the sheetList to set
     */
    public void setSheetList(List<SheetDto> sheetList) {
        this.sheetList = sheetList;
    }

    /**
     * @return the reservationSheetDetail
     */
    public List<ReservationSheetDetailDto> getReservationSheetDetail() {
        return reservationSheetDetail;
    }

    /**
     * @param reservationSheetDetail the reservationSheetDetail to set
     */
    public void setReservationSheetDetail(List<ReservationSheetDetailDto> reservationSheetDetail) {
        this.reservationSheetDetail = reservationSheetDetail;
    }
    
    
    
            
}
