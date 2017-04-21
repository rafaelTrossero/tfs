/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.AceptacionRNLocal;
import RN.BorradorEvaluacionRNLocal;
import RN.BorradorRNLocal;
import RN.DocenteComisionRNLocal;
import RN.EvaluacionProyectoRNLocal;
import RN.ProyectoAlumnoRNLocal;
import RN.ProyectoAsesorRNLocal;
import RN.ProyectoCodirectorRNLocal;
import RN.ProyectoDirectorRNLocal;
import RN.ProyectoRNbeanLocal;
import RN.ProyectoTribunalRNLocal;
import RN.TribunalRNLocal;
import entidad.Aceptacion;
import entidad.Borrador;
import entidad.BorradorEvaluacion;
import entidad.Carrera;
import entidad.Comision;
import entidad.Docente;
import entidad.EvaluacionProyecto;
import entidad.Proyecto;
import entidad.ProyectoAlumno;
import entidad.ProyectoAsesor;
import entidad.ProyectoCodirector;
import entidad.ProyectoDirector;
import entidad.Tribunal;
import entidad.Usuario;
import entidad.tipoUsuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;


/**
 *
 * @author WalterVergara
 */
@ManagedBean
@SessionScoped
public class ListaProyectoBean implements Serializable {

    @EJB
    private ProyectoRNbeanLocal proyectoRNbeanLocal;
    private List<Proyecto> lstProyecto;

    private List<String> lstAños;

    private List<Proyecto> lstProyectoCarrera;
    private List<SelectItem> lstSIProyectoCarrera;

    private List<Proyecto> lstProyectoByEstado;
    private List<SelectItem> lstSIProyecto;
    private List<SelectItem> lstSIProyectoByEstado;
    private List<Proyecto> lstProyectoAll;
    private List<Proyecto> lstproyAses;
    private ProyectoAsesor proyAses;
    private List<SelectItem> lstSIProyectoAll;
    private int iActionBtnSelect;
    private List<ProyectoCodirector> lstProyectoCodirector;
    private ProyectoCodirector proyCodir;
    private List<ProyectoDirector> lstProyectoDirector;
    private ProyectoDirector proyDir;
    private List<Proyecto> lstProyectoByTribunal;
    private List<ProyectoAsesor> lstProyectoAsesor;
    private List<SelectItem> lstSIProyectoByTribunal;
    private List<SelectItem> lstSIProyectoAsesor;
    private List<Tribunal> lstTribunal;
    private Tribunal tribunalDoc;
    private Tribunal tribunalProy;
    private ProyectoAlumno proyAlu;
    private Proyecto proyectoResult;
    private List<ProyectoDirector> lstProyectoDirectorDocente;
    private List<ProyectoCodirector> lstProyectoCodirectorDocente;
    private List<ProyectoAsesor> lstProyectoAsesorDocente;
    private Proyecto proyecto;

    private String años;

    private Comision comision;

    private Boolean hayCodirector;

    private boolean certificado;
    private boolean notadeDirector;
    private boolean notadeAceptacion;
    private boolean notadeCodirector;

    @EJB
    private TribunalRNLocal tribunalRNlocal;
    @EJB
    private ProyectoTribunalRNLocal proyectoTribunalRNlocal;
    @EJB
    private DocenteComisionRNLocal docenteComisionRNlocal;
    @EJB
    private ProyectoAsesorRNLocal proyectoAsesorRNlocal;
    @EJB
    private ProyectoCodirectorRNLocal proyectoCodirectorRNlocal;
    @EJB
    private ProyectoDirectorRNLocal proyectoDirectorRNlocal;
    @EJB
    private ProyectoAlumnoRNLocal proyectoAlumnoRNLocal;
    @EJB
    private AceptacionRNLocal aceptacionRNLocal;
    @EJB
    private EvaluacionProyectoRNLocal evaluacionProyectoRNLocal;
    @EJB
    private BorradorRNLocal borradorRNLocal;
    @EJB
    private BorradorEvaluacionRNLocal borradorEvaluacionRNLocal;

    private Date fechaActual;
    private final String escudo1 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Imagenes/nuevoLogoFacultad2.jpg");
    private final String escudo2 = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Imagenes/escudo.jpg");
    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");

    Calendar calendar = Calendar.getInstance();

    private List<Proyecto> lstProyecto2;

    private Aceptacion aceptacion;

    private EvaluacionProyecto evaluacionProyecto;

    private Borrador borrador;

    private BorradorEvaluacion borradorEvaluacion;

