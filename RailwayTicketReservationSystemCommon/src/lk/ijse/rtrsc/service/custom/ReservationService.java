/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface ReservationService extends SuperService{

    public boolean addReservation(ReservationTransactionDto f)throws Exception;

    public SheetDto getAllSheets(Object sheet1)throws Exception;
    
}
