/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import lk.ijse.rtrsc.dto.UserDto;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.UserService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageUserController {

    public static boolean addUser(UserDto user) throws Exception {
        UserService userService = (UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        
        return userService.addUser(user);
    }

    public static boolean searchPass(UserDto login) throws Exception {
        UserService userService = (UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
   
        return userService.searchPass(login);
    }

    public static UserDto searchPasssword(UserDto login) throws Exception {
        UserService userService = (UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
       
        return userService.searchPasssword(login);
    }

}
