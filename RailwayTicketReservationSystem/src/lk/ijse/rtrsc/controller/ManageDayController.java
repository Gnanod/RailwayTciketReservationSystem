/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.DayService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageDayController {

    public static DayDto getDay(String dayId) throws Exception {
        DayService service = (DayService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.DAY);
        return service.getDay(dayId);
    }
    
}
