/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.RouteDayDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.RouteService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageRouteController {

    public static boolean addRouteDay(RouteDayDto routeDay) throws Exception {
        RouteService routeService = (RouteService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
      
        return routeService.addRouteDay(routeDay);
    }

    public static List<RouteDto> getAllRoutes() throws Exception {
         RouteService routeService = (RouteService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
        return routeService.getAllRoutes();
    }

    public static DayDto searchDays(String dateId) throws Exception {
         RouteService routeService = (RouteService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
        return routeService.searchDays(dateId);
    }

    public static boolean deleteRoute(String routeId) throws Exception {
          RouteService routeService = (RouteService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
        return routeService.deleteRoute(routeId);
    }

    public static RouteDto searchTrain(String routeName) throws Exception {
         RouteService routeService = (RouteService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
          
         return routeService.searchTrain(routeName);
    }

   public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ROUTE);
    }
    
}
