/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface DayService extends SuperService{

    public DayDto getDay(String dayId)throws Exception;

    
}
