/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.CronogramaActividadFacadeLocal;
import entidad.Cronograma;
import entidad.CronogramaActividad;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author Trossero
 */
@Stateless
public class CronogramaActividadRN implements CronogramaActividadRNLocal {

    @EJB
    private CronogramaActividadFacadeLocal cronograma_actFacadeLocal;
    
    @Override
    public void create(CronogramaActividad c) throws Exception {
        this.cronograma_actFacadeLocal.create(c);
    }

    @Override
    public void remove(CronogramaActividad c) throws Exception {
        this.cronograma_actFacadeLocal.remove(c);
    }

    @Override
    public void edit(CronogramaActividad c) throws Exception {
         this.convertir_strings(c);
        this.validar(c, 0);
        this.cronograma_actFacadeLocal.edit(c);
    }

    @Override
    public List<CronogramaActividad> findAll() throws Exception {
        return (this.cronograma_actFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<CronogramaActividad> findByCronogramaActividad(Cronograma cro) throws Exception {
      return (this.cronograma_actFacadeLocal.findByCronogramaActividad(cro));
    }

    @Override
    public CronogramaActividad findByCronograma(long longid) throws Exception {
       return cronograma_actFacadeLocal.findByCronograma(longid);
    }
    
      private void validar(CronogramaActividad p, int op) throws Exception {
        //verifica si el código es menor o igual a cero
       

        //verifica si es una línea en blanco
        if (p.getDescripcion_act().trim().length() == 0) {
            throw new Exception("El nombre de la actividad no puede estar vacio");
        }
        if (p.getNumero()  ==  null ) {
            throw new Exception("El numero de actividad no puede estar vacio");
        }
         
       /*if (paisDAOFacadeLocal.bFindByNombrePais(p, op)) {
         throw new Exception("Ya existe un país con ese nombre");
         }//fin if
         */
    }//fin validar

    private void convertir_strings(CronogramaActividad p) {
        p.setDescripcion_act(cadenas.convertir(p.getDescripcion_act()));
       

    }

    @Override
    public List<CronogramaActividad> findByFueraDeFecha() throws Exception {
      return cronograma_actFacadeLocal.findByFueraDeFecha();
    }
}
