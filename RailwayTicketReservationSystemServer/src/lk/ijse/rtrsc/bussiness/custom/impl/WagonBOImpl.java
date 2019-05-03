/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.WagonBO;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDetailDto;
import lk.ijse.rtrsc.dto.WagonDetail_PkDto;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.entity.ViewWagonEntity;
import lk.ijse.rtrsc.entity.WagonDetailEntity;
import lk.ijse.rtrsc.entity.WagonDetail_PkEntity;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.SheetRepository;
import lk.ijse.rtrsc.repository.custom.ViewWagonRepository;
import lk.ijse.rtrsc.repository.custom.WagonDetailRepository;
import lk.ijse.rtrsc.repository.custom.WagonRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class WagonBOImpl implements WagonBO {
    
    private WagonRepository wagonRepository;
    private WagonDetailRepository wagonDetailRepository;
    private ViewWagonRepository viewWagonRepository;
    private SheetRepository sheetRepository;
    public WagonBOImpl() {
        wagonRepository = (WagonRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.WAGON);
        wagonDetailRepository = (WagonDetailRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.WAGONDETAIL);
        viewWagonRepository = (ViewWagonRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.VIEWWAGON);
        sheetRepository = (SheetRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SHEET);
    }
    
    @Override
    public boolean addWagon(Wagon w) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            session.beginTransaction();
            TrainDto trainDto = w.getTrain();
            List<WagonDetailDto> wagonDetailList = w.getWagonDetailList();
            WagonDto wagonDto = w.getWagon();
            
            TrainEntity trainEntity = new TrainEntity();
            
            trainEntity.setEngineNumber(trainDto.getEngineNumber());
            trainEntity.setFirstClass(trainDto.isFirstClass());
            trainEntity.setFirstClassWagonQty(trainDto.getFirstClassWagonQty());
            trainEntity.setObservationSaloon(trainDto.isObservationSaloon());
            trainEntity.setObservationSaloonWagonQty(trainDto.getObservationSaloonWagonQty());
            trainEntity.setSecondClass(trainDto.isSecondClass());
            trainEntity.setSecondClassWagonQty(trainDto.getSecondClassWagonQty());
            trainEntity.setStatus("NotAvailable");
            trainEntity.setThirdClass(trainDto.isThirdClass());
            trainEntity.setThirdClassWagonQty(trainDto.getThirdClassWagonQty());
            trainEntity.setTrainType(trainDto.getTrainType());
            trainEntity.setRouteStatus(trainDto.getRouteStatus());
            trainEntity.setTrainId(trainDto.getTrainId());
            wagonRepository.setSession(session);
            wagonDetailRepository.setSession(session);
            sheetRepository.setSession(session);
            boolean isAdded1 = false;
            boolean isAdded2 = false;
            boolean isAdded3 = false;
            for (WagonDetailDto wagonDetailDto : wagonDetailList) {
                
                WagonEntity wagonEntity = new WagonEntity();
                wagonEntity.setWagonId(wagonDetailDto.getWagonEntity().getWagonId());
                wagonEntity.setSheetQuantity(wagonDetailDto.getWagonEntity().getSheetQuantity());
                wagonEntity.setClassType(wagonDetailDto.getWagonEntity().getClassType());
                
                isAdded1 = wagonRepository.save(wagonEntity);
                
                
                List<SheetDto> sheet= w.getSheetList();
                    for (SheetDto sheetDto : sheet) {
                        SheetEntity sheetE = new SheetEntity();
                        sheetE.setSheetType(wagonDetailDto.getWagonEntity().getClassType());
                       // System.out.println("nnnnnnnnnnn"+sheetDto.getSheetType());
                        sheetE.setStatus(sheetDto.getStatus());
                        sheetE.setWagonEntity(wagonEntity);
                        isAdded3 = sheetRepository.save(sheetE);
                    }
                WagonDetailEntity wagonDetail = new WagonDetailEntity();
                wagonDetail.setTrain(trainEntity);
                //  wagonDetail.setWagonDetailId(wagonDetailDto.getWagonDetailId());
                wagonDetail.setWagonEntity(wagonEntity);
                
                WagonDetail_PkDto wagonDetailPkDto = new WagonDetail_PkDto();
                
                WagonDetail_PkEntity wagonDetailPk = new WagonDetail_PkEntity();
                wagonDetailPk.setTrainId(trainDto.getTrainId());
                wagonDetailPk.setWagonId(wagonDetailDto.getWagonEntity().getWagonId());
                
                wagonDetail.setWagonDetail_Pk(wagonDetailPk);
                isAdded2 = wagonDetailRepository.save(wagonDetail);
            }
            
            if (isAdded1 && isAdded2) {
                
                session.getTransaction().commit();
                return true;
                
            } else {
                session.getTransaction().rollback();
                return false;
            }
            
        }
    }
    
    @Override
    public List<ViewWagonDto> ViewAllWagons() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            viewWagonRepository.setSessionS(session);
            session.beginTransaction();

            //List<ViewWagonEntity> wagonEntity = viewWagonRepository.ViewAllWagons();
            List< Object[]> wagonEntity = viewWagonRepository.ViewAllWagons();
            // Object[] wagonEntity = viewWagonRepository.ViewAllWagons();

            session.getTransaction().commit();
            if (wagonEntity != null) {
                List<ViewWagonDto> alWagons = new ArrayList<>();
                ViewWagonDto dto = null;
                for (Object[] w : wagonEntity) {
                    dto = new ViewWagonDto();
                    System.out.println("rrrrrrrrrr" + (String) w[1]);
                    dto.setClassType((String) w[1]);
                    dto.setSheetQty((int) w[2]);
                    dto.setTrainId((String) w[3]);
                    dto.setWagonId((String) w[0]);
                    alWagons.add(dto);
                }
                return alWagons;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public boolean deleteWagon(String wagonId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            wagonRepository.setSession(session);
            session.beginTransaction();
            WagonEntity wagon = wagonRepository.findById(wagonId);
            boolean result = false;
            System.out.println("tttt+wagon"+wagon);
            if (wagon != null) {
                
                wagonRepository.delete(wagon);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateWagon(WagonDto wagon) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            wagonRepository.setSession(session);
            session.beginTransaction();
            WagonEntity wagonEntity = new WagonEntity();
            wagonEntity.setClassType(wagon.getClassType());
            wagonEntity.setSheetQuantity(wagon.getSheetQuantity());
            wagonEntity.setWagonId(wagon.getWagonId());
            wagonRepository.update(wagonEntity);
            session.getTransaction().commit();
            
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<ViewWagonDto> searchWagon(String wagon) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            viewWagonRepository.setSessionS(session);
            session.beginTransaction();
            List< Object[]> wagonEntity = viewWagonRepository.searchWagons(wagon);
            session.getTransaction().commit();
            if (wagonEntity != null) {
                List<ViewWagonDto> alWagons = new ArrayList<>();
                ViewWagonDto dto = null;
                for (Object[] w : wagonEntity) {
                    dto = new ViewWagonDto();
                    dto.setClassType((String) w[1]);
                    dto.setSheetQty((int) w[2]);
                    dto.setTrainId((String) w[3]);
                    dto.setWagonId((String) w[0]);
                    alWagons.add(dto);
                }
                return alWagons;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public List<WagonDto> getWagon(Object[] ob) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            wagonRepository.setSessions(session);
            session.beginTransaction();
            List< Object[]> wagonEntity = wagonRepository.getWagon(ob);
            session.getTransaction().commit();
            if (wagonEntity != null) {
                List<WagonDto> alWagons = new ArrayList<>();
                WagonDto dto = null;
                for (Object[] w : wagonEntity) {
                    dto = new WagonDto();
                    dto.setClassType((String) w[1]);
                    dto.setSheetQuantity((int) w[2]);
                    dto.setWagonId((String) w[0]);
                    alWagons.add(dto);
                }
                return alWagons;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public WagonDto searchWagons(String w) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            wagonRepository.setSession(session);
            session.beginTransaction();
            System.out.println("666666666666"+w);
           
            WagonEntity we = wagonRepository.findById(w);
            System.out.println("wewewewewewe"+we);
            session.getTransaction().commit();
            if (we != null) {
                
                WagonDto dto = new WagonDto();
                dto.setClassType(we.getClassType());
                dto.setSheetQuantity(we.getSheetQuantity());
                dto.setWagonId(we.getWagonId());
                return dto;
            } else {
                return null;
            }
        }
    }
    
}
