/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoAsesorFacadeLocal;
import DAO.ProyectoCodirectorFacadeLocal;
import DAO.ProyectoDirectorFacadeLocal;
import DAO.TribunalFacadeLocal;
import entidad.Aceptacion;
import entidad.ProyectoTribunal;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.Tribunal;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jorge
 */
@Stateless
public class TribunalRN implements TribunalRNLocal {

    @EJB
    private TribunalFacadeLocal tribunalFacadeLocal;
    @EJB
    private ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal;

    @EJB
    private ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal;

    @EJB
    private ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal;
    @EJB
    private ProyectoTribunalRNLocal proy_tribunalRNbeanLocal;
     @EJB
    private TribunalRNLocal tribunalRNbeanLocal;
    
    private ProyectoTribunal proy_tribunal;

    private List<ProyectoAsesor> proyAsesor;
    private ProyectoAsesor proyAsesorActivo;
    private List<ProyectoCodirector> proyCodirector;
    private ProyectoCodirector proyCodirectorActivo;

    public ProyectoTribunal getProy_tribunal() {
        return proy_tribunal;
    }

    public void setProy_tribunal(ProyectoTribunal proy_tribunal) {
        this.proy_tribunal = proy_tribunal;
    }

    @Override
    public void create(Tribunal tribunal, Proyecto proyecto) throws Exception {
        this.validar(tribunal,proyecto,1);
        this.tribunalFacadeLocal.create(tribunal);
    }

    @Override
    public void remove(Tribunal tribunal) throws Exception {
        this.tribunalFacadeLocal.remove(tribunal);
    }

    @Override
    public void edit(Tribunal tribunal) throws Exception {
        this.tribunalFacadeLocal.edit(tribunal);
    }

    @Override
    public List<Tribunal> findAll() throws Exception {
        return (this.tribunalFacadeLocal.findAll());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Tribunal findByTribunal(String resolucion, long pre, long voc1, long voc2, long sup1, long sup2) throws Exception {
        return tribunalFacadeLocal.findByTribunal(resolucion, pre, voc1, voc2, sup1, sup2);
    }

    @Override
    public ProyectoTribunal findByProy_Tribunal(Proyecto pro, boolean active) throws Exception {
        return tribunalFacadeLocal.findByProyTribunal(pro, active);

    }

    private void validar(Tribunal t, Proyecto p, int op) throws Exception {
    //verifica si el código es menor o igual a cero

        //verifica si es una línea en blanco
        if (t.getPresidente() == null) {
            throw new Exception("El campo presidente no puede estar vacío");
        }
        if (t.getSuplente1() == null) {
            throw new Exception("El campo suplente 1 no puede estar vacío");
        }
        if (t.getSuplente2() == null) {
            throw new Exception("El campo suplente 2 no puede estar vacío");
        }
        if (t.getVocal1() == null) {
            throw new Exception("El campo vocal 1 no puede estar vacío");
        }
        if (t.getVocal2() == null) {
            throw new Exception("El campo vocal 2 no puede estar vacío");
        }

        if (t.getFecha() == null) {
            throw new Exception("El campo fecha no puede estar vacío");
        }

        if (t.getResolucion() == null) {
            throw new Exception("El campo resolucion no puede estar vacío");
        }

        //verificando docentes duplicados  
        System.out.println(":::::::::::::::::" + t.getPresidente() + t.getVocal1() + t.getVocal2() + t.getSuplente1() + t.getSuplente2());

        if (t.getVocal1().equals(t.getPresidente())) {
            throw new Exception("El docente seleccionado en Vocal 1 ya esta siendo usado");
        }

        if (t.getVocal2().equals(t.getPresidente())
                || t.getVocal2().equals(t.getVocal1())) {
            throw new Exception("El docente seleccionado en Vocal 2 ya esta siendo usado");
        }

        if (t.getSuplente1().equals(t.getPresidente())
                || t.getSuplente1().equals(t.getVocal1())
                || t.getSuplente1().equals(t.getVocal2())) {
            throw new Exception("El docente seleccionado en Suplente 1 ya esta siendo usado");
        }

        if (t.getSuplente2().equals(t.getPresidente())
                || t.getSuplente2().equals(t.getSuplente1())
                || t.getSuplente2().equals(t.getVocal1())
                || t.getSuplente2().equals(t.getVocal2())) {
            throw new Exception("El docente seleccionado en Suplente 2 ya esta siendo usado");
        }

        /*------------------------------------------------------------------------
         Verifica que en el tribunal propuesto no se elija al director del proyecto
         ---------------------------------------------------------------------------*/
          this.setProy_tribunal(tribunalRNbeanLocal.findByProy_Tribunal(p, true));
            System.out.println("aaaaaaaaaaaaabbbbbbbbbbbbbbaccccccccc" + proy_tribunal);
        System.out.println("-------------------------------------------" + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId());
        if (proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId().equals(t.getPresidente())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId().equals(t.getVocal1())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId().equals(t.getVocal2())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId().equals(t.getSuplente1())
                || proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getId().equals(t.getSuplente2())) {

            throw new Exception("El docente " + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getNombre() + ", "
                    + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(p, true).getDocente().getApellido()
                    + " no puede ser seleccionado ya que es el director del proyecto");
        }

        proyAsesor = proyectoAsesorDAOfacadeLocal.findByProyAsesor(p, true);
        proyCodirector = proyectoCodirectorDAOfacadeLocal.findCodirectorActivo(p, true);

        //recorre el list de los asesores afectados en el proyecto
        Iterator<ProyectoAsesor> as = proyAsesor.iterator();

        while (as.hasNext()) {
            proyAsesorActivo = as.next();
            System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo.getProfesional().getId());
            if (proyAsesorActivo.getProfesional().getId().equals(t.getPresidente())
                    || proyAsesorActivo.getProfesional().getId().equals(t.getVocal1())
                    || proyAsesorActivo.getProfesional().getId().equals(t.getVocal2())
                    || proyAsesorActivo.getProfesional().getId().equals(t.getSuplente1())
                    || proyAsesorActivo.getProfesional().getId().equals(t.getSuplente2())) {

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
            if (proyCodirectorActivo.getProfesional().getId().equals(t.getPresidente())
                    || proyCodirectorActivo.getProfesional().getId().equals(t.getVocal1())
                    || proyCodirectorActivo.getProfesional().getId().equals(t.getVocal2())
                    || proyCodirectorActivo.getProfesional().getId().equals(t.getSuplente1())
                    || proyCodirectorActivo.getProfesional().getId().equals(t.getSuplente2())) {

                throw new Exception("El docente " + proyCodirectorActivo.getProfesional().getApellido() + ", "
                        + proyCodirectorActivo.getProfesional().getNombre()
                        + " no puede ser seleccionado ya que es codirector del proyecto");
            }
        }
    }

    @Override
    public List<Tribunal> findTribunalByDocente(long idDoc) throws Exception {
       return (tribunalFacadeLocal.findTribunalByDocente(idDoc));
    }

    @Override
    public Tribunal findTribunal(Proyecto pro, boolean active) throws Exception {
       return (tribunalFacadeLocal.findTribunal(pro, active));
    }
}
