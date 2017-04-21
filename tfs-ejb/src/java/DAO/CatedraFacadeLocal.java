/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Catedra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface CatedraFacadeLocal {

    void create(Catedra catedra);

    void edit(Catedra catedra);

    void remove(Catedra catedra);

    Catedra find(Object id);

    List<Catedra> findAll();

    List<Catedra> findRange(int[] range);

    int count();
    
    public void activate(Catedra c, Boolean bEstado) throws Exception;
     public Boolean findByCarrearaName(Catedra cat, int op) throws Exception;
     public Catedra findByNombreCarreraID (Long id, String nombre)throws Exception;
     
     List<Catedra> findAllActivo();
      public  List<Catedra> findAllCarrera (Long id)throws Exception;
      
         public  List<Catedra> findCatedraCuro (String curso)throws Exception;
         
         List<Catedra> findAllcatedraLIKE(String a) throws Exception;
}
