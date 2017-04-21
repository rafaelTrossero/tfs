/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RN;

import DAO.BorradorEvaluacionFacadeLocal;
import entidad.BorradorEvaluacion;
import entidad.EvaluacionProyecto;
import entidad.Proyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Trossero
 */
@Stateless
public class BorradorEvaluacionRN implements BorradorEvaluacionRNLocal {
    
    @EJB
    private BorradorEvaluacionFacadeLocal brr_evaluacionFacadeLocal;
    
    @Override
    public void create(BorradorEvaluacion br) throws Exception {
         validar(br,1);
        this.brr_evaluacionFacadeLocal.create(br);
    }

    @Override
    public void remove(BorradorEvaluacion br) throws Exception {
        this.brr_evaluacionFacadeLocal.remove(br);
    }

    @Override
    public void edit(BorradorEvaluacion br) throws Exception {
        this.brr_evaluacionFacadeLocal.edit(br);
    }

    @Override
    public List<BorradorEvaluacion> findAll() throws Exception {
        return(this.brr_evaluacionFacadeLocal.findAll());
    }
    
      @Override
    public List<BorradorEvaluacion> findByEvaluacionBorrador(Proyecto pro) throws Exception {
        return this.brr_evaluacionFacadeLocal.findByEvaluacionBorrador(pro);
    }

      private void validar(BorradorEvaluacion b, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
        if (b.getPresidente() == null) {
            throw new Exception("Debe seleccionar un presidente para el tribunal");
        }
       
        if (b.getVocal1() == null) {
            throw new Exception("Debe seleccionar el vocal N°1 para el tribunal");
        }
        if (b.getVocal2() == null) {
            throw new Exception("Debe seleccionar el vocal N°2 para el tribunal");
        }

        if (b.getFecha() == null) {
            throw new Exception("El campo fecha no puede estar vacío");
        }

        if (b.getCalificacion() == null) {
            throw new Exception("El campo calificación no puede estar vacío");
        }
        
        
       
    }//fin validar

    @Override
    public BorradorEvaluacion findByProyectoYcalif(Proyecto pro, Integer cal, Long borrador) throws Exception {
        return (brr_evaluacionFacadeLocal.findByProyectoYcalif(pro, cal, borrador));
    }
}
