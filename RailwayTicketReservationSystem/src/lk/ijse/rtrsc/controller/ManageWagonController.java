/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.WagonService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageWagonController {

    public static boolean addWagon(Wagon w) throws Exception {
        WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
       return  wagonService.addWagon(w);
    }

    public static List<ViewWagonDto> ViewAllWagons() throws Exception {
        WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
       return  wagonService.ViewAllWagons();
    }

    public static boolean deleteWagon(String wagonId) throws Exception {
        WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
       return  wagonService.deleteWagon(wagonId);
    }

    public static boolean updateWagon(WagonDto wagon) throws Exception {
        WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
       return  wagonService.updateWagon(wagon);
    }
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
    }

    public static List<ViewWagonDto> searchWagon(String wagon) throws Exception {
        WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
        return  wagonService.searchWagon(wagon);
    }

    public static List<WagonDto> getWagon(Object[] ob) throws Exception {
         WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
        return  wagonService.getWagon(ob);
    }

    public static WagonDto searchWagons(String wagonId) throws Exception {
           WagonService wagonService = (WagonService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.WAGON);
        return  wagonService.searchWagons(wagonId);
    }

   

    
    
}
