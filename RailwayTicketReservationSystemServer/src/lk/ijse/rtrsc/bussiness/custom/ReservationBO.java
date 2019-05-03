/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.SheetDto;

/**
 *
 * @author Gnanod-PC
 */
public interface ReservationBO extends SuperBO{

    public boolean addResrvation(ReservationTransactionDto f)throws Exception;

    public SheetDto getAllSheets(Object sheet1)throws Exception;
    
}
