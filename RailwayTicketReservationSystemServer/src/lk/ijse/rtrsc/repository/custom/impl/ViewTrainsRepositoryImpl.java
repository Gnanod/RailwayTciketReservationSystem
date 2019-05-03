/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.UserEntity;
import lk.ijse.rtrsc.entity.ViewTrainsEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.UserRepository;
import lk.ijse.rtrsc.repository.custom.ViewTrainsRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class ViewTrainsRepositoryImpl  extends SuperRepositoryImpl<ViewTrainsEntity, String> implements ViewTrainsRepository{
private Session session;
    @Override
    public void setSessions(Session session) throws Exception {
        this.session= session;
    }

    @Override
    public List<Object[]> ViewTrains(Object[] ob) throws Exception {
//       String day=  ob[3].toString();
       
        List<Object []> entity = session.createSQLQuery("select routeName,depaturetime,traintype from  trainentity t,routeentity r,dayentity d,stationroutesdetailentity s where t.trainId=r.trainId && r.dateId= d. dateId && r.routeId=s.routeId && s.stationId='"+ob[3]+"' && s.stationStatus='Reach' && "+ob[2]+"=true").list();
       // System.out.println("oooooRewnj"+day);
        return entity;
    }
    
}
