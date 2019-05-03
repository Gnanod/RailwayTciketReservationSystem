/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import com.sun.corba.se.impl.orbutil.RepositoryIdFactory;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.ReservationBO;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.PassengerDto;
import lk.ijse.rtrsc.dto.PaymentDto;
import lk.ijse.rtrsc.dto.ReservationDto;
import lk.ijse.rtrsc.dto.ReservationSheetDetailDto;
import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.ReservationWagonDetailDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.dto.WagonDetailDto;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.entity.PassengerEntity;
import lk.ijse.rtrsc.entity.PaymentEntity;
import lk.ijse.rtrsc.entity.ReservationEntity;
import lk.ijse.rtrsc.entity.ReservationSheetDetail_pkEntity;
import lk.ijse.rtrsc.entity.ReservationSheetDetailentity;
import lk.ijse.rtrsc.entity.ReservationWagonDetailEntity;
import lk.ijse.rtrsc.entity.ReservationWagonDetail_PkEntity;
import lk.ijse.rtrsc.entity.RouteEntity;
import lk.ijse.rtrsc.entity.Route_PkEntity;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.PassengerRepository;
import lk.ijse.rtrsc.repository.custom.PaymentRepository;
import lk.ijse.rtrsc.repository.custom.ReservationRepository;
import lk.ijse.rtrsc.repository.custom.ReservationWagonDetailRepository;
import lk.ijse.rtrsc.repository.custom.SheetRepository;
import lk.ijse.rtrsc.repository.custom.SheetReservationRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class ReservationBOImpl implements ReservationBO {

    PassengerRepository passengerRepository;
    PaymentRepository paymentRepository;
    ReservationRepository reservationRepository;
    ReservationWagonDetailRepository reservationWagonDetailRepository;
    SheetRepository sheetRepository;
    SheetReservationRepository sheetReservationRepository;

    public ReservationBOImpl() {
        passengerRepository = (PassengerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PASSENGER);
        paymentRepository = (PaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PAYMENT);
        reservationRepository = (ReservationRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RESERVATION);
        reservationWagonDetailRepository = (ReservationWagonDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RESERVATIONWAGONDETAIL);
        sheetRepository = (SheetRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SHEET);
        sheetReservationRepository = (SheetReservationRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RESERVATIONSHEET);
    }

    public boolean addResrvation(ReservationTransactionDto f) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            PassengerDto dto = f.getPassengerDto();
            ReservationDto rDto = f.getReservationDto();
            System.out.println("12" + rDto);
            PaymentDto pDto = f.getPaymentDto();
            passengerRepository.setSession(session);
            reservationRepository.setSession(session);

            paymentRepository.setSession(session);
            reservationWagonDetailRepository.setSession(session);
            sheetRepository.setSession(session);
            sheetReservationRepository.setSession(session);
            PassengerEntity pe = new PassengerEntity();
            pe.setPassengerName(dto.getPassengerName());
            pe.setPassengerId(dto.getPassengerId());
            pe.setPassengerTp(dto.getPassengerTp());
            boolean isAdded1 = passengerRepository.save(pe);

            ReservationEntity rentity = new ReservationEntity();
            rentity.setAdults(rDto.getAdults());

            rentity.setChildren(rDto.getChildren());
            rentity.setEndStation(rDto.getEndStation());
            rentity.setPassengerEntity(pe);
            rentity.setStartStation(rDto.getStartStation());
            rentity.setTime(rDto.getTime());

            RouteDto routeDto = rDto.getRouteEntity();

            RouteEntity rEntity = new RouteEntity();
            rEntity.setDepatureTime(routeDto.getDepatureTime());
            rEntity.setRouteId(routeDto.getRouteId());
            rEntity.setRouteName(routeDto.getRouteName());

            DayDto getDay = f.getDayDto();
            System.out.println("iiiiiiiiii" + getDay);
            DayEntity day = new DayEntity();
            System.out.println("yyyyyyyyyuuuuu" + getDay.getDateId());
            day.setDateId(getDay.getDateId());
            day.setFriday(getDay.isFriday());
            day.setHolyDay(getDay.isHoliday());
            day.setMonday(getDay.isMonday());
            day.setSaturday(getDay.isSaturday());
            day.setSunday(getDay.isSunday());
            day.setThursday(getDay.isThursday());
            day.setTuesday(getDay.isTuesday());
            day.setWednesday(getDay.isWednesday());

            Route_PkEntity r = new Route_PkEntity();
            r.setDayId(getDay.getDateId());
            TrainDto searchTrain = routeDto.getTrainDto();

            TrainDto trainDto = new TrainDto();

            trainDto.setEngineNumber(searchTrain.getEngineNumber());
            trainDto.setFirstClass(searchTrain.isFirstClass());
            trainDto.setFirstClassWagonQty(searchTrain.getFirstClassWagonQty());
            trainDto.setObservationSaloon(searchTrain.isObservationSaloon());
            trainDto.setObservationSaloonWagonQty(searchTrain.getObservationSaloonWagonQty());
            trainDto.setSecondClass(searchTrain.isSecondClass());
            trainDto.setSecondClassWagonQty(searchTrain.getSecondClassWagonQty());
            trainDto.setStatus("NotAvailable");
            trainDto.setThirdClass(searchTrain.isThirdClass());
            trainDto.setThirdClassWagonQty(searchTrain.getThirdClassWagonQty());
            trainDto.setTrainType(searchTrain.getTrainType());

            r.setTrainId(searchTrain.getTrainId());

            rEntity.setDayEntity(day);
            rEntity.setRoute_PkEntity(r);
            //  TrainEntity train = new TrainEntity();
            // train.setTrainId("T001");
            //    rEntity.setTrain(train);
//            System.out.println("mmmmmmmmmm"+rEntity.getDayEntity().getDateId());
            rentity.setRouteEntity(rEntity);
            rentity.setDate(rDto.getDate());
            boolean isAdded2 = reservationRepository.save(rentity);

            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setReservation(rentity);
            paymentEntity.setTotal(pDto.getTotal());

            boolean isAdded3 = paymentRepository.save(paymentEntity);

            boolean isAdded4 = false;
//            List<ReservationWagonDetailDto> rwDto = f.getReservationWagonDetail();
//
//            for (ReservationWagonDetailDto ro : rwDto) {
//                ReservationWagonDetailEntity v = new ReservationWagonDetailEntity();
//                v.setReservation(rentity);
//                // WagonDto d = ro.getWagonDto();
//                // WagonEntity w = new WagonEntity();
//                // w.setWagonId(d.getWagonId());
//                //  w.setClassType(d.getClassType());
//                // w.setSheetQuantity(d.getSheetQuantity());
//
//                // v.setWagonEntity(w);
//                ReservationWagonDetail_PkEntity pk = new ReservationWagonDetail_PkEntity();
//                pk.setReservationId(rentity.getReservationId());
//                pk.setWagonDetailId(ro.getWagonDto().getWagonId());
//
//                v.setPkEntity(pk);
//                isAdded4 = reservationWagonDetailRepository.save(v);
//
//            }
//            List<SheetDto> list = f.getSheetList();
//            System.out.println("LISTLLLL" + list);

            List<ReservationSheetDetailDto> reservation = f.getReservationSheetDetail();
            WagonEntity w = new WagonEntity();
            System.out.println("reservatuin"+reservation);
            for (ReservationSheetDetailDto reservationSheetDetailDto : reservation) {

                ReservationSheetDetailentity e = new ReservationSheetDetailentity();
                e.setReservation(rentity);

                SheetDto s = reservationSheetDetailDto.getSheetEntity();

                SheetEntity se = new SheetEntity();
                se.setSheetID(s.getSheetID());
                se.setSheetType(s.getSheetType());
                se.setStatus(s.getStatus());

                WagonDto d = s.getWagonDto();

                
                System.out.println("wagonIddddddddddddddddddddddddddddddddddddddd"+d.getWagonId());
                w.setWagonId(d.getWagonId());
                w.setClassType(d.getClassType());
                w.setSheetQuantity(d.getSheetQuantity());
                
                se.setWagonEntity(w);
                ReservationSheetDetail_pkEntity pk = new ReservationSheetDetail_pkEntity();
                pk.setReservationId(rentity.getReservationId());
                pk.setSheetID(reservationSheetDetailDto.getSheetEntity().getSheetID());
                
                e.setSheetEntity(se);
                e.setReservationSheetDetail_pkEntity(pk);
                isAdded4 = sheetReservationRepository.save(e);

            }
            // WagonEntity wui = new WagonEntity();
//                for (SheetDto o : list) {
//                    WagonEntity wui = new WagonEntity();
//                    SheetEntity s = new SheetEntity();
//                    s.setSheetID(o.getSheetID());
//                    s.setSheetType(o.getSheetType());
//                    s.setStatus(o.getStatus());
//                    wui.setWagonId(o.getWagonDto().getWagonId());
//                    wui.setClassType(o.getWagonDto().getClassType());
//                    wui.setSheetQuantity(o.getWagonDto().getSheetQuantity());
//
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getWagonId());
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getClassType());
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getSheetQuantity());
//                    
//                    s.setWagonEntity(wui);
//                    isAdded4 = sheetReservationRepository.save(s);
//                  //  sheetRepository.update(s);
//                }

            if (isAdded1 && isAdded2 && isAdded3 && isAdded4) {
//                List<SheetDto> list = f.getSheetList();
//                System.out.println("LISTLLLL" + list);
//
//                WagonEntity wui = new WagonEntity();
//                for (SheetDto o : list) {
//                    SheetEntity s = new SheetEntity();
//                    s.setSheetID(o.getSheetID());
//                    s.setSheetType(o.getSheetType());
//                    s.setStatus(o.getStatus());
//                    System.out.println("Statusssssssssss" + o.getStatus());
//
//                    System.out.println("ttttttttt" + wui);
//                    wui.setWagonId(o.getWagonDto().getWagonId());
//                    wui.setClassType(o.getWagonDto().getClassType());
//                    wui.setSheetQuantity(o.getWagonDto().getSheetQuantity());
//
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getWagonId());
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getClassType());
//                    System.out.println("uuuuuuuuuuuuu" + o.getWagonDto().getSheetQuantity());
//
//                    s.setWagonEntity(wui);
//
//                    sheetRepository.update(s);
//                }

                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }

        }
    }

    @Override
    public SheetDto getAllSheets(Object sheet1) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSessions(session);
            session.beginTransaction();

            List< Object[]> sheets = sheetRepository.ViewSheets(sheet1);

            session.getTransaction().commit();
            if (sheets != null) {
                SheetDto dto = null;
                for (Object[] w : sheets) {
                    dto = new SheetDto();
                    dto.setSheetType((String) w[0]);
                    dto.setStatus((String) w[1]);
                    dto.setSheetID((int) w[3]);
                    WagonDto w1 = new WagonDto();
                    w1.setWagonId((String) w[2]);
                    dto.setWagonDto(w1);
                }
                return dto;
            } else {
                return null;
            }
        }
    }

}