    public ListaProyectoBean() {
        System.out.println("Constructor ListaProyectoBean");
        lstProyecto = new ArrayList<Proyecto>();

        lstAños = new ArrayList<String>();

        lstProyectoCarrera = new ArrayList<Proyecto>();

        lstProyecto2 = new ArrayList<Proyecto>();

        lstProyectoByEstado = new ArrayList<Proyecto>();
        lstProyectoAsesor = new ArrayList<ProyectoAsesor>();
        lstProyectoAll = new ArrayList<Proyecto>();
        lstProyectoByTribunal = new ArrayList<Proyecto>();
        tribunalDoc = new Tribunal();
        tribunalProy = new Tribunal();
        proyecto = new Proyecto();
        comision = new Comision();
        lstproyAses = new ArrayList<Proyecto>();
        proyAses = new ProyectoAsesor();
        lstProyectoCodirector = new ArrayList<ProyectoCodirector>();
        proyCodir = new ProyectoCodirector();
        lstProyectoDirector = new ArrayList<ProyectoDirector>();
        proyDir = new ProyectoDirector();
        proyAlu = new ProyectoAlumno();
        proyectoResult = new Proyecto();

        lstProyectoDirectorDocente = new ArrayList<ProyectoDirector>();
        lstProyectoCodirectorDocente = new ArrayList<ProyectoCodirector>();
        lstProyectoAsesorDocente = new ArrayList<ProyectoAsesor>();

        aceptacion = new Aceptacion();
        evaluacionProyecto = new EvaluacionProyecto();
        borrador = new Borrador();
        borradorEvaluacion = new BorradorEvaluacion();

        //lstProyectoByEstado= new ArrayList<Proyecto>();
    }

    @PostConstruct
    void init() {
        System.out.println("PostConstructor ListaProyectoBean");
        this.cargar_proyectos();
        this.cargar_SI_proyectos();
       //this.cargar_proyectosByEstado(1);

        //System.out.println("Departamentos: " + this.getLstDepartamento());
    }

    public List<ProyectoAsesor> getLstProyectoAsesorDocente() {
        return lstProyectoAsesorDocente;
    }

    public void setLstProyectoAsesorDocente(List<ProyectoAsesor> lstProyectoAsesorDocente) {
        this.lstProyectoAsesorDocente = lstProyectoAsesorDocente;
    }

    public List<Proyecto> getLstProyectoCarrera() {
        return lstProyectoCarrera;
    }

    public void setLstProyectoCarrera(List<Proyecto> lstProyectoCarrera) {
        this.lstProyectoCarrera = lstProyectoCarrera;
    }

    public List<ProyectoDirector> getLstProyectoDirectorDocente() {
        return lstProyectoDirectorDocente;
    }

    public void setLstProyectoDirectorDocente(List<ProyectoDirector> lstProyectoDirectorDocente) {
        this.lstProyectoDirectorDocente = lstProyectoDirectorDocente;
    }

    public List<ProyectoCodirector> getLstProyectoCodirectorDocente() {
        return lstProyectoCodirectorDocente;
    }

    public void setLstProyectoCodirectorDocente(List<ProyectoCodirector> lstProyectoCodirectorDocente) {
        this.lstProyectoCodirectorDocente = lstProyectoCodirectorDocente;
    }

    public List<Proyecto> getLstProyecto() {
        return lstProyecto;
    }

    public void setLstProyecto(List<Proyecto> lstProyecto) {
        this.lstProyecto = lstProyecto;
    }

    public List<String> getLstAños() {
        return lstAños;
    }

    public void setLstAños(List<String> lstAños) {
        this.lstAños = lstAños;
    }

    public List<ProyectoCodirector> getLstProyectoCodirector() {
        return lstProyectoCodirector;
    }

    public ProyectoAlumno getProyAlu() {
        return proyAlu;
    }

    public void setProyAlu(ProyectoAlumno proyAlu) {
        this.proyAlu = proyAlu;
    }

    public Proyecto getProyectoResult() {
        return proyectoResult;
    }

    public void setProyectoResult(Proyecto proyectoResult) {
        this.proyectoResult = proyectoResult;
    }

    public List<ProyectoDirector> getLstProyectoDirector() {
        return lstProyectoDirector;
    }

    public void setLstProyectoDirector(List<ProyectoDirector> lstProyectoDirector) {
        this.lstProyectoDirector = lstProyectoDirector;
    }

    public ProyectoDirector getProyDir() {
        return proyDir;
    }

    public void setProyDir(ProyectoDirector proyDir) {
        this.proyDir = proyDir;
    }

