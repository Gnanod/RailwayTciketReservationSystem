/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.UserDto;

/**
 *
 * @author Gnanod-PC
 */
public interface UserBO extends SuperBO{

    public boolean addCustomer(UserDto user)throws Exception;

    public boolean searcgPass(UserDto login)throws Exception;

    public UserDto searchPasssword(UserDto login)throws Exception;
    
}
