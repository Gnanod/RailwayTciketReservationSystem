/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.PriceBO;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.entity.PriceEntity;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.PricesRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class PriceBOImpl implements PriceBO {
    
    private PricesRepository priceRepository;
    
    public PriceBOImpl() {
        priceRepository = (PricesRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PRICE);
        System.out.println("PriceBOImpl");
    }
    
    @Override
    public boolean addPrice(PricaeDto priceD) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            priceRepository.setSession(session);
            System.out.println("PriceAdd");
            session.beginTransaction();
            PriceEntity p = new PriceEntity();
            p.setAmount(priceD.getAmount());
            p.setClassType(priceD.getClassType());
            p.setStartStation(priceD.getStartStation());
            p.setEndStation(priceD.getEndStation());
            p.setTrainType(priceD.getTrainType());
            boolean result = priceRepository.save(p);
            session.getTransaction().commit();
            return result;
        }
    }
    
    @Override
    public List<PricaeDto> getAllPrices() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            priceRepository.setSession(session);
            session.beginTransaction();
            List<PriceEntity> priceEntity = priceRepository.findAll();
            session.getTransaction().commit();
            if (priceEntity != null) {
                List<PricaeDto> alPrices = new ArrayList<>();
                PricaeDto dto = null;
                for (PriceEntity t : priceEntity) {
                    dto = new PricaeDto();
                    dto.setAmount(t.getAmount());
                    dto.setClassType(t.getClassType());
                    dto.setStartStation(t.getStartStation());
                    dto.setEndStation(t.getEndStation());
                    dto.setPriceId(t.getPriceId());
                    dto.setTrainType(t.getTrainType());
                    alPrices.add(dto);
                }
                return alPrices;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public boolean deletePrices(String deletePrice) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            priceRepository.setSession(session);
            session.beginTransaction();
            PriceEntity price = priceRepository.findById(Integer.parseInt(deletePrice));
            boolean result = false;
            if (price != null) {
                priceRepository.delete(price);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updatePrice(PricaeDto priceD) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            priceRepository.setSession(session);
            session.beginTransaction();
            PriceEntity p = new PriceEntity();
            p.setAmount(priceD.getAmount());
            p.setClassType(priceD.getClassType());
            p.setStartStation(priceD.getStartStation());
            p.setEndStation(priceD.getEndStation());
            
            p.setTrainType(priceD.getTrainType());
            p.setPriceId(priceD.getPriceId());
            priceRepository.update(p);
            session.getTransaction().commit();
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public PricaeDto searchPrice(Object[] search) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            priceRepository.setSessionss(session);
            session.beginTransaction();
            
            List< Object[]> price = priceRepository.searchPrice(search);
            
            session.getTransaction().commit();
            if (price != null) {
                PricaeDto dto = null;
                for (Object[] w : price) {
                    dto = new PricaeDto();
                    dto.setClassType((String) w[0]);
                    dto.setAmount((double) w[1]);
                }
                return dto;
            } else {
                return null;
            }
        }
    }
    
}
