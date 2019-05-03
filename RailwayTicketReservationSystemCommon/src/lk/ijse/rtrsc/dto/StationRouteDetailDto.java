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
public class StationRouteDetailDto extends SuperDto{
    private String stationStatus; 
    private RouteDto route;   
    private StationDto stationEntity;   
    private StationRouteDetail_PkDto stationRouteDetail_PkDto;

    public StationRouteDetailDto() {
    }

    public StationRouteDetailDto(String stationId,String routeId,String stationStatus, RouteDto route, StationDto stationEntity, StationRouteDetail_PkDto stationRouteDetail_PkDto) {
        this.stationStatus = stationStatus;
        this.route = route;
        this.stationEntity = stationEntity;
        this.stationRouteDetail_PkDto = new StationRouteDetail_PkDto(stationId,routeId);
    }

    /**
     * @return the stationStatus
     */
    public String getStationStatus() {
        return stationStatus;
    }

    /**
     * @param stationStatus the stationStatus to set
     */
    public void setStationStatus(String stationStatus) {
        this.stationStatus = stationStatus;
    }

    /**
     * @return the route
     */
    public RouteDto getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(RouteDto route) {
        this.route = route;
    }

    /**
     * @return the stationEntity
     */
    public StationDto getStationEntity() {
        return stationEntity;
    }

    /**
     * @param stationEntity the stationEntity to set
     */
    public void setStationEntity(StationDto stationEntity) {
        this.stationEntity = stationEntity;
    }

    /**
     * @return the stationRouteDetail_PkDto
     */
    public StationRouteDetail_PkDto getStationRouteDetail_PkDto() {
        return stationRouteDetail_PkDto;
    }

    /**
     * @param stationRouteDetail_PkDto the stationRouteDetail_PkDto to set
     */
    public void setStationRouteDetail_PkDto(StationRouteDetail_PkDto stationRouteDetail_PkDto) {
        this.stationRouteDetail_PkDto = stationRouteDetail_PkDto;
    }
    
    
}
