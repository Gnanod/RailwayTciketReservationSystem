/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom;

import java.util.List;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public interface TrainRepository extends SuperRepository<TrainEntity,String>{

    public void setTrainSession(Session session)throws Exception;

    public TrainEntity SearchById(String trainId)throws Exception;  



    public List<Object[]> getAllTrains()throws Exception;

    public int getRouteCount(String name)throws Exception;

  

    
    
}
