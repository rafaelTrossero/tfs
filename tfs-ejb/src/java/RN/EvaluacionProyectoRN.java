/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.EvaluacionProyectoFacadeLocal;
import DAO.ProyectoAsesorFacadeLocal;
import DAO.ProyectoCodirectorFacadeLocal;
import DAO.ProyectoDirectorFacadeLocal;
import entidad.Aceptacion;
import entidad.Docente;
import entidad.EvaluacionProyecto;
import entidad.Presentacion;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;

/**
 *
 * @author cristian
 */
@Stateless
public class EvaluacionProyectoRN implements EvaluacionProyectoRNLocal {

    @EJB
    private EvaluacionProyectoFacadeLocal evaluacion_ProyectoFacadeLocal;
    @EJB
    private ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal;
    @EJB
    private ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal;

    @EJB
    private ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal;

    private List<ProyectoAsesor> proyAsesor;
    private ProyectoAsesor proyAsesorActivo;
    private List<ProyectoCodirector> proyCodirector;
    private ProyectoCodirector proyCodirectorActivo;

    @Override
    public void create(EvaluacionProyecto p) throws Exception {

        this.validar(p, 1);
        this.evaluacion_ProyectoFacadeLocal.create(p);
    }

    @Override
    public void remove(EvaluacionProyecto p) throws Exception {
        this.evaluacion_ProyectoFacadeLocal.remove(p);
    }

    @Override
    public void edit(EvaluacionProyecto p) throws Exception {
        this.evaluacion_ProyectoFacadeLocal.edit(p);
    }

    @Override
    public List<EvaluacionProyecto> findAll() throws Exception {
        return (this.evaluacion_ProyectoFacadeLocal.findAll());

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public EvaluacionProyecto findByEvaluacionl(Proyecto pro, Presentacion pres) throws Exception {
        return this.evaluacion_ProyectoFacadeLocal.findByEvaluacion(pro, pres);
    }
     @Override
    public List<EvaluacionProyecto> findByEvaluacion(Proyecto pro) throws Exception {
        return this.evaluacion_ProyectoFacadeLocal.findByEvaluacionByProyecto(pro);
    }

    private void validar(EvaluacionProyecto a, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        System.out.println(",...........,.............,.ENTRO AL VALIDAR ..........................,,. " );
        //verifica si es una línea en blanco
        if(a.getCalificacion().getId().equals(1L) || a.getCalificacion().getId().equals(2L) ){
        if (a.getPresidente() == null) {
            throw new Exception("El campo presidente no puede estar vacío");
        }

        if (a.getVocal1() == null) {
            throw new Exception("El campo vocal 1 no puede estar vacío");
        }
        if (a.getVocal2() == null) {
            throw new Exception("El campo vocal 2 no puede estar vacío");
        }
        }
        if (a.getFecha() == null) {
            throw new Exception("El campo fecha no puede estar vacío");
        }

        if (a.getCalificacion() == null) {
            throw new Exception("El campo calificación no puede estar vacío");
        }

        //verificando docentes duplicados  
        System.out.println(":::::::::::::::::" + a.getPresidente() + a.getVocal1() + a.getVocal2());
 if(a.getCalificacion().getId().equals(1L) || a.getCalificacion().getId().equals(2L) ){
        if (a.getVocal1().equals(a.getPresidente())) {
            throw new Exception("El docente seleccionado en Vocal 1 ya esta siendo usado");
        }

        if (a.getVocal2().equals(a.getPresidente())
                || a.getVocal2().equals(a.getVocal1())) {
            throw new Exception("El docente seleccionado en Vocal 2 ya esta siendo usado");
        }
        }
        /*------------------------------------------------------------------------
         Verifica que en el tribunal propuesto no se elija al director del proyecto
         ---------------------------------------------------------------------------*/
        if(a.getCalificacion().getId().equals(1L) || a.getCalificacion().getId().equals(2L) ){
        System.out.println("-------------------------------------------" + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId());
        if (proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId().equals(a.getPresidente())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId().equals(a.getVocal1())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId().equals(a.getVocal2())) {

            throw new Exception("El docente " + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getNombre() + ", "
                    + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getApellido()
                    + " no puede ser seleccionado ya que es el director del proyecto");
        }

        proyAsesor = proyectoAsesorDAOfacadeLocal.findByProyAsesor(a.getProyecto(), true);
        proyCodirector = proyectoCodirectorDAOfacadeLocal.findCodirectorActivo(a.getProyecto(), true);

        //recorre el list de los asesores afectados en el proyecto
        Iterator<ProyectoAsesor> as = proyAsesor.iterator();

        while (as.hasNext()) {
            proyAsesorActivo = as.next();
            System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo.getProfesional().getId());
            if (proyAsesorActivo.getProfesional().getId().equals(a.getPresidente())
                    || proyAsesorActivo.getProfesional().getId().equals(a.getVocal1())
                    || proyAsesorActivo.getProfesional().getId().equals(a.getVocal2())) {

                throw new Exception("El docente " + proyAsesorActivo.getProfesional().getApellido() + ", "
                        + proyAsesorActivo.getProfesional().getNombre()
                        + " no puede ser seleccionado ya que es asesor del proyecto");
            }

        }

        //recorre el list de los codirectores afectados en el proyecto
        Iterator<ProyectoCodirector> cod = proyCodirector.iterator();

        while (cod.hasNext()) {
            proyCodirectorActivo = cod.next();
            System.out.println("uuuuuuuuuuuuuuuuCODIRECTORuuuuuuuuuuuuuuuu" + proyCodirectorActivo.getProfesional().getId());
            if (proyCodirectorActivo.getProfesional().getId().equals(a.getPresidente())
                    || proyCodirectorActivo.getProfesional().getId().equals(a.getVocal1())
                    || proyCodirectorActivo.getProfesional().getId().equals(a.getVocal2())) {

                throw new Exception("El docente " + proyCodirectorActivo.getProfesional().getApellido() + ", "
                        + proyCodirectorActivo.getProfesional().getNombre()
                        + " no puede ser seleccionado ya que es codirector del proyecto");
            }
        }
        }
    }//fin val

    @Override
    public List<EvaluacionProyecto> findByEvaluacionByProyecto(Proyecto pro) throws Exception {
       return this.evaluacion_ProyectoFacadeLocal.findByEvaluacionByProyecto(pro);
    }

    @Override
    public EvaluacionProyecto findByProyectoYcalif(Proyecto pro, Integer cal) throws Exception {
       return this.evaluacion_ProyectoFacadeLocal.findByProyectoYcalif(pro, cal);
    }

}
