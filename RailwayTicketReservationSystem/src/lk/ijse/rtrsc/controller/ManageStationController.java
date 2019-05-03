/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.StationService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageStationController {

    public static boolean addStation(StationDto stationDto) throws Exception {
        StationService  statioService = (StationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.STATION);
        return statioService.addStation(stationDto);
    }

    public static List<StationDto> getAllStation() throws Exception {
        StationService  statioService = (StationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.STATION);
        return statioService.getAllStation();
    }

    public static String searchStationId(String stationName) throws Exception {
         StationService  statioService = (StationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.STATION);
        return statioService.searchStationId(stationName);
    }

    public static boolean updateStation(StationDto station) throws Exception {
        StationService  statioService = (StationService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.STATION);
        return statioService.updateStation(station);
    }
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.STATION);
    }
  

   
}
