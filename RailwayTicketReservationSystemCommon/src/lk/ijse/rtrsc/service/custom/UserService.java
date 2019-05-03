/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import lk.ijse.rtrsc.dto.UserDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface UserService extends SuperService{

    public boolean addUser(UserDto user)throws Exception;

    public boolean searchPass(UserDto login)throws Exception;

    public UserDto searchPasssword(UserDto login)throws Exception;
    
}