    public void setLstProyectoCodirector(List<ProyectoCodirector> lstProyectoCodirector) {
        this.lstProyectoCodirector = lstProyectoCodirector;
    }

    public ProyectoCodirector getProyCodir() {
        return proyCodir;
    }

    public void setProyCodir(ProyectoCodirector proyCodir) {
        this.proyCodir = proyCodir;
    }

    public List<SelectItem> getLstSIProyectoAsesor() {
        return lstSIProyectoAsesor;
    }

    public List<SelectItem> getLstSIProyectoCarrera() {
        return lstSIProyectoCarrera;
    }

    public void setLstSIProyectoCarrera(List<SelectItem> lstSIProyectoCarrera) {
        this.lstSIProyectoCarrera = lstSIProyectoCarrera;
    }

    public List<Proyecto> getLstproyAses() {
        return lstproyAses;
    }

    public void setLstproyAses(List<Proyecto> lstproyAses) {
        this.lstproyAses = lstproyAses;
    }

    public ProyectoAsesor getProyAses() {
        return proyAses;
    }

    public void setProyAses(ProyectoAsesor proyAses) {
        this.proyAses = proyAses;
    }

    public void setLstSIProyectoAsesor(List<SelectItem> lstSIProyectoAsesor) {
        this.lstSIProyectoAsesor = lstSIProyectoAsesor;
    }

    public List<Proyecto> getLstProyectoAll() {
        return lstProyectoAll;
    }

    public List<ProyectoAsesor> getLstProyectoAsesor() {
        return lstProyectoAsesor;
    }

    public void setLstProyectoAsesor(List<ProyectoAsesor> lstProyectoAsesor) {
        this.lstProyectoAsesor = lstProyectoAsesor;
    }

    public void setLstProyectoAll(List<Proyecto> lstProyectoAll) {
        this.lstProyectoAll = lstProyectoAll;
    }

    public List<SelectItem> getLstSIProyectoAll() {
        return lstSIProyectoAll;
    }

    public void setLstSIProyectoAll(List<SelectItem> lstSIProyectoAll) {
        this.lstSIProyectoAll = lstSIProyectoAll;
    }

    public List<SelectItem> getLstSIProyecto() {
        return lstSIProyecto;
    }

    public void setLstSIProyecto(List<SelectItem> lstSIProyecto) {
        this.lstSIProyecto = lstSIProyecto;
    }

    public List<Proyecto> getLstProyectoByEstado() {
        return lstProyectoByEstado;
    }

    public void setLstProyectoByEstado(List<Proyecto> lstProyectoByEstado) {
        this.lstProyectoByEstado = lstProyectoByEstado;
    }

    public List<SelectItem> getLstSIProyectoByEstado() {
        return lstSIProyectoByEstado;
    }

