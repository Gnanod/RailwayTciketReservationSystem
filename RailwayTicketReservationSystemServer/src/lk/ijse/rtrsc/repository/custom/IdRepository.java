/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom;

import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public interface IdRepository extends SuperRepository<Object, String>{

    public Object getResult(IdDto idDTO)throws Exception;

    public void setSessions(Session session)throws Exception;
    
}
