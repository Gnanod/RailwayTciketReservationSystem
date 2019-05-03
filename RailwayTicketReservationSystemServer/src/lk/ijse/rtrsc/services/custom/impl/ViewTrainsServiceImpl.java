/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.ViewTrainsBO;
import lk.ijse.rtrsc.dto.ViewTrainsDto;
import lk.ijse.rtrsc.service.custom.UserService;
import lk.ijse.rtrsc.service.custom.ViewTrainsService;

/**
 *
 * @author Gnanod-PC
 */
public class ViewTrainsServiceImpl  extends UnicastRemoteObject implements ViewTrainsService{

    private ViewTrainsBO viewTrainsBO;
   public ViewTrainsServiceImpl()throws RemoteException{
         System.out.println("iiiiiPPPPPPPPPPPPP");
       viewTrainsBO = (ViewTrainsBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VIEWTRAINS);
   }

    @Override
    public ViewTrainsDto searchTrains(Object[] ob) throws Exception {
       
        return viewTrainsBO.searchTrains(ob);
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
