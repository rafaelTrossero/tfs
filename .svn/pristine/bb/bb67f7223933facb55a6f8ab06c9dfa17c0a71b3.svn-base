/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.NoticiasFacadeLocal;
import entidad.Noticias;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class NoticiasRN implements NoticiasRNLocal {
    
    @EJB
    private NoticiasFacadeLocal noticiasFacadeLocal;
    

    @Override
    public void create(Noticias n) throws Exception {
        noticiasFacadeLocal.create(n);
    }

    @Override
    public void remove(Noticias n) throws Exception {
        noticiasFacadeLocal.remove(n);
    }

    @Override
    public void edit(Noticias n) throws Exception {
        noticiasFacadeLocal.edit(n);
    }

    @Override
    public List<Noticias> findAll() throws Exception {
        return (noticiasFacadeLocal.findAll());
    }

    @Override
    public void activate(Noticias n, Boolean bEstado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticias> findAllActivo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticias> findUltimaNoticia() {
       return (noticiasFacadeLocal.findUltimaNoticia());
    }

 

    
}
