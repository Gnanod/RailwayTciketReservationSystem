/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom;

import java.util.List;
import lk.ijse.rtrsc.entity.RouteEntity;
import lk.ijse.rtrsc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public interface RouteRepository extends SuperRepository<RouteEntity,String>{

    public void setSessions(Session session);

    public List<Object[]> searchTrains(String routeName);
    
}
