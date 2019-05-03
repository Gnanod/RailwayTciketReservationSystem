/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.StationBO;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.entity.StationEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.StationRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class StationBOImpl implements StationBO {

    private StationRepository stationRepository;

    public StationBOImpl() {
        stationRepository = (StationRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.STATION);
    }

    @Override
    public boolean addStation(StationDto s) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            stationRepository.setSession(session);
            session.beginTransaction();
            StationEntity station = new StationEntity();
            station.setColombo_Kandy(s.isColombo_Kandy());
            station.setKandy_Jaffna(s.isKandy_Jaffna());
            station.setMathara_Colombo(s.isMathara_Colombo());
            station.setStationId(s.getStationId());
            station.setStationName(s.getStationName());
            boolean result = stationRepository.save(station);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<StationDto> getAllStation() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            stationRepository.setSession(session);
            session.beginTransaction();
            List<StationEntity> stationEntity = stationRepository.findAll();
            session.getTransaction().commit();
            if (stationEntity != null) {
                List<StationDto> alStations = new ArrayList<>();
                StationDto dto = null;
                for (StationEntity t : stationEntity) {
                    dto = new StationDto();
                    dto.setStationId(t.getStationId());
                    dto.setStationName(t.getStationName());

                    alStations.add(dto);
                }
                return alStations;
            } else {
                return null;
            }
        }
    }

    @Override
    public String searchStationId(String stationName) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            stationRepository.setSessions(session);
            session.beginTransaction();
            List<Object[]> ob = stationRepository.searchStationId(stationName);
            String stationId = null;
            for (Object[] objects : ob) {
                stationId = (String) objects[0];
            }
            session.getTransaction().commit();
            return stationId;
        }
    }

    @Override
    public boolean updateStation(StationDto s) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            stationRepository.setSession(session);
            session.beginTransaction();
            StationEntity station = new StationEntity();
            station.setColombo_Kandy(s.isColombo_Kandy());
            station.setKandy_Jaffna(s.isKandy_Jaffna());
            station.setMathara_Colombo(s.isMathara_Colombo());
            station.setStationId(s.getStationId());
            station.setStationName(s.getStationName());
            stationRepository.update(station);
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

}
