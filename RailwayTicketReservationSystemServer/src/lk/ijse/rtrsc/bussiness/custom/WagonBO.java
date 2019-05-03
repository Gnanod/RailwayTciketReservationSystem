/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import java.util.List;
import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDto;

/**
 *
 * @author Gnanod-PC
 */
public interface WagonBO extends SuperBO{

    public boolean addWagon(Wagon w)throws Exception;

    public List<ViewWagonDto> ViewAllWagons()throws Exception;



    public boolean deleteWagon(String wagonId)throws Exception;

    public boolean updateWagon(WagonDto wagon)throws Exception;

    public List<ViewWagonDto> searchWagon(String wagon)throws Exception;

    public List<WagonDto> getWagon(Object[] ob)throws Exception;

    public WagonDto searchWagons(String w)throws Exception;
    
}
