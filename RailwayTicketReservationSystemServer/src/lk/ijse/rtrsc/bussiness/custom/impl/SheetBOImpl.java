/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.SheetBO;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.entity.StationEntity;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.SheetRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class SheetBOImpl implements SheetBO {

    private SheetRepository sheetRepository;

    public SheetBOImpl() {
        sheetRepository = (SheetRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SHEET);
    }

    @Override
    public boolean saveSheet(SheetDto dto) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSession(session);
            session.beginTransaction();
            SheetEntity sheetEntity = new SheetEntity();
            sheetEntity.setSheetType(dto.getSheetType());
            WagonDto wagon = dto.getWagonDto();
            WagonEntity entity = new WagonEntity();
            entity.setWagonId(wagon.getWagonId());
            SheetDto sheet = new SheetDto();
            sheet.setWagonDto(wagon);

            sheetEntity.setStatus(dto.getStatus());

            sheetEntity.setWagonEntity(entity);

            boolean result = sheetRepository.save(sheetEntity);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<SheetDto> getAllSheets() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSession(session);
            session.beginTransaction();
            List<SheetEntity> sheetEntity = sheetRepository.findAll();
            session.getTransaction().commit();
            if (sheetEntity != null) {
                List<SheetDto> alSheets = new ArrayList<>();
                SheetDto dto = null;
                for (SheetEntity s : sheetEntity) {
                    dto = new SheetDto();
                    dto.setSheetID(s.getSheetID());
                    dto.setSheetType(s.getSheetType());
                    dto.setStatus(s.getStatus());
                    WagonEntity w = s.getWagonEntity();
                    WagonDto wd = new WagonDto();
                    wd.setWagonId(w.getWagonId());
                    dto.setWagonDto(wd);
                    alSheets.add(dto);
                }
                return alSheets;
            } else {
                return null;
            }
        }
    }

    @Override
    public List<SheetDto> getAllTrainSheets(Object[] ob) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSessions(session);
            session.beginTransaction();
            List< Object[]> sheets = sheetRepository.getAllTrainSheets(ob);

            session.getTransaction().commit();
            List<SheetDto> list = new ArrayList<>();
            if (sheets != null) {
                SheetDto dto = null;
                for (Object[] w : sheets) {
                    dto = new SheetDto();
                    dto.setSheetType((String) w[0]);
                    dto.setStatus((String) w[1]);

                    WagonDto wd = new WagonDto();
                    wd.setWagonId((String) w[2]);
                    dto.setWagonDto(wd);
                    dto.setSheetID((int) w[3]);
                    System.out.println("wwwwwwwwww" + (int) w[3]);
                    list.add(dto);
                }
                return list;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean updateSheet(SheetDto dto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSession(session);
            session.beginTransaction();
            SheetEntity sheetEntity = new SheetEntity();
            sheetEntity.setSheetType(dto.getSheetType());
            WagonDto wagon = dto.getWagonDto();
            WagonEntity entity = new WagonEntity();
            entity.setWagonId(wagon.getWagonId());
            SheetDto sheet = new SheetDto();
            sheet.setWagonDto(wagon);
            sheetEntity.setStatus(dto.getStatus());
            sheetEntity.setSheetID(dto.getSheetID());
            sheetEntity.setWagonEntity(entity);
            sheetRepository.update(sheetEntity);
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SheetDto> getAllSeatsInDate(Object[] o) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSessions(session);
            session.beginTransaction();
            // int ob = sheetRepository.getAllCount(o);
            // if (ob != 0) {
            List< Object[]> sheets = sheetRepository.getAllSeatsInDate(o);
            System.out.println("ttttttttt" + sheets);
            session.getTransaction().commit();
            List<SheetDto> list = new ArrayList<>();
            if (sheets != null) {
                SheetDto dto = null;
                for (Object[] w : sheets) {
                    dto = new SheetDto();
                    dto.setSheetType((String) w[1]);
                    dto.setSheetID((int) w[0]);

                    list.add(dto);
                }
                return list;
            } else {
                return null;
            }
            // }

            // return null;
        }
    }

    @Override
    public int getCountAllCount(Object[] all) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            sheetRepository.setSessions(session);
            session.beginTransaction();

            int sheets = sheetRepository.getAllCount(all);
            
            //session.getTransaction().commit();
            return sheets;
            
           
            // }
            // return null;
        }
    }
}
