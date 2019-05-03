/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.DayBO;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.service.custom.DayService;
import lk.ijse.rtrsc.service.custom.PriceService;

/**
 *
 * @author Gnanod-PC
 */
public class DayServiceImpl  extends UnicastRemoteObject implements DayService{
 
    private DayBO dayBO;
    public DayServiceImpl()throws RemoteException{
        dayBO = (DayBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.DAY);
    
    }

    @Override
    public DayDto getDay(String dayId) throws Exception {
        return dayBO.getDay(dayId);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
