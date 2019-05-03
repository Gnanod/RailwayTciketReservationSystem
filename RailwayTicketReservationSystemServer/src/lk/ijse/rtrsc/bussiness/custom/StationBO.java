/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import java.util.List;
import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.StationDto;

/**
 *
 * @author Gnanod-PC
 */
public interface StationBO extends SuperBO{

    public boolean addStation(StationDto stationDto)throws Exception;

    public List<StationDto> getAllStation()throws Exception;

    public String searchStationId(String stationName)throws Exception;

    public boolean updateStation(StationDto station)throws Exception;
    
}
