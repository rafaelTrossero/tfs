/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.PresentacionFacadeLocal;
import entidad.Presentacion;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class PresentacionRN implements PresentacionRNLocal {

    @EJB
    private PresentacionFacadeLocal presentacionFacadeLocal;

    @Override
    public void create(Presentacion p) throws Exception {
       
            this.validar(p,0);
    
        this.presentacionFacadeLocal.create(p);
    }

    @Override
    public void remove(Presentacion p) {
        this.presentacionFacadeLocal.remove(p);
    }

    @Override
    public void edit(Presentacion p) {
        this.presentacionFacadeLocal.edit(p);
    }

    @Override
    public List<Presentacion> findAll() throws Exception {
        return (this.presentacionFacadeLocal.findAll());
    }

    @Override
    public List<Presentacion> findPresentacion(Proyecto pro, String cert, String nota, String notadir) throws Exception {
        return presentacionFacadeLocal.findPresentacion(pro, cert, nota, notadir);
    }

    @Override
    public Long findPresCodigo(Proyecto proy, boolean requisito) throws Exception {
        return presentacionFacadeLocal.findPresCodigo(proy, requisito);
    }

    @Override
    public Presentacion findByPresentacion(Long codigo) throws Exception {
        return presentacionFacadeLocal.findByPresentacion(codigo);
    }

      private void validar(Presentacion p, int op) throws Exception {
        
          System.out.println("ENTRO AL VALIDAR DE PRESENTACION BEAN ___________________->>"+ p.getFecha());
          
    //verifica si es una línea en blanco
    if (p.getFecha()== null) {
        System.out.println("SUPUESTAMENTE TIENE QUE ENTRAR ACAAAA ...........------->>>>>>>");
        throw new Exception("Debe seleccionar una fecha");
    }


  }//fin validar */
}
