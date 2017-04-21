/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import entidad.Noticias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface NoticiasRNLocal {
    
     void create(Noticias n) throws Exception;

    void remove(Noticias n) throws Exception;

    void edit(Noticias n) throws Exception;

    List<Noticias> findAll() throws Exception;
    
     public void activate(Noticias n, Boolean bEstado) throws Exception;
      List<Noticias> findAllActivo() throws Exception;
    
      List<Noticias> findUltimaNoticia ();
}
