/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Catedra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface CatedraRNLocal {
       void create(Catedra c) throws Exception;

    void remove(Catedra c) throws Exception;

    void edit(Catedra c) throws Exception;

    List<Catedra> findAll() throws Exception;
    
    public void activate(Catedra c, Boolean bEstado) throws Exception;
    
    List<Catedra> findAllActivo() throws Exception;
    List<Catedra> findAllcatedra(Long id) throws Exception;
    List<Catedra> findAllcatedraLIKE(String a) throws Exception;
    List<Catedra> finCatedraCuro(String curso) throws Exception;
   
}
