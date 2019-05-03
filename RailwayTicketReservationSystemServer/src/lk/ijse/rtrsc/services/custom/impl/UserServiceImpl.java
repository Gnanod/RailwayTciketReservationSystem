/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.UserBO;
import lk.ijse.rtrsc.dto.UserDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.UserService;

/**
 *
 * @author Gnanod-PC
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    private UserBO userBO;
    public UserServiceImpl() throws RemoteException {
        System.out.println("userCon");
        userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.USER);
    }

    @Override
    public boolean addUser(UserDto user) throws Exception {
        
        boolean result = userBO.addCustomer(user);
        
        return result;
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchPass(UserDto login) throws Exception {
        return userBO.searcgPass(login);
    }

    @Override
    public UserDto searchPasssword(UserDto login) throws Exception {
        return userBO.searchPasssword(login);
    }

}
