/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AceptacionRNLocal;
import RN.AceptacionObservacionesRNLocal;
import RN.CronogramaActividadRNLocal;
import RN.CronogramaRNLocal;
import RN.DocenteRNLocal;
import RN.GuiaEvaluacion2_1RNLocal;
import RN.GuiaEvaluacion2_1_indicadoresRNLocal;
import RN.PresentacionRNLocal;
import RN.ProfesionalRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;

import entidad.Aceptacion;
import entidad.AceptacionObservaciones;
import entidad.Calificacion;
import entidad.Cronograma;
import entidad.CronogramaActividad;
import entidad.Docente;
import entidad.Estado;
import entidad.GuiaEvaluacion2_1;
import entidad.GuiaEvaluacion2_1_indicadores;
import entidad.Presentacion;
import entidad.Profesional;
import entidad.ProyectoAlumno;
import entidad.ProyectoDirector;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import recursos.Util;

/**
 *
 * @author Cristian PC
 */
@ManagedBean
@RequestScoped
public class AceptacionBean {

    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaCronogramaBean}")
    private ListaCronogramaBean listaCronogramaBean;
    @ManagedProperty("#{navegarBean}")
    private navegarBean navegarBean;

    @ManagedProperty("#{listaCalificacionBean}")
    private ListaCalificacioBean listaCalificacionBean;
    @ManagedProperty("#{listaDocenteBean}")
    private ListaDocenteBean listaDocenteBean;

    @ManagedProperty("#{listaIndicadores21Bean}")
    private ListaIndicadores21Bean listaIndicadores21Bean;

    @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
    private Proyecto proyecto;
    private Aceptacion aceptacion;
    private Aceptacion acep;
    private List<ProyectoAlumno> lstProyAlumno;
    private List<ProyectoDirector> lstProyDirector;
    private ProyectoDirector proyDir;
    private ProyectoCodirector proyCodir;
    private ProyectoAsesor proyAs;
    private List<ProyectoCodirector> lstproyCodir;
    private List<ProyectoAsesor> lstproyAs;
    private Docente presidente;
    private Docente vocal1;
    private Docente vocal2;
    private Docente suplente1;
    private Docente suplente2;
    private List<Docente> lstDocente;
    private List<Profesional> lstProfesional;
    private List<Docente> lstDocenteParaTribunal;
    private List<SelectItem> lstSIDocenteParaTribunal;
    private AceptacionObservaciones aceptacion_observacion;
    private Estado estado;
    private List<Presentacion> lstPresentacion;
    private final boolean requisito = true;
    private Long presentacionCodigo;
    private Presentacion presentacion;
    private Cronograma cronograma;
    private CronogramaActividad cronogramaAct;
    private CronogramaActividad act;
    private GuiaEvaluacion2_1_indicadores ind;
    private GuiaEvaluacion2_1 guiaEvaluacion2_1;

    public Boolean aprobado = true;
    public Boolean checkedT = false;
    public Boolean checkedF = false;

    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    @EJB
    private ProfesionalRNLocal profesionalRNbLocal;

    @EJB
    private ProyectoAlumnoRNLocal proy_alumnoRNbeanLocal;
    @EJB
    private ProyectoDirectorRNLocal proy_directorRNbeanLocal;
    @EJB
    private ProyectoCodirectorRNLocal proy_codirectorRNLocal;
    @EJB
    private ProyectoAsesorRNLocal proy_asesorRNLocal;
    @EJB
    private AceptacionRNLocal aceptacionRNbeanLocal;
    @EJB
    private AceptacionObservacionesRNLocal aceptacion_obsRNbeanLocal;
    @EJB
    private PresentacionRNLocal presentacionRNbeanLocal;

    @EJB
    private CronogramaRNLocal cronogramaRNLocal;

    @EJB
    private DocenteRNLocal docenteRNLocal;

    @EJB
    private GuiaEvaluacion2_1_indicadoresRNLocal guiaEvaluacion2_1_indicadoresRNLocal;

    @EJB
    private GuiaEvaluacion2_1RNLocal guiaEvaluacion2_1RNLocal;

    @EJB
    private CronogramaActividadRNLocal cronogramaActividadRNLocal;

    public ListaCronogramaBean getListaCronogramaBean() {
        return listaCronogramaBean;
    }

    public void setListaCronogramaBean(ListaCronogramaBean listaCronogramaBean) {
        this.listaCronogramaBean = listaCronogramaBean;
    }

    /**
     * Creates a new instance of AceptacionBean
     */
    public AceptacionBean() {
        this.aceptacion = new Aceptacion();
        this.aceptacion_observacion = new AceptacionObservaciones();
        this.cronograma = new Cronograma();
        this.lstDocenteParaTribunal = new ArrayList<Docente>();
        this.lstDocente = new ArrayList<Docente>();
        this.lstProfesional = new ArrayList<Profesional>();
        this.lstproyAs = new ArrayList<ProyectoAsesor>();
        this.lstproyCodir = new ArrayList<ProyectoCodirector>();

    }

    public ListaCalificacioBean getListaCalificacionBean() {
        return listaCalificacionBean;
    }

    public void setListaCalificacionBean(ListaCalificacioBean listaCalificacionBean) {
        this.listaCalificacionBean = listaCalificacionBean;
    }

    public Aceptacion getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Aceptacion aceptacion) {
        this.aceptacion = aceptacion;
    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public navegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(navegarBean navegarBean) {
        this.navegarBean = navegarBean;
    }

    public List<ProyectoAlumno> getLstProyAlumno() {
        return lstProyAlumno;
    }

    public void setLstProyAlumno(List<ProyectoAlumno> lstProyAlumno) {
        this.lstProyAlumno = lstProyAlumno;
    }

    public List<ProyectoDirector> getLstProyDirector() {
        return lstProyDirector;
    }

    public void setLstProyDirector(List<ProyectoDirector> lstProyDirector) {
        this.lstProyDirector = lstProyDirector;
    }

    public Docente getPresidente() {
        return presidente;
    }

    public void setPresidente(Docente presidente) {
        this.presidente = presidente;
    }

    public Docente getVocal1() {
        return vocal1;
    }

    public void setVocal1(Docente vocal1) {
        this.vocal1 = vocal1;
    }

    public Docente getVocal2() {
        return vocal2;
    }

    public void setVocal2(Docente vocal2) {
        this.vocal2 = vocal2;
    }

    public Docente getSuplente1() {
        return suplente1;
    }

    public void setSuplente1(Docente suplente1) {
        this.suplente1 = suplente1;
    }

    public Docente getSuplente2() {
        return suplente2;
    }

    public void setSuplente2(Docente suplente2) {
        this.suplente2 = suplente2;
    }

    public Aceptacion getAcep() {
        return acep;
    }

    public void setAcep(Aceptacion acep) {
        this.acep = acep;
    }

    public AceptacionObservaciones getAceptacion_observacion() {
        return aceptacion_observacion;
    }

    public void setAceptacion_observacion(AceptacionObservaciones aceptacion_observacion) {
        this.aceptacion_observacion = aceptacion_observacion;
    }

    public List<Presentacion> getLstPresentacion() {
        return lstPresentacion;
    }

    public void setLstPresentacion(List<Presentacion> lstPresentacion) {
        this.lstPresentacion = lstPresentacion;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public CronogramaActividad getCronogramaAct() {
        return cronogramaAct;
    }

    public void setCronogramaAct(CronogramaActividad cronogramaAct) {
        this.cronogramaAct = cronogramaAct;
    }

    public CronogramaActividad getAct() {
        return act;
    }

    public void setAct(CronogramaActividad act) {
        this.act = act;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setIsAprobado(boolean isAprobado) {
        this.aprobado = isAprobado;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public ListaIndicadores21Bean getListaIndicadores21Bean() {
        return listaIndicadores21Bean;
    }

    public void setListaIndicadores21Bean(ListaIndicadores21Bean listaIndicadores21Bean) {
        this.listaIndicadores21Bean = listaIndicadores21Bean;
    }

    public Boolean getCheckedT() {
        return checkedT;
    }

    public void setCheckedT(Boolean checkedT) {
        this.checkedT = checkedT;
    }

    public Boolean getCheckedF() {
        return checkedF;
    }

    public void setCheckedF(Boolean checkedF) {
        this.checkedF = checkedF;
    }

    public ListaDocenteBean getListaDocenteBean() {
        return listaDocenteBean;
    }

    public void setListaDocenteBean(ListaDocenteBean listaDocenteBean) {
        this.listaDocenteBean = listaDocenteBean;
    }

    public List<Docente> getLstDocente() {
        return lstDocente;
    }

    public void setLstDocente(List<Docente> lstDocente) {
        this.lstDocente = lstDocente;
    }

    public List<Docente> getLstDocenteParaTribunal() {
        return lstDocenteParaTribunal;
    }

    public void setLstDocenteParaTribunal(List<Docente> lstDocenteParaTribunal) {
        this.lstDocenteParaTribunal = lstDocenteParaTribunal;
    }

    public List<SelectItem> getLstSIDocenteParaTribunal() {
        return lstSIDocenteParaTribunal;
    }

    public void setLstSIDocenteParaTribunal(List<SelectItem> lstSIDocenteParaTribunal) {
        this.lstSIDocenteParaTribunal = lstSIDocenteParaTribunal;
    }

    public List<Profesional> getLstProfesional() {
        return lstProfesional;
    }

    public void setLstProfesional(List<Profesional> lstProfesional) {
        this.lstProfesional = lstProfesional;
    }

    public List<ProyectoCodirector> getLstproyCodir() {
        return lstproyCodir;
    }

    public void setLstproyCodir(List<ProyectoCodirector> lstproyCodir) {
        this.lstproyCodir = lstproyCodir;
    }

    public List<ProyectoAsesor> getLstproyAs() {
        return lstproyAs;
    }

    public void setLstproyAs(List<ProyectoAsesor> lstproyAs) {
        this.lstproyAs = lstproyAs;
    }

    public void crear() throws Exception {

        System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" + this.listaDocenteBean.getLstSIDocenteParaTribunal());
        this.setLstProyAlumno(proy_alumnoRNbeanLocal.findByProyAlumno(proyecto));
        if (lstProyAlumno == null) {
            System.out.println("hoooooooooooooooooooooooooooooooooooooooooooooollllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());

        } else {
            System.out.println(" else llllllllllllllaaaaaaaaaaa" + lstProyAlumno + proyecto.getId());
        }

        System.out.println("ahora para el proyecto");
        this.setLstProyDirector(proy_directorRNbeanLocal.findByProyDirector(proyecto));
        if (lstProyDirector == null) {
            System.out.println("h proyecto  no tiene nadallllllllllllllaaaaaaaaaaa" + lstProyDirector + proyecto.getId());

        } else {
            System.out.println(" si hay un proyecto" + lstProyDirector + proyecto.getId());
        }
    }

    public void limpiar() {
        this.presidente = new Docente();
        this.vocal1 = new Docente();
        this.vocal2 = new Docente();
        this.suplente1 = new Docente();
        this.suplente2 = new Docente();
        this.aceptacion = new Aceptacion();
        this.aceptacion_observacion = new AceptacionObservaciones();
        this.cronograma = new Cronograma();
        this.cronograma = new Cronograma();
        this.cronogramaAct = new CronogramaActividad();
        this.act = new CronogramaActividad();

    }

    public void create() {
        String sMensaje = "";
        String sDetalle = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            acep = new Aceptacion();

            aceptacion.setProyecto(proyecto);

            System.out.println(".......................-->" + aceptacion.getCalificacion());

            if (aceptacion.getCalificacion().getId().equals(1L) || aceptacion.getCalificacion().getId().equals(2L)) {
                System.out.println("...........ENTRO A SETEAR EL TRIBUNAL............-->" + aceptacion.getCalificacion() + presidente + vocal1 + vocal2 + suplente1 + suplente2);
                aceptacion.setPresidente(presidente.getId());

                aceptacion.setVocal1(vocal1.getId());

                aceptacion.setVocal2(vocal2.getId());

                aceptacion.setSuplente1(suplente1.getId());

                aceptacion.setSuplente2(suplente2.getId());

            }
            //consulta que devuelve el codigo de la ultima presentacion que cumple con todos los requisitos del proyecto
            presentacionCodigo = this.presentacionRNbeanLocal.findPresCodigo(proyecto, requisito);
            System.out.println("EL CODIGO DE PRESENTACION ES......: " + presentacionCodigo);
            //consulta que devuelve el registro de presentacion de acuerdo al codigo que me devuelve la consulta anteriro
            presentacion = this.presentacionRNbeanLocal.findByPresentacion(presentacionCodigo);
            System.out.println("EL REGISTRO CON EL CODIGO DE PRESENTACION ES::" + presentacion);
            aceptacion.setPresentacion(presentacion);

            aceptacionRNbeanLocal.create(aceptacion);

            //cargando datos correspondientes a la clase aceptacion_obs
            // acep = this.aceptacionRNbeanLocal.findByAceptacion(aceptacion.getProyecto(), aceptacion.getPresentacion(), aceptacion.getCalificacion());
            System.out.println("el objeto aceptacion es.............." + aceptacion);
            aceptacion_observacion.setFecha(aceptacion.getFecha());
            aceptacion_observacion.setAceptacion(aceptacion);

            aceptacion_obsRNbeanLocal.create(aceptacion_observacion);
            System.out.println("el objeto aceptacion es " + aceptacion);

            //si la  calificacion es: APROBADO el proyecto cambia el estado a: en proceso de asignacion de comision evaluadora
            if (aceptacion.getCalificacion().getCalificacion().equals("Aprobado")
                    || aceptacion.getCalificacion().getCalificacion().equals("APROBADO")
                    || aceptacion.getCalificacion().getId().equals(1L)) {
                //si la  calificacion es: APROBADO el proyecto cambia el estado a: en proceso de asignacion de comision evaluadora
                estado = proyectoRNbeanLocal.findByEstado(2);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + aceptacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
                setear_cronograma();

            }
            //si la  calificacion es: APROBADO con modificaciones el proyecto cambia el estado a: en proceso de asignacion de comision evaluadora
            if (aceptacion.getCalificacion().getCalificacion().equals("Aprobado con modificaciones")
                    || aceptacion.getCalificacion().getCalificacion().equals("APROBADO CON MODIFICACIONES")
                    || aceptacion.getCalificacion().getId().equals(2L)) {

                estado = proyectoRNbeanLocal.findByEstado(2);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + aceptacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
                setear_cronograma();
            }
            //si la  calificacion es: SE REQUIERE UNA NUEVA PRESENTACION el proyecto cambia el estado a: SE REQUIERE UNA NUEVA PRESENTACION

            if (aceptacion.getCalificacion().getCalificacion().equals("Se requiere una nueva presentacion")
                    || aceptacion.getCalificacion().getCalificacion().equals("SE REQUIERE UNA NUEVA PRESENTACION")
                    || aceptacion.getCalificacion().getId().equals(3L)) {
                estado = proyectoRNbeanLocal.findByEstado(3);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es " + aceptacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }
            //si la  calificacion es: RECHAZADO el proyecto cambia el estado a: pROYECTO RECHAZADO
            if (aceptacion.getCalificacion().getCalificacion().equals("Rechazado")
                    || aceptacion.getCalificacion().getCalificacion().equals("RECHAZADO")
                    || aceptacion.getCalificacion().getId().equals(4L)) {
                estado = proyectoRNbeanLocal.findByEstado(7);
                System.out.println("El estado esw:" + estado.getEstado());
                proyecto.setEstado(estado);
                System.out.println("hasta aca nomaaooooooojojojoojojojo :(" + proyecto.getEstado().getEstado());
                proyectoRNbeanLocal.edit(proyecto);
                System.out.println("la calificacion seleccionada es  " + aceptacion.getCalificacion().getCalificacion());
                sDetalle = "El estado del proyecto es ahora : " + estado.getEstado();
            }

            listaIndicadores21Bean.CargarListaIndicadores();
            System.out.println("LISTA DE INDICADORES EN ACEPTACIONBEAN---->" + listaIndicadores21Bean.getListaIndicadores());
            setear_indicadores(aceptacion);

            this.envioMailsBean.ReporteCambioDeEstado(proyecto);
            sMensaje = "Aceptacion fue guardado exitosamente";

            severity = FacesMessage.SEVERITY_INFO;
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgAcepProyecto').hide();");
            limpiar();
            listaIndicadores21Bean.limpiar();
            navegarBean.entrarFormAceptacion();

            //pdf
            //    this.imprimir();
            //agregar a la lista
            //limpiar campos
            // this.limpiar();
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear Aceptación de proyecto: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, sDetalle);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
            //this.imprimir();
        }
    }

    public void control_calificacion(Calificacion calif) {

        if (calif.getId().equals(1L) || calif.getId().equals(2L)) {

            this.setIsAprobado(Boolean.TRUE);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCronograma').show();");
            this.listaCalificacionBean.setIsAprobado(Boolean.TRUE);
        }

    }

    public void mostrarDialogTribunal() {
        System.out.println("ENTRO A MOSTRAR DIALOGO");
        System.out.println("El selct item de trubunal es" + lstSIDocenteParaTribunal);
        RequestContext context = RequestContext.getCurrentInstance();

        context.execute("PF('dlgTribunal').show();");

    }

    public void setear_cronograma() {

        cronograma.setProyecto(proyecto);

        try {
            this.cronogramaRNLocal.create(cronograma);
        } catch (Exception ex) {
            Logger.getLogger(AceptacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         Se recorre la lista que tiene las actividades insertados y se hace un create en la tabla
         por cada actividad de la lista
         */
        Iterator<CronogramaActividad> it = listaCronogramaBean.getListaCronActiv().iterator();

        while (it.hasNext()) {
            act = it.next();

            this.act.setCronograma(cronograma);
            this.setCronogramaAct(act);
            try {
                this.cronogramaActividadRNLocal.create(act);

            } catch (Exception ex) {
                Logger.getLogger(EvaluacionProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void setear_indicadores(Aceptacion acep) {

        int i = 1;

        System.out.println("LLego al iterator");
        /*
         Se recorre la lista que tiene los indicadores insertados y se hace un create en la tabla
         por cada indicador de la lista
         */
        Iterator<GuiaEvaluacion2_1_indicadores> it = listaIndicadores21Bean.getListaIndicadores().iterator();

        while (it.hasNext()) {
            ind = it.next();

            this.ind.setNumero(i);
            this.ind.setAceptacion(acep);

            try {
                this.guiaEvaluacion2_1_indicadoresRNLocal.create(ind);

            } catch (Exception ex) {
                Logger.getLogger(EvaluacionProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }

    }

    public void checkBoxListener() {
        System.out.println("ENTRO A CHECKBOX LISTENER ~~~~~~~~~~~~~~~~~~>" + this.checkedF);

        if (this.checkedF.equals(false)) {
            this.setCheckedF(Boolean.TRUE);
        } else {
            this.setCheckedF(Boolean.FALSE);
        }

        System.out.println("SALIO DEL CHECKBOX LISTENER ~~~~~~~~~~~~~~~~~~>" + this.checkedF);
    }

}
