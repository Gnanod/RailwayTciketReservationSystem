/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;


import java.util.List;

/**
 *
 * @author Gnanod-PC
 */
public class RouteDayDto extends SuperDto{

    private RouteDto routeDto;
    private DayDto dayDto;
    private TrainDto trainDto;
    private StationDto stationDto;
    private List<StationRouteDetailDto> list;

    public RouteDayDto() {
    }

    public RouteDayDto(RouteDto routeDto, DayDto dayDto, TrainDto trainDto, StationDto stationDto, List<StationRouteDetailDto> list) {
        this.routeDto = routeDto;
        this.dayDto = dayDto;
        this.trainDto = trainDto;
        this.stationDto = stationDto;
        this.list = list;
    }

    /**
     * @return the routeDto
     */
    public RouteDto getRouteDto() {
        return routeDto;
    }

    /**
     * @param routeDto the routeDto to set
     */
    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
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

    /**
     * @return the stationDto
     */
    public StationDto getStationDto() {
        return stationDto;
    }

    /**
     * @param stationDto the stationDto to set
     */
    public void setStationDto(StationDto stationDto) {
        this.stationDto = stationDto;
    }

    /**
     * @return the list
     */
    public List<StationRouteDetailDto> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<StationRouteDetailDto> list) {
        this.list = list;
    }
    
    
 
   
  
}
