/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import lk.ijse.rtrsc.dto.ViewTrainsDto;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.ViewTrainsService;
import lk.ijse.rtrsc.service.custom.WagonService;

/**
 *
 * @author Gnanod-PC
 */
public class ViewTrainsController {

    public static ViewTrainsDto searchTrains(Object[] ob) throws Exception {
          ViewTrainsService viewTrainService = (ViewTrainsService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.VIEWTRAINS);
        
          return  viewTrainService.searchTrains(ob);
    }
    
}
