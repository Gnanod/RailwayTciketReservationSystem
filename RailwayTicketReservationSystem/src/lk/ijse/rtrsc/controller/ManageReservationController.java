/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.ReservationService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageReservationController {

    public static boolean addReservation(ReservationTransactionDto f) throws Exception {
        ReservationService service = (ReservationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RESERVATION);
        
        return service.addReservation(f);
    }

    public static SheetDto getAllSheets(Object sheet1) throws Exception {
         ReservationService service = (ReservationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RESERVATION);
        
        return service.getAllSheets(sheet1);
    }
    
    public static boolean reserveSeat(int seatID) throws Exception{
        ReservationService reservationService= (ReservationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RESERVATION);
        return reservationService.reserve(seatID);
    }
    
    public static boolean releaseSeat(int seatID) throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RESERVATION);
        return reservationService.release(seatID);
    }   
     public static Subject getReservationSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RESERVATION);
    }
    
}
