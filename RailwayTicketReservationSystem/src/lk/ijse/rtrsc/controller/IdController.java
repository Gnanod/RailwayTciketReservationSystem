/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.text.NumberFormat;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.IdService;

/**
 *
 * @author Gnanod-PC
 */
public class IdController {
     public static String getNewID(IdDto idDTO, String prifix) throws Exception {
        IdService iDService = (IdService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ID);
        String lastId = iDService.getResult(idDTO);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prifix + newID;
        } else {
            return prifix + "001";
        }
        
    }
}
