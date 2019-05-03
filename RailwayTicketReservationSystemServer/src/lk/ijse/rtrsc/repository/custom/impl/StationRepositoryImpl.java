/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.StationEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.StationRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class StationRepositoryImpl extends SuperRepositoryImpl<StationEntity, String> implements StationRepository{

    private Session session;
    @Override
    public  List<Object []> searchStationId(String stationName) throws Exception {
         List<Object []> entity = session.createSQLQuery("select stationId,colombo_Kandy,kandy_Jaffna,mathara_Colombo from stationentity where stationName='"+stationName+"'").list();
         String stationId=null;
      
         return entity;
    }

    @Override
    public void setSessions(Session session) throws Exception {
        this.session=session;
    }
    
}
