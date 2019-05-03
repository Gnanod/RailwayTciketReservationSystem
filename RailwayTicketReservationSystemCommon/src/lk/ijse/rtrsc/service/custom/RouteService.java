/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import java.util.List;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.RouteDayDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface RouteService extends SuperService{

    public boolean addRouteDay(RouteDayDto routeDay)throws Exception;

    public List<RouteDto> getAllRoutes()throws Exception;

    public DayDto searchDays(String dateId)throws Exception;

    public boolean deleteRoute(String routeId)throws Exception;

    public RouteDto searchTrain(String routeName)throws Exception;
    
}
