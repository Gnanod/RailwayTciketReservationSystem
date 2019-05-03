/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.TrainBO;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.entity.UserEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.TrainRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class TrainBOImpl implements TrainBO {

    private TrainRepository trainRepository;

    public TrainBOImpl() {
        trainRepository = (TrainRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.TRAIN);
        System.out.println("rrrrrrrrrrrrrrrrrrrrr");
    }

    @Override
    public boolean addTrain(TrainDto t) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setSession(session);
            session.beginTransaction();
            TrainEntity train = new TrainEntity();
            train.setTrainId(t.getTrainId());
            train.setEngineNumber(t.getEngineNumber());
            train.setFirstClass(t.isFirstClass());
            train.setSecondClass(t.isSecondClass());
            train.setThirdClass(t.isThirdClass());
            train.setObservationSaloon(t.isObservationSaloon());
            train.setFirstClassWagonQty(t.getFirstClassWagonQty());
            train.setSecondClassWagonQty(t.getSecondClassWagonQty());
            train.setThirdClassWagonQty(t.getThirdClassWagonQty());
            train.setObservationSaloonWagonQty(t.getObservationSaloonWagonQty());
            train.setTrainType(t.getTrainType());
            train.setStatus(t.getStatus());
            train.setRouteStatus(t.getRouteStatus());
            boolean result = trainRepository.save(train);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public TrainDto searchTrain(String trainId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            trainRepository.setSession(session);
            session.beginTransaction();
            TrainEntity t = trainRepository.findById(trainId);
            TrainDto train = new TrainDto();
            if (t != null) {
                train.setTrainId(t.getTrainId());
                train.setEngineNumber(t.getEngineNumber());
                train.setFirstClassWagonQty(t.getFirstClassWagonQty());
                train.setSecondClassWagonQty(t.getSecondClassWagonQty());
                train.setThirdClassWagonQty(t.getThirdClassWagonQty());
                train.setObservationSaloonWagonQty(t.getObservationSaloonWagonQty());
                train.setTrainType(t.getTrainType());
                train.setRouteStatus(t.getRouteStatus());
            } else {
                return null;
            }
            session.getTransaction().commit();
            return train;
        }
    }

    @Override
    public List<TrainDto> getAllTrains() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setSession(session);
            session.beginTransaction();
            List<TrainEntity> trainEntity = trainRepository.findAll();
            session.getTransaction().commit();
            if (trainEntity != null) {
                List<TrainDto> alTrains = new ArrayList<>();
                TrainDto dto = null;
                for (TrainEntity t : trainEntity) {
                    dto = new TrainDto();
                    dto.setTrainId(t.getTrainId());
                    dto.setEngineNumber(t.getEngineNumber());
                    dto.setFirstClassWagonQty(t.getFirstClassWagonQty());
                    dto.setSecondClassWagonQty(t.getSecondClassWagonQty());
                    dto.setThirdClassWagonQty(t.getThirdClassWagonQty());
                    dto.setObservationSaloonWagonQty(t.getObservationSaloonWagonQty());
                    dto.setTrainType(t.getTrainType());
                    dto.setRouteStatus(t.getRouteStatus());
                    // dto.setTrainType(t.getTrainType());
                    alTrains.add(dto);
                }
                return alTrains;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean updateTrain(TrainDto t) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setSession(session);
            session.beginTransaction();
            TrainEntity train = new TrainEntity();
            train.setTrainId(t.getTrainId());
            train.setEngineNumber(t.getEngineNumber());
            train.setFirstClass(t.isFirstClass());
            train.setSecondClass(t.isSecondClass());
            train.setThirdClass(t.isThirdClass());
            train.setObservationSaloon(t.isObservationSaloon());
            train.setFirstClassWagonQty(t.getFirstClassWagonQty());
            train.setSecondClassWagonQty(t.getSecondClassWagonQty());
            train.setThirdClassWagonQty(t.getThirdClassWagonQty());
            train.setObservationSaloonWagonQty(t.getObservationSaloonWagonQty());
            train.setTrainType(t.getTrainType());
            train.setRouteStatus(t.getRouteStatus());
            System.out.println("UPDATEEEEEEEEEEEEEE" + train);
            trainRepository.update(train);
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrain(String deleteTrainId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setSession(session);
            session.beginTransaction();
            TrainEntity train = trainRepository.findById(deleteTrainId);
            boolean result = false;
            if (train != null) {
                trainRepository.delete(train);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TrainDto> getAllAvailableTrains() throws Exception {
        System.out.println("rrrrrrrrruuuuuuuuuuuuuuqqqqqqqqqqqqqqqqq");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setTrainSession(session);
            session.beginTransaction();
            List<Object[]> trainEntity = trainRepository.getAllTrains();
            session.getTransaction().commit();
            if (trainEntity != null) {
                List<TrainDto> alTrains = new ArrayList<>();
                TrainDto dto = null;
                for (Object[] t : trainEntity) {
                    dto = new TrainDto();
                    dto.setTrainId((String) t[0]);
                    dto.setEngineNumber((String) t[1]);
                    dto.setFirstClassWagonQty((int) t[2]);
                    dto.setSecondClassWagonQty((int) t[3]);
                    dto.setThirdClassWagonQty((int) t[4]);
                    dto.setObservationSaloonWagonQty((int) t[5]);
                    dto.setTrainType((String) t[6]);
                    // dto.setTrainType(t.getTrainType());
                    alTrains.add(dto);
                }
                return alTrains;
            } else {
                return null;
            }
        }
    }

    @Override
    public List<TrainDto> getAvailableTrains() throws Exception {
        System.out.println("rrrrrrrrruuuuuuuuuuuuuuqqqqqqqqqqqqqqqqq");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setTrainSession(session);
            session.beginTransaction();
            List<Object[]> trainEntity = trainRepository.getAllTrains();
            session.getTransaction().commit();
            if (trainEntity != null) {
                List<TrainDto> alTrains = new ArrayList<>();
                TrainDto dto = null;
                for (Object[] t : trainEntity) {
                    dto = new TrainDto();
                    dto.setTrainId((String) t[0]);
                    dto.setEngineNumber((String) t[1]);
                    dto.setFirstClassWagonQty((int) t[2]);
                    dto.setSecondClassWagonQty((int) t[3]);
                    dto.setThirdClassWagonQty((int) t[4]);
                    dto.setObservationSaloonWagonQty((int) t[5]);
                    dto.setTrainType((String) t[6]);
                    // dto.setTrainType(t.getTrainType());
                    alTrains.add(dto);
                }
                return alTrains;
            } else {
                return null;
            }
        }
    }

    @Override
    public int getRouteCount(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainRepository.setTrainSession(session);
            session.beginTransaction();
            int trainEntity = trainRepository.getRouteCount(name);
            session.getTransaction().commit();
            return trainEntity; 
        }
    }

}
