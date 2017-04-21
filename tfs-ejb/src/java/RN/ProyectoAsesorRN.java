/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProyectoAsesorFacadeLocal;
import DAO.ProyectoCodirectorFacadeLocal;
import DAO.ProyectoDirectorFacadeLocal;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class ProyectoAsesorRN implements ProyectoAsesorRNLocal {

    @EJB
    private ProyectoDirectorFacadeLocal proyectoDirectorDAOfacadeLocal;

    @EJB
    private ProyectoCodirectorFacadeLocal proyectoCodirectorDAOfacadeLocal;

    @EJB
    private ProyectoAsesorFacadeLocal proyectoAsesorDAOfacadeLocal;

    private List<ProyectoAsesor> proyAsesor;
    private ProyectoDirector proyDirectorActivo;
    private ProyectoAsesor proyAsesorActivo;
    private List<ProyectoCodirector> proyCodirector;
    private ProyectoCodirector proyCodirectorActivo;

    @EJB
    private ProyectoAsesorFacadeLocal proy_ascesorFacadeLocal;

    @Override
    public void create(ProyectoAsesor alu) throws Exception {
        this.validar(alu, 1);
        this.proy_ascesorFacadeLocal.create(alu);
    }

    @Override
    public void remove(ProyectoAsesor alu) throws Exception {
        this.proy_ascesorFacadeLocal.remove(alu);
    }

    @Override
    public void edit(ProyectoAsesor alu) throws Exception {
        this.revalidar(alu, 1);
        this.proy_ascesorFacadeLocal.edit(alu);

    }

    @Override
    public List<ProyectoAsesor> findAll() throws Exception {

        return (this.proy_ascesorFacadeLocal.findAll());
    }

    @Override
    public List<ProyectoAsesor> findByProyAsesor(Proyecto pro, boolean active) throws Exception {
        return (this.proy_ascesorFacadeLocal.findByProyAsesor(pro, active));
    }

    public ProyectoDirector getProyDirectorActivo() {
        return proyDirectorActivo;
    }

    public void setProyDirectorActivo(ProyectoDirector proyDirectorActivo) {
        this.proyDirectorActivo = proyDirectorActivo;
    }

    private void validar(ProyectoAsesor a, int op) throws Exception {
        //verifica si el código es menor o igual a cero

        /*------------------------------------------------------------------------
         verifica que los asesores seleccionados no sean directores ni codirectores
         ---------------------------------------------------------------------------
        if (a.getProfesional() == null) {
            throw new Exception("se debe seleccionar al menos un profesional");
        }*/
        
        proyAsesor = proyectoAsesorDAOfacadeLocal.findByProyAsesor(a.getProyecto(), true);
        proyCodirector = proyectoCodirectorDAOfacadeLocal.findCodirectorActivo(a.getProyecto(), true);
        proyDirectorActivo = proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true);
       // System.out.println("-------------------------------------------" + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getId());
        
        if (proyDirectorActivo != null) {
            if (proyDirectorActivo.getDocente().getId().equals(a.getProfesional().getId())) {

                throw new Exception("El docente " + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getNombre() + ", "
                        + proyectoDirectorDAOfacadeLocal.findProyDirectorActivo(a.getProyecto(), true).getDocente().getApellido()
                        + " no puede ser seleccionado ya que es el director del proyecto");
            }
            
            
        }

        
        if(proyAsesor != null){

        //recorre el list de los asesores afectados en el proyecto
        Iterator<ProyectoAsesor> as = proyAsesor.iterator();

        while (as.hasNext()) {
            proyAsesorActivo = as.next();
            System.out.println("uuuuuuuuuuuuuuuuASESORuuuuuuuuuuuuuuuu" + proyAsesorActivo.getProfesional().getId());
            if (proyAsesorActivo.getProfesional().getId().equals(a.getProfesional().getId()) ) {

                throw new Exception("El docente " + proyAsesorActivo.getProfesional().getApellido() + ", "
                        + proyAsesorActivo.getProfesional().getNombre()
                        + " ya es asesor del proyecto");
            }

        }
       }   
        //recorre el list de los codirectores afectados en el proyecto
        if(proyCodirector != null){
        Iterator<ProyectoCodirector> cod = proyCodirector.iterator();

        while (cod.hasNext()) {
            proyCodirectorActivo = cod.next();
            System.out.println("uuuuuuuuuuuuuuuuCODIRECTORuuuuuuuuuuuuuuuu" + proyCodirectorActivo.getProfesional().getId());
            if (proyCodirectorActivo.getProfesional().getId().equals(a.getProfesional().getId())) {

                throw new Exception("El docente " + proyCodirectorActivo.getProfesional().getApellido() + ", "
                        + proyCodirectorActivo.getProfesional().getNombre()
                        + " no puede ser seleccionado ya que es codirector del proyecto");
            }
        }
        }
    }//fin validar

    private void revalidar(ProyectoAsesor alu, int i) throws Exception {
        if (alu.getProfesional() == null) {
            throw new Exception("se debe seleccionar al menos un profesional");
        }
    }

    @Override
    public List<ProyectoAsesor> findByProyectoAsesor(long doc) throws Exception {
                  return (this.proy_ascesorFacadeLocal.findByProyectoAsesor(doc));
    }

    @Override
    public List<ProyectoAsesor> findProyByDocenteAsesor(long docente) throws Exception {
    return (this.proy_ascesorFacadeLocal.findProyAsesor(docente));
    
    }

   
}
