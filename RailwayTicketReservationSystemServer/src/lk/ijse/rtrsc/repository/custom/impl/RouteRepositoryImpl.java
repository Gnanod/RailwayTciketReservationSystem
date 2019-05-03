/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.RouteEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.RouteRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class RouteRepositoryImpl extends SuperRepositoryImpl<RouteEntity, String> implements RouteRepository{

    private Session session;
    @Override
    public void setSessions(Session session) {
        this.session=session;
    }

    @Override
    public List<Object[]> searchTrains(String routeName) {
        List<Object []> entity = session.createSQLQuery("select trainId,dateId,depatureTime,routeId from routeentity where routeName='"+routeName+"'").list();//"+ob[2]+"
            System.out.println("NNNNN"+entity);
        return entity;
    }
    
}
