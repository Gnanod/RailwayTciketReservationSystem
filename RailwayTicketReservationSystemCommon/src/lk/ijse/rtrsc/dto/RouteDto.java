/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

/**
 *
 * @author Gnanod-PC
 */
public class RouteDto extends SuperDto{
    private String routeId;
    private String routeName;
    private String depatureTime;
    private DayDto dayDto;
    private TrainDto trainDto;
    private Route_PkDto route_PkDto;

    public RouteDto(String trainId,String dayId,String routeId, String routeName, String depatureTime, DayDto dayDto, TrainDto trainDto, Route_PkDto route_PkDto) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.depatureTime = depatureTime;
        this.dayDto = dayDto;
        this.trainDto = trainDto;
        this.route_PkDto = route_PkDto;
    }
    
    
    public RouteDto() {
    }

    

    /**
     * @return the routeId
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the routeId to set
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the routeName
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * @param routeName the routeName to set
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * @return the depatureTime
     */
    public String getDepatureTime() {
        return depatureTime;
    }

    /**
     * @param depatureTime the depatureTime to set
     */
    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

    /**
     * @return the dayDto
     */
    public DayDto getDayDto() {
        return dayDto;
    }

    /**
     * @param dayDto the dayDto to set
     */
    public void setDayDto(DayDto dayDto) {
        this.dayDto = dayDto;
    }

    /**
     * @return the trainDto
     */
    public TrainDto getTrainDto() {
        return trainDto;
    }

    /**
     * @param trainDto the trainDto to set
     */
    public void setTrainDto(TrainDto trainDto) {
        this.trainDto = trainDto;
    }
    
    
}
