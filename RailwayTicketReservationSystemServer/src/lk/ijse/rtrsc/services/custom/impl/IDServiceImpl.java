/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.IdBO;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.service.custom.IdService;

/**
 *
 * @author Gnanod-PC
 */
public class IDServiceImpl extends UnicastRemoteObject implements IdService{

    private IdBO idBO;
    public IDServiceImpl()throws RemoteException{
        idBO = (IdBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.ID);
    }
    
    @Override
    public String getResult(IdDto idDTO) throws Exception {
       return  idBO.getResult(idDTO);
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