    public void setLstSIProyectoByEstado(List<SelectItem> lstSIProyectoByEstado) {
        this.lstSIProyectoByEstado = lstSIProyectoByEstado;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<Tribunal> getLstTribunal() {
        return lstTribunal;
    }

    public void setLstTribunal(List<Tribunal> lstTribunal) {
        this.lstTribunal = lstTribunal;
    }

    public List<Proyecto> getLstProyectoByTribunal() {
        return lstProyectoByTribunal;
    }

    public void setLstProyectoByTribunal(List<Proyecto> lstProyectoByTribunal) {
        this.lstProyectoByTribunal = lstProyectoByTribunal;
    }

    public List<SelectItem> getLstSIProyectoByTribunal() {
        return lstSIProyectoByTribunal;
    }

    public void setLstSIProyectoByTribunal(List<SelectItem> lstSIProyectoByTribunal) {
        this.lstSIProyectoByTribunal = lstSIProyectoByTribunal;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public DocenteComisionRNLocal getDocenteComisionRNlocal() {
        return docenteComisionRNlocal;
    }

    public void setDocenteComisionRNlocal(DocenteComisionRNLocal docenteComisionRNlocal) {
        this.docenteComisionRNlocal = docenteComisionRNlocal;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }

    public Boolean getHayCodirector() {
        return hayCodirector;
    }

    public void setHayCodirector(Boolean hayCodirector) {
        this.hayCodirector = hayCodirector;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public boolean isNotadeDirector() {
        return notadeDirector;
    }

    public void setNotadeDirector(boolean notadeDirector) {
        this.notadeDirector = notadeDirector;
    }

    public boolean isNotadeAceptacion() {
        return notadeAceptacion;
    }

    public void setNotadeAceptacion(boolean notadeAceptacion) {
        this.notadeAceptacion = notadeAceptacion;
    }

    public boolean isNotadeCodirector() {
        return notadeCodirector;
    }

    public void setNotadeCodirector(boolean notadeCodirector) {
        this.notadeCodirector = notadeCodirector;
    }

    public void setearNotaDeCodirector() {

        this.setNotadeCodirector(Boolean.TRUE);
        System.out.println("LA NOTA DE CODIRECTOR ES ----->>>" + notadeCodirector);
    }

    public ProyectoRNbeanLocal getProyectoRNbeanLocal() {
        return proyectoRNbeanLocal;
    }

    public void setProyectoRNbeanLocal(ProyectoRNbeanLocal proyectoRNbeanLocal) {
        this.proyectoRNbeanLocal = proyectoRNbeanLocal;
    }

    public ProyectoAsesorRNLocal getProyectoAsesorRNlocal() {
        return proyectoAsesorRNlocal;
    }

    public void setProyectoAsesorRNlocal(ProyectoAsesorRNLocal proyectoAsesorRNlocal) {
        this.proyectoAsesorRNlocal = proyectoAsesorRNlocal;
    }

    public ProyectoCodirectorRNLocal getProyectoCodirectorRNlocal() {
        return proyectoCodirectorRNlocal;
    }

    public void setProyectoCodirectorRNlocal(ProyectoCodirectorRNLocal proyectoCodirectorRNlocal) {
        this.proyectoCodirectorRNlocal = proyectoCodirectorRNlocal;
    }

    public ProyectoDirectorRNLocal getProyectoDirectorRNlocal() {
        return proyectoDirectorRNlocal;
    }

    public void setProyectoDirectorRNlocal(ProyectoDirectorRNLocal proyectoDirectorRNlocal) {
        this.proyectoDirectorRNlocal = proyectoDirectorRNlocal;
    }

    public ProyectoAlumnoRNLocal getProyectoAlumnoRNLocal() {
        return proyectoAlumnoRNLocal;
    }

    public void setProyectoAlumnoRNLocal(ProyectoAlumnoRNLocal proyectoAlumnoRNLocal) {
        this.proyectoAlumnoRNLocal = proyectoAlumnoRNLocal;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) throws InstantiationException, IllegalAccessException {
        // this.fechaActual = Date.from(Instant.now());
        this.fechaActual = Date.class.newInstance();
    }

    public List<Proyecto> getLstProyecto2() {
        return lstProyecto2;
    }

    public void setLstProyecto2(List<Proyecto> lstProyecto2) {
        this.lstProyecto2 = lstProyecto2;
    }

    public Aceptacion getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Aceptacion aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Tribunal getTribunalProy() {
        return tribunalProy;
    }

    public void setTribunalProy(Tribunal tribunalProy) {
        this.tribunalProy = tribunalProy;
    }

    public EvaluacionProyecto getEvaluacionProyecto() {
        return evaluacionProyecto;
    }

    public void setEvaluacionProyecto(EvaluacionProyecto evaluacionProyecto) {
        this.evaluacionProyecto = evaluacionProyecto;
    }

    public Borrador getBorrador() {
        return borrador;
    }

    public void setBorrador(Borrador borrador) {
        this.borrador = borrador;
    }

    public BorradorEvaluacion getBorradorEvaluacion() {
        return borradorEvaluacion;
    }

    public void setBorradorEvaluacion(BorradorEvaluacion borradorEvaluacion) {
        this.borradorEvaluacion = borradorEvaluacion;
    }

    public void cargar_proyectos() {
        try {
            this.setLstProyecto(this.proyectoRNbeanLocal.findAll());

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos " + ex.toString());
        }
        System.out.println("LOS PROYECTOS SOONNNN;;;;;" + lstProyecto);
    }

    /* public void cargar_añosproyectos() {
     try {
     this.setLstAños();
     this.setLstProyecto(this.proyectoRNbeanLocal.findAll());

     } catch (Exception ex) {
     System.out.println("Error al cargar Proyectos " + ex.toString());
     }
     System.out.println("LOS PROYECTOS SOONNNN;;;;;" + lstProyecto);
     }*/
    public void cargar_proyectos_carrera(Carrera carrera) {
        try {
            this.setLstProyectoCarrera(this.proyectoRNbeanLocal.findProyByCarrera(carrera));

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por carrera" + ex.toString());
        }
        System.out.println("LOS PROYECTOS por carrera son;;;;;" + lstProyectoCarrera);

        cargar_SI_proyectos_carrera();
    }

    public void cargar_proyectos_director_docente(Docente docente) {
        try {
            this.setLstProyectoDirectorDocente(this.proyectoDirectorRNlocal.findProyByDocente(docente));

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por docente" + ex.toString());
        }
        System.out.println("LOS PROYECTOS por docente son son;;;;;" + lstProyectoDirectorDocente);

    }

    public void cargar_proyectos_codirector_docente(long docente) {
        try {
            this.setLstProyectoCodirectorDocente(this.proyectoCodirectorRNlocal.findProyByDocenteCodirector(docente));

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por docente_codirector" + ex.toString());
        }
        System.out.println("LOS PROYECTOS por docente_codirector son;;;;;" + lstProyectoCodirectorDocente);

    }

    public void cargar_proyectos_asesor_docente(long docente) {
        try {
            this.setLstProyectoAsesorDocente(this.proyectoAsesorRNlocal.findProyByDocenteAsesor(docente));

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por docente_asesor" + ex.toString());
        }
        System.out.println("LOS PROYECTOS por docente_asesor son;;;;;" + lstProyectoAsesorDocente);

    }

    public Proyecto cargar_proyectos_alumnos(long idAlu, Usuario a) throws Exception {
        try {
            if (a.getTipousuario().equals(tipoUsuario.ALUMNO)) {
                this.setProyAlu(proyectoAlumnoRNLocal.findByProyectoAlumno(idAlu));
                System.out.println("incha de atletico" + proyAlu);
            }

        } catch (Exception ex) {
            System.out.println("Error al buscar alumnos en proyectoAlumno" + ex.toString());
        }
        return proyAlu.getProyecto();
    }

    public void cargar_proyectos_profesionales(long idDocent, Usuario a) {
        try {
            if (a.getTipousuario().equals(tipoUsuario.DOCENTE) || a.getTipousuario().equals(tipoUsuario.PROFESIONAL)) {
                this.setLstProyectoAsesor(proyectoAsesorRNlocal.findByProyectoAsesor(idDocent));

                if (lstProyectoAsesor != null) {
                    Iterator<ProyectoAsesor> it = lstProyectoAsesor.iterator();

                    while (it.hasNext()) {
                        proyAses = it.next();
                        System.out.println("hola" + proyAses.getProyecto().getTitulo());

                        //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
                        lstproyAses.add(proyAses.getProyecto());
                    }

                }

                this.setLstProyectoCodirector(proyectoCodirectorRNlocal.findByProyectoCodirector(idDocent));

                if (lstProyectoCodirector != null) {
                    Iterator<ProyectoCodirector> ik = lstProyectoCodirector.iterator();

                    while (ik.hasNext()) {
                        proyCodir = ik.next();

                        //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
                        lstproyAses.add(proyCodir.getProyecto());
                    }

                }
                this.setLstProyectoDirector(proyectoDirectorRNlocal.findByProyectoDirector(idDocent));

                if (lstProyectoDirector != null) {
                    Iterator<ProyectoDirector> ip = lstProyectoDirector.iterator();

                    while (ip.hasNext()) {
                        proyDir = ip.next();
                        System.out.println("hola" + proyDir.getProyecto().getTitulo());

                        //realiza el alta en la tabla relacional proy_alumno dependiendo de cuantos alumnos se han seleccionado
                        lstproyAses.add(proyDir.getProyecto());
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("Error al buscar profesionales en proyectoAsesor" + ex.toString());
        }

    }

    public void cargar_SI_proyectos_profesionales() {
        this.setLstSIProyectoAsesor(new ArrayList<SelectItem>());

        for (Proyecto t : this.getLstproyAses()) {
            SelectItem si = new SelectItem(t, t.getTitulo());
            this.getLstSIProyectoAsesor().add(si);
        }

    }

    public void cargar_SI_proyectos_carrera() {
        this.setLstSIProyectoCarrera(new ArrayList<SelectItem>());

        for (Proyecto t : this.getLstProyectoCarrera()) {
            SelectItem si = new SelectItem(t, t.getTitulo());
            this.getLstSIProyectoCarrera().add(si);
        }

    }

    public void cargar_proyectosByEstado(Integer estado, long idDoc) {
        try {
            System.out.println("]]]]]]]]]]]]]]]]]]]]]************]]]]]]]]]]]]]]]]]]]]]]]" + idDoc);
            if (idDoc != 9999L) {
                this.setComision(this.docenteComisionRNlocal.findByIdDocente(idDoc));
                if (comision.getId().equals(1L)) {
                    this.setLstProyectoByEstado(this.proyectoRNbeanLocal.findProyByEstado(estado));
                    System.out.println("los proyectos con estado " + estado + "son : " + lstProyectoByEstado);
                }
            } else {
                this.setLstProyectoByEstado(this.proyectoRNbeanLocal.findProyByEstado(estado));
                System.out.println("los proyectos con estado " + estado + "son : " + lstProyectoByEstado);
            }

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por estado" + ex.toString());
        }
    }

    public void cargar_proyectosAll(long idDocente) {
        try {

            if (idDocente != 9999L) {
                this.setComision(this.docenteComisionRNlocal.findByIdDocente(idDocente));
                System.out.println("pertenece a alguna comision" + comision.getComision());
                if (comision.getId().equals(1L)) {
                    this.setLstProyectoAll(this.proyectoRNbeanLocal.findAll());

                }
            } else {
                this.setLstProyectoAll(this.proyectoRNbeanLocal.findAll());

            }

        } catch (Exception ex) {
            System.out.println("Error al cargar Proyectos por estado" + ex.toString());
        }
    }

    public void cargar_SI_proyectos() {
        this.setLstSIProyecto(new ArrayList<SelectItem>());
        System.out.println("LOS PROYECTOS QUE LLEGAN AL SI  SOONNNN;;;;;" + lstProyecto);
        for (Proyecto p : this.getLstProyecto()) {
            SelectItem si = new SelectItem(p, p.getTitulo());
            this.getLstSIProyecto().add(si);
        }

    }//fin for

    public void cargar_SI_proyectosAll() {
        this.setLstSIProyectoAll(new ArrayList<SelectItem>());
        System.out.println("LOS PROYECTOS QUE LLEGAN AL SI  SOONNNN;;;;;" + lstProyectoAll);
        for (Proyecto t : this.getLstProyectoAll()) {
            SelectItem ki = new SelectItem(t, t.getTitulo());
            this.getLstSIProyectoAll().add(ki);
        }

    }//fin for

    public void cargar_SI_proyectosbyEstado() {

        this.setLstSIProyectoByEstado(new ArrayList<SelectItem>());

        for (Proyecto a : this.getLstProyectoByEstado()) {
            SelectItem di = new SelectItem(a, a.getTitulo());
            this.getLstSIProyectoByEstado().add(di);
        }
        System.out.println("los proyectos en el selecitem son" + lstSIProyectoByEstado);
    }//fin for

    public void cargarProyectosByDocenteTribunal(long idDoc, long estado) {

        if (idDoc != 9999L) {
            try {

                this.setLstTribunal(tribunalRNlocal.findTribunalByDocente(idDoc));
                System.out.println(":::::::::::::: TRIBUNAL DONDE ESTA EL DOCENTE ES:::::::::::::::::" + lstTribunal);

            } catch (Exception ex) {
                Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            Iterator<Tribunal> tribunal = lstTribunal.iterator();

            try {
                //System.out.println("el codigo del proyecto es " + proy_ases.getProyecto().getTitulo());
            } catch (Exception ex) {
                Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (tribunal.hasNext()) {
                try {
                    tribunalDoc = tribunal.next();

                    this.setProyecto(proyectoTribunalRNlocal.findProyectoByTribunal(tribunalDoc.getId()));
                    System.out.println("[]]]]]]][][][][][][][][][][][]***" + proyecto.getEstado().getId());
                    if (proyecto.getEstado().getId().equals(estado)) {
                        lstProyectoByTribunal.add(proyecto);

                    }

                } catch (Exception ex) {
                    Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            try {
                System.out.println("[]]]]]]][][][]ENTRO POR EL ELSE [][][][][][][]***");
                this.setLstProyectoByTribunal(this.proyectoRNbeanLocal.findProyByEstado(8));
            } catch (Exception ex) {
                Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(":::::::::::::: LOS PROYECTOS SON!!!!!!!!:::::::::::::::::" + lstProyectoByTribunal);
    }

    public void cargar_SI_proyectosbyDocenteTribunal() {

        this.setLstSIProyectoByTribunal(new ArrayList<SelectItem>());

        for (Proyecto a : this.getLstProyectoByTribunal()) {
            SelectItem di = new SelectItem(a, a.getTitulo());
            this.getLstSIProyectoByTribunal().add(di);
        }
        System.out.println("los proyectos en el selecitem son" + lstSIProyectoByEstado);
    }//fin for

    public List<Proyecto> buscarProyectosAtrasados(Integer estado, Integer dias, Integer cal) {

        lstProyecto2.clear();
        lstProyectoByEstado.clear();

        try {
            this.setLstProyectoByEstado(proyectoRNbeanLocal.findProyByEstado(estado));

            if (lstProyectoByEstado != null) {
                Iterator<Proyecto> it = lstProyectoByEstado.iterator();

                if (estado.equals(1)) {

                    System.out.println("Entro al PRIMER IF .........................................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso());

                        setFechaActual(Date.class.newInstance());

                        calendar.setTime(proyecto.getFecha_ingreso());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto);
                            lstProyecto2.add(proyecto);
                        }

                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }

                    return lstProyecto2;
                }

                if (estado.equals(2) || estado.equals(3)) {

                    System.out.println("Entro al SEGUNDO IF .........................................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso());

                        setFechaActual(Date.class.newInstance());

                        this.setAceptacion(aceptacionRNLocal.findByProyAceptacion(proyecto, cal));

                        calendar.setTime(aceptacion.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }

                if (estado.equals(4)) {

                    System.out.println("Entro al TERCER IF .........................................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso());

                        setFechaActual(Date.class.newInstance());

                        this.setTribunalProy(tribunalRNlocal.findTribunal(proyecto, true));
                        System.out.println("++++++++++++++++++++++ TRIBUNAL ++++++++++++++ " + tribunalProy);

                        calendar.setTime(tribunalProy.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }

                if (estado.equals(6)) {

                    System.out.println("Entro al CUARTO IF ...MODIFICACIONES...........................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso() + "------ ID -----" + proyecto.getId() + "---- CALIFICACION---" + cal);

                        setFechaActual(Date.class.newInstance());

                        this.setEvaluacionProyecto(evaluacionProyectoRNLocal.findByProyectoYcalif(proyecto, cal));
                        System.out.println("++++++++++++++++++++++ EVALUACION PROYECTOOOOO ++++++++++++++ " + evaluacionProyecto);

                        calendar.setTime(evaluacionProyecto.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }

                if (estado.equals(5)) {

                    System.out.println("Entro al QUINTO IF ...DESARROLLANDO TRABAJO FINAL...........................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso() + "------ ID -----" + proyecto.getId() + "---- CALIFICACION---" + cal);

                        setFechaActual(Date.class.newInstance());

                        this.setEvaluacionProyecto(evaluacionProyectoRNLocal.findByProyectoYcalif(proyecto, cal));
                        System.out.println("++++++++++++++++++++++ EVALUACION PROYECTOOOOO ++++++++++++++ " + evaluacionProyecto);

                        calendar.setTime(evaluacionProyecto.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }

                if (estado.equals(8)) {

                    System.out.println("Entro al SEXTO IF ...BORRADOR...........................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso() + "------ ID -----" + proyecto.getId() + "---- CALIFICACION---" + cal);

                        setFechaActual(Date.class.newInstance());

                        this.setBorrador(borradorRNLocal.findById(borradorRNLocal.findByProyecto(proyecto)));
                        System.out.println("++++++++++++++++++++++ BORRADOR ++++++++++++++ " + borrador);

                        calendar.setTime(borrador.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }
                if (estado.equals(11)) {

                    System.out.println("Entro al SEPTIMO IF ...Nueva presentacion de BORRADOR...........................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso() + "------ ID -----" + proyecto.getId() + "---- CALIFICACION---" + cal);

                        setFechaActual(Date.class.newInstance());

                        this.setBorradorEvaluacion(borradorEvaluacionRNLocal.findByProyectoYcalif(proyecto, cal, borradorRNLocal.findByProyecto(proyecto)));
                        System.out.println("++++++++++++++++++++++MODIFICACIONES BORRADOR ++++++++++++++ " + borradorEvaluacion);

                        calendar.setTime(borradorEvaluacion.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }
                if (estado.equals(10)) {

                    System.out.println("Entro al OCTAVO IF ...MODIFICACIONES de BORRADOR...........................................................");
                    while (it.hasNext()) {
                        proyecto = it.next();
                        System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso() + "------ ID -----" + proyecto.getId() + "---- CALIFICACION---" + cal);

                        setFechaActual(Date.class.newInstance());

                        this.setBorradorEvaluacion(borradorEvaluacionRNLocal.findByProyectoYcalif(proyecto, cal, borradorRNLocal.findByProyecto(proyecto)));
                        System.out.println("++++++++++++++++++++++MODIFICACIONES BORRADOR ++++++++++++++ " + borradorEvaluacion);

                        calendar.setTime(borradorEvaluacion.getFecha());
                        calendar.add(Calendar.DATE, dias);

                        System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                        if (calendar.getTime().before(fechaActual)) {
                            System.out.println("ENTRO AL IF" + proyecto.getTitulo());
                            lstProyecto2.add(proyecto);
                        }
                        System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                        System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                    }
                    return lstProyecto2;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Proyecto> buscarProyectosAtrasadosEnAsignacionDeTribunal(Integer estado, Integer dias, Integer cal) {

        lstProyecto2.clear();
        lstProyectoByEstado.clear();

        try {
            this.setLstProyectoByEstado(proyectoRNbeanLocal.findProyByEstado(estado));

            if (lstProyectoByEstado != null) {
                Iterator<Proyecto> it = lstProyectoByEstado.iterator();

                while (it.hasNext()) {
                    proyecto = it.next();
                    System.out.println("hola" + proyecto.getTitulo() + "fechaaa de ingresooo" + proyecto.getFecha_ingreso());

                    setFechaActual(Date.class.newInstance());

                    this.setAceptacion(aceptacionRNLocal.findByProyAceptacion(proyecto, 1));

                    calendar.setTime(aceptacion.getFecha());
                    calendar.add(Calendar.DATE, dias);

                    System.out.println("CALENDAR TIENEeee" + calendar.getTime());

                    if (calendar.getTime().before(fechaActual)) {
                        System.out.println("ENTRO AL IF" + proyecto);
                        lstProyecto2.add(proyecto);
                    }
                    System.out.println("LSTPROYECTO TIENEEE -->" + lstProyectoByEstado);
                    System.out.println("LSTPROYECTO2 TIENEEE -->" + lstProyecto2);
                }

                return lstProyecto2;
            }

        } catch (Exception ex) {
            Logger.getLogger(ListaProyectoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public void imprimir(List<Proyecto> pro, String estado) {

        String path;
        int tamaño = 0;
        String a = "";
        String estado_tamaño;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");

        try {
            path = "reports\\estados_de_proyecto.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1" + path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2" + reportPath);
            a = Integer.toString(pro.size());
            estado_tamaño = estado + a;

            HashMap parametro = new HashMap();
            parametro.put("estado", estado_tamaño);

            System.out.println("entrooooooooooooooooooooooooooooooo3" + reportPath);

            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);

            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(pro);
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, beanCollectionDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\estados_de_proyecto.pdf"));
            System.out.println("entroooooooooooooooooooooooooooo6" + parametro);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
            exporter.exportReport();
            context.responseComplete();
           //conect.close();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSAaaaaaaaaaaaaaaaaaaaaaa: " + ex.getCause().getMessage());
        }
    }

    public void setearProyectoByEstado(Integer num_estado,String estado) throws SQLException {
         System.out.println("pucha"+ num_estado + estado);
        Connection conect;
        conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tfs-ftyca", "postgres", "123456");
         System.out.println("funcionando"+ conect);
        String path;
        //List<Object[]> l = turnoRNLocal.findHistorialTurnosServicios(1, this.getFechaInicio(), this.getFechaFin());
        System.out.println("funcionando");

        try {
            path = "reports\\estados_de_proyecto.jasper";
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entrooooooooooooooooooooooooooooooo1" + path);
            String reportPath = context.getExternalContext().getRealPath(path);
            System.out.println("entrooooooooooooooooooooooooooooooo2" + reportPath);

            HashMap parametro = new HashMap();
            System.out.println("entrooooooooooooooooooooooooooooooo3" + reportPath);
            parametro.put("numero_estado", num_estado);
            parametro.put("estado",estado );
            parametro.put("escudo1",escudo1 );
            parametro.put("escudo2",escudo2 );

            System.out.println("entroooooooooooo000oooooooooooooooo4" + parametro);

            JRBeanCollectionDataSource beanCollectionDataSource = null;
            System.out.println("entroooooooooooooooooooooooooooo5" + parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametro, conect);
            JasperExportManager.exportReportToPdfFile(jasperPrint, context.getExternalContext().getRealPath("reports\\proyecto_carrera.pdf"));
            System.out.println("entroooooooooooooooooooooooooooo6" + parametro);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
            exporter.exportReport();
            context.responseComplete();
           //conect.close();

        } catch (Exception ex) {
            System.out.println(ex + "CAUSAaaaaaaaaaaaaaaaaaaaaaa: " + ex.getCause().getMessage());
        }

    }

}
