/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.ViewTrainsDto;

/**
 *
 * @author Gnanod-PC
 */
public interface ViewTrainsBO extends SuperBO{

    public ViewTrainsDto searchTrains(Object[] ob)throws Exception;

  
    
}
