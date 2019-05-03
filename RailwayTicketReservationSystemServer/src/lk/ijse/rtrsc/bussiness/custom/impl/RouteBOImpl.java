/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.RouteBO;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.RouteDayDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.dto.Route_PkDto;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.dto.StationRouteDetailDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.entity.RouteEntity;
import lk.ijse.rtrsc.entity.Route_PkEntity;
import lk.ijse.rtrsc.entity.StationEntity;
import lk.ijse.rtrsc.entity.StationRoutesDetailEntity;
import lk.ijse.rtrsc.entity.StationRouteDetail_PkEntity;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.DayRepository;
import lk.ijse.rtrsc.repository.custom.RouteRepository;
import lk.ijse.rtrsc.repository.custom.StaionRouteDetailRepository;
import lk.ijse.rtrsc.repository.custom.StationRouteRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class RouteBOImpl implements RouteBO {

    private RouteRepository routeRepository;
    private DayRepository dayRepository;
    private StaionRouteDetailRepository stationRouteRepository;

    public RouteBOImpl() {

        routeRepository = (RouteRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ROUTE);
        dayRepository = (DayRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.DAY);
        stationRouteRepository = (StaionRouteDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.STATIONROUTE);
    }

    @Override
    public boolean addRouteDay(RouteDayDto routeDay) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            routeRepository.setSession(session);
            dayRepository.setSession(session);
            stationRouteRepository.setSession(session);
            boolean isAdded1 = false;
            boolean isAdded2 = false;
            boolean isAdded3 = false;
            DayDto dayDto = routeDay.getDayDto();
            DayEntity dayEntity = new DayEntity();
            dayEntity.setDateId(dayDto.getDateId());
            dayEntity.setFriday(dayDto.isFriday());
            dayEntity.setHolyDay(dayDto.isHoliday());
            dayEntity.setMonday(dayDto.isMonday());
            dayEntity.setSaturday(dayDto.isSaturday());
            dayEntity.setSunday(dayDto.isSunday());
            dayEntity.setThursday(dayDto.isThursday());
            dayEntity.setTuesday(dayDto.isTuesday());
            dayEntity.setWednesday(dayDto.isWednesday());

            isAdded1 = dayRepository.save(dayEntity);

            TrainDto searchTrain = routeDay.getTrainDto();
            TrainEntity trainEntity = new TrainEntity();
            trainEntity.setTrainId(searchTrain.getTrainId());

            trainEntity.setEngineNumber(searchTrain.getEngineNumber());
            trainEntity.setFirstClass(searchTrain.isFirstClass());
            trainEntity.setFirstClassWagonQty(searchTrain.getFirstClassWagonQty());
            trainEntity.setObservationSaloon(searchTrain.isObservationSaloon());
            trainEntity.setObservationSaloonWagonQty(searchTrain.getObservationSaloonWagonQty());
            trainEntity.setSecondClass(searchTrain.isSecondClass());
            trainEntity.setSecondClassWagonQty(searchTrain.getSecondClassWagonQty());
            trainEntity.setStatus("NotAvailable");
            trainEntity.setRouteStatus("NotAvailable");
            trainEntity.setThirdClass(searchTrain.isThirdClass());
            trainEntity.setThirdClassWagonQty(searchTrain.getThirdClassWagonQty());
            trainEntity.setTrainType(searchTrain.getTrainType());

            RouteDto routeDto = routeDay.getRouteDto();
            RouteEntity routeEntity = new RouteEntity();

            routeEntity.setDepatureTime(routeDto.getDepatureTime());
            routeEntity.setRouteId(routeDto.getRouteId());
            routeEntity.setRouteName(routeDto.getRouteName());
            routeEntity.setDayEntity(dayEntity);
            routeEntity.setTrain(trainEntity);

            Route_PkDto routePk = new Route_PkDto();

            Route_PkEntity routePkEntity = new Route_PkEntity();
            routePkEntity.setDayId(dayDto.getDateId());
            routePkEntity.setTrainId(trainEntity.getTrainId());

            routeEntity.setRoute_PkEntity(routePkEntity);
            isAdded2 = routeRepository.save(routeEntity);

            List<StationRouteDetailDto> list = routeDay.getList();

            for (StationRouteDetailDto t : list) {
                StationDto stationDto = routeDay.getStationDto();
                StationEntity stationEntity = new StationEntity();
                stationEntity.setStationId(t.getStationEntity().getStationId());
                stationEntity.setStationName(t.getStationEntity().getStationName());

                StationRoutesDetailEntity entity = new StationRoutesDetailEntity();

                entity.setRoute(routeEntity);
                entity.setStationEntity(stationEntity);
                entity.setStationStatus(t.getStationStatus());

                StationRouteDetail_PkEntity pk = new StationRouteDetail_PkEntity();
                pk.setRouteId(routeDto.getRouteId());
                pk.setStationId(t.getStationEntity().getStationId());

                entity.setStationRouteDetail_PkEntity(pk);
                isAdded3 = stationRouteRepository.save(entity);
                System.out.println("isAdded3" + isAdded3);
            }

            if (isAdded1 && isAdded2 && isAdded3) {
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }

        }
    }

    @Override
    public List<RouteDto> getAllRoutes() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            routeRepository.setSession(session);
            session.beginTransaction();
            List<RouteEntity> routeEntity = routeRepository.findAll();

            session.getTransaction().commit();
            if (routeEntity != null) {
                List<RouteDto> alRouts = new ArrayList<>();
                RouteDto dto = null;
                for (RouteEntity r : routeEntity) {
                    dto = new RouteDto();
                    dto.setRouteId(r.getRouteId());
                    dto.setRouteName(r.getRouteName());
                    DayEntity day = r.getDayEntity();
                    DayDto dt = new DayDto();
                    dt.setDateId(day.getDateId());
                    dto.setDayDto(dt);
                    dto.setDepatureTime(r.getDepatureTime());

                    alRouts.add(dto);
                }
                return alRouts;
            } else {
                return null;
            }
        }
    }

    @Override
    public DayDto searchDays(String dateId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            dayRepository.setSession(session);
            session.beginTransaction();
            DayEntity dayEntity = dayRepository.findById(dateId);

            session.getTransaction().commit();
            DayDto dto = null;
            if (dayEntity != null) {
                dto = new DayDto();
                dto.setFriday(dayEntity.isFriday());
                dto.setSunday(dayEntity.isSunday());
                dto.setMonday(dayEntity.isMonday());
                dto.setTuesday(dayEntity.isTuesday());
                dto.setWednesday(dayEntity.isWednesday());
                dto.setThursday(dayEntity.isThursday());
                dto.setSaturday(dayEntity.isSaturday());
                dto.setHoliday(dayEntity.isHolyDay());
            } else {
                return null;
            }
            return dto;
        }
    }

    @Override
    public boolean deleteRoute(String routeId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            routeRepository.setSession(session);
            session.beginTransaction();
            RouteEntity route = routeRepository.findById(routeId);

            boolean result = false;
            if (route != null) {
                routeRepository.delete(route);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public RouteDto searchTrain(String routeName) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            routeRepository.setSessions(session);
            session.beginTransaction();

            List< Object[]> searchTrain = routeRepository.searchTrains(routeName);

            session.getTransaction().commit();
            if (searchTrain != null) {
                RouteDto dto = null;
                for (Object[] ob : searchTrain) {
                    dto = new RouteDto();
                    String trainId = (String) ob[0];
                    TrainDto train = new TrainDto();
                    train.setTrainId(trainId);
                    dto.setTrainDto(train);
                    DayDto date = new DayDto();
                    date.setDateId((String) ob[1]);
                    dto.setDayDto(date);
                    dto.setDepatureTime((String) ob[2]);
                    dto.setRouteId((String) ob[3]);

                }
                return dto;
            } else {
                return null;
            }
        }
    }

}
