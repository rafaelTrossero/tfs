/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Noticias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface NoticiasFacadeLocal {

    void create(Noticias noticias);

    void edit(Noticias noticias);

    void remove(Noticias noticias);

    Noticias find(Object id);

    List<Noticias> findAll();

    List<Noticias> findRange(int[] range);

    int count();
    
    List<Noticias> findUltimaNoticia ();
    
    
}
