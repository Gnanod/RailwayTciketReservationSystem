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
public class PaymentDto extends SuperDto{
    private int paymentId;
    private double total;
  
    private ReservationDto reservationDto;

    public PaymentDto() {
        
    }

    public PaymentDto(int paymentId, double total, ReservationDto reservationDto) {
        this.paymentId = paymentId;
        this.total = total;
        this.reservationDto = reservationDto;
    }

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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

   
    
    
}
