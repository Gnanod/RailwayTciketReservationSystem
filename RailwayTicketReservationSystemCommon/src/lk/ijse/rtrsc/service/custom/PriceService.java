/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import java.util.List;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface PriceService extends SuperService{

    public boolean addPrice(PricaeDto priceD)throws Exception;

    public List<PricaeDto> getAllPrices()throws Exception;

    public boolean deletePrices(String deletePrice)throws Exception;

    public boolean updatePrice(PricaeDto priceD)throws Exception;

    public PricaeDto searchPrice(Object[] search)throws Exception;

    
}
