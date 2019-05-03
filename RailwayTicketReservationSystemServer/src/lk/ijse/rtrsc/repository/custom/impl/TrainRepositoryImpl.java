/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.math.BigInteger;
import java.util.List;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.TrainRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class TrainRepositoryImpl extends SuperRepositoryImpl<TrainEntity, String> implements TrainRepository {

    private Session session;

    public TrainRepositoryImpl() {
    }

    @Override
    public void setTrainSession(Session session) throws Exception {
        System.out.println("rrrrrrrr" + session);
        this.session = session;
    }

    @Override
    public TrainEntity SearchById(String trainId) throws Exception {
        System.out.println("3333333333" + trainId);
        TrainEntity train = (TrainEntity) session.createQuery("from trainentity where trainId='" + trainId + "'").uniqueResult();;
        System.out.println("999999999999" + train);
        return train;
    }

    @Override
    public List<Object[]> getAllTrains() throws Exception {
        List<Object[]> entity = session.createSQLQuery(" select trainId,engineNumber,firstClassWagonQty ,secondClassWagonQty,thirdClassWagonQty,observationSaloonWagonQty,trainType from trainentity where status='Available '").list();
        // System.out.println("oooooRewnj"+day);
        return entity;
    }

    @Override
    public int getRouteCount(String name) throws Exception {
        BigInteger ob = (BigInteger) session.createSQLQuery(" select count(routeId) from  trainentity t,routeentity r where t.trainId=r.trainId && r.trainId='" + name + "'").list().get(0);
        return ob.intValue();
    }

}
