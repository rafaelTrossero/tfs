/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidad.Alumno;
import entidad.AutoridadesDepartamento;
import entidad.Barrio;
import entidad.Carrera;
import entidad.Catedra;
import entidad.Comision;
import entidad.CronogramaActividad;
import entidad.Departamento;
import entidad.Depto;
import entidad.Docente;
import entidad.Especialidad;
import entidad.Estado;
import entidad.Localidad;
import entidad.Noticias;
import entidad.Operacion;
import entidad.Pais;
import entidad.Profesion;
import entidad.Profesional;
import entidad.Provincia;
import entidad.Proyecto;
import entidad.ProyectoAsesor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jmoreno
 */
@ManagedBean
@RequestScoped
public class navegarBean {

    @ManagedProperty("#{listaEstadoBean}")
    private ListaEstadoBean listaEstadoBean;
    
    @ManagedProperty("#{listaNoticiasBean}")
    private ListaNoticiasBean listaNoticiasBean;
    @ManagedProperty("#{listaCronogramaBean}")
    private ListaCronogramaBean listaCronogramaBean;
    @ManagedProperty("#{listaPaisBean}")
    private ListaPaisBean listaPaisBean;
    @ManagedProperty("#{listaProvinciaBean}")
    private ListaProvinciaBean listaProvinciaBean;
    @ManagedProperty("#{listaDepartamentoBean}")
    private ListaDepartamentoBean listaDepartamentoBean;
    @ManagedProperty("#{listaLocalidadBean}")
    private ListaLocalidadBean listaLocalidadBean;
    @ManagedProperty("#{listaBarrioBean}")
    private ListaBarrioBean listaBarrioBean;

    @ManagedProperty("#{listaCarreraBean}")
    private ListaCarreraBean listaCarreraBean;
     @ManagedProperty("#{listaCatedraBean}")
    private ListaCatedraBean listaCatedraBean;
    @ManagedProperty("#{listaAlumnoBean}")
    private ListaAlumnoBean listaAlumnoBean;
    @ManagedProperty("#{listaDocenteBean}")
    private ListaDocenteBean listaDocenteBean;
    @ManagedProperty("#{listaProfesionalBean}")
    private ListaProfesionalBean listaProfesionalBean;
    @ManagedProperty("#{listaProyectoBean}")
    private ListaProyectoBean listaProyectoBean;
    @ManagedProperty("#{listaOperacionBean}")
    private ListaOperacionBean listaOperacionBean;
    @ManagedProperty("#{listaCargoBean}")
    private ListaCargoBean listaCargoBean;
    @ManagedProperty("#{listaDedicacionBean}")
    private ListaDedicacionBean listaDedicacionBean;
    @ManagedProperty("#{listaProfesionBean}")
    private ListaProfesionBean listaProfesionBean;
    @ManagedProperty("#{listaEspecialidadBean}")
    private ListaEspecialidadBean listaEspecialidadBean;
    
    @ManagedProperty("#{operacionBean}")
    private OperacionBean operacionBean;
    @ManagedProperty("#{listaMisProyectosBean}")
    private ListaMisProyectosBean listaMisProyectosBean;
    @ManagedProperty("#{usuarioLogerBean}")
    private UsuarioLogerBean usuarioLogerBean;
     @ManagedProperty("#{envioMailsBean}")
    private EnvioMailsBean envioMailsBean;
     @ManagedProperty("#{listaComisionBean}")
    private ListaComisionBean listaComisionBean;
     @ManagedProperty("#{listaDeptoBean}")
    private ListaDeptoBean listaDeptoBean;
     @ManagedProperty("#{listaProyectosInvestigacionBean}")
    private ListaProyectosInvestigacionBean listaProyectosInvestigacionBean;
   

    /**
     * Creates a new instance of navegarBean
     */
    public navegarBean() {
    }

    public ListaNoticiasBean getListaNoticiasBean() {
        return listaNoticiasBean;
    }

    public void setListaNoticiasBean(ListaNoticiasBean listaNoticiasBean) {
        this.listaNoticiasBean = listaNoticiasBean;
    }

    public ListaProyectosInvestigacionBean getListaProyectosInvestigacionBean() {
        return listaProyectosInvestigacionBean;
    }

    public void setListaProyectosInvestigacionBean(ListaProyectosInvestigacionBean listaProyectosInvestigacionBean) {
        this.listaProyectosInvestigacionBean = listaProyectosInvestigacionBean;
    }
    

    public ListaDeptoBean getListaDeptoBean() {
        return listaDeptoBean;
    }

    public ListaMisProyectosBean getListaMisProyectosBean() {
        return listaMisProyectosBean;
    }

    public void setListaMisProyectosBean(ListaMisProyectosBean listaMisProyectosBean) {
        this.listaMisProyectosBean = listaMisProyectosBean;
    }

    public void setListaDeptoBean(ListaDeptoBean listaDeptoBean) {
        this.listaDeptoBean = listaDeptoBean;
    }

    public OperacionBean getOperacionBean() {
        return operacionBean;
    }

    public void setOperacionBean(OperacionBean operacionBean) {
        this.operacionBean = operacionBean;
    }

    public ListaPaisBean getListaPaisBean() {
        return listaPaisBean;
    }

    public void setListaPaisBean(ListaPaisBean listaPaisBean) {
        this.listaPaisBean = listaPaisBean;
    }

    public ListaProvinciaBean getListaProvinciaBean() {
        return listaProvinciaBean;
    }

    public void setListaProvinciaBean(ListaProvinciaBean listaProvinciaBean) {
        this.listaProvinciaBean = listaProvinciaBean;
    }

    public ListaDepartamentoBean getListaDepartamentoBean() {
        return listaDepartamentoBean;
    }

    public void setListaDepartamentoBean(ListaDepartamentoBean listaDepartamentoBean) {
        this.listaDepartamentoBean = listaDepartamentoBean;
    }

    public ListaLocalidadBean getListaLocalidadBean() {
        return listaLocalidadBean;
    }

    public void setListaLocalidadBean(ListaLocalidadBean listaLocalidadBean) {
        this.listaLocalidadBean = listaLocalidadBean;
    }

    public ListaBarrioBean getListaBarrioBean() {
        return listaBarrioBean;
    }

    public void setListaBarrioBean(ListaBarrioBean listaBarrioBean) {
        this.listaBarrioBean = listaBarrioBean;
    }

    public ListaCarreraBean getListaCarreraBean() {
        return listaCarreraBean;
    }

    public void setListaCarreraBean(ListaCarreraBean listaCarreraBean) {
        this.listaCarreraBean = listaCarreraBean;
    }

    public ListaDocenteBean getListaDocenteBean() {
        return listaDocenteBean;
    }

    public void setListaDocenteBean(ListaDocenteBean listaDocenteBean) {
        this.listaDocenteBean = listaDocenteBean;
    }

    public ListaProfesionalBean getListaProfesionalBean() {
        return listaProfesionalBean;
    }

    public void setListaProfesionalBean(ListaProfesionalBean listaProfesionalBean) {
        this.listaProfesionalBean = listaProfesionalBean;
    }

    public ListaProyectoBean getListaProyectoBean() {
        return listaProyectoBean;
    }

    public void setListaProyectoBean(ListaProyectoBean listaProyectoBean) {
        this.listaProyectoBean = listaProyectoBean;
    }

    public ListaOperacionBean getListaOperacionBean() {
        return listaOperacionBean;
    }

    public void setListaOperacionBean(ListaOperacionBean listaOperacionBean) {
        this.listaOperacionBean = listaOperacionBean;
    }

    public ListaCargoBean getListaCargoBean() {
        return listaCargoBean;
    }

    public void setListaCargoBean(ListaCargoBean listaCargoBean) {
        this.listaCargoBean = listaCargoBean;
    }

    public ListaDedicacionBean getListaDedicacionBean() {
        return listaDedicacionBean;
    }

    public void setListaDedicacionBean(ListaDedicacionBean listaDedicacionBean) {
        this.listaDedicacionBean = listaDedicacionBean;
    }

    public ListaProfesionBean getListaProfesionBean() {
        return listaProfesionBean;
    }

    public void setListaProfesionBean(ListaProfesionBean listaProfesionBean) {
        this.listaProfesionBean = listaProfesionBean;
    }

    public ListaEspecialidadBean getListaEspecialidadBean() {
        return listaEspecialidadBean;
    }

    public void setListaEspecialidadBean(ListaEspecialidadBean listaEspecialidadBean) {
        this.listaEspecialidadBean = listaEspecialidadBean;
    }

    public ListaComisionBean getListaComisionBean() {
        return listaComisionBean;
    }

    public void setListaComisionBean(ListaComisionBean listaComisionBean) {
        this.listaComisionBean = listaComisionBean;
    }

    public UsuarioLogerBean getUsuarioLogerBean() {
        return usuarioLogerBean;
    }

    public void setUsuarioLogerBean(UsuarioLogerBean usuarioLogerBean) {
        this.usuarioLogerBean = usuarioLogerBean;
    }

    public ListaAlumnoBean getListaAlumnoBean() {
        return listaAlumnoBean;
    }

    public void setListaAlumnoBean(ListaAlumnoBean listaAlumnoBean) {
        this.listaAlumnoBean = listaAlumnoBean;
    }

    public ListaCatedraBean getListaCatedraBean() {
        return listaCatedraBean;
    }

    public void setListaCatedraBean(ListaCatedraBean listaCatedraBean) {
        this.listaCatedraBean = listaCatedraBean;
    }

    public ListaCronogramaBean getListaCronogramaBean() {
        return listaCronogramaBean;
    }

    public void setListaCronogramaBean(ListaCronogramaBean listaCronogramaBean) {
        this.listaCronogramaBean = listaCronogramaBean;
    }

    public EnvioMailsBean getEnvioMailsBean() {
        return envioMailsBean;
    }

    public void setEnvioMailsBean(EnvioMailsBean envioMailsBean) {
        this.envioMailsBean = envioMailsBean;
    }

    public ListaEstadoBean getListaEstadoBean() {
        return listaEstadoBean;
    }

    public void setListaEstadoBean(ListaEstadoBean listaEstadoBean) {
        this.listaEstadoBean = listaEstadoBean;
    }



    
    public String entrarFormProyectos_Carrera() {
        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();
         this.getListaCarreraBean().setLstCarreraActiva(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarreraActiva(null);
         this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras_activas();
        

        this.getListaDeptoBean().setLstDepartamento(new ArrayList<Depto>());
        this.getListaDeptoBean().setLstSIDepartamento(null);
        this.getListaDeptoBean().cargar_departamentos();
        this.getListaDeptoBean().cargar_SI_departamentos();

        this.getListaDeptoBean().setLstDepartamentoActivo(new ArrayList<Depto>());
        this.getListaDeptoBean().setLstSIDepartamentoActivo(null);
        this.getListaDeptoBean().cargar_departamentos_activos();
        this.getListaDeptoBean().cargar_SI_departamentos_activos();

        return "cantidad_proyectos_carrera.xhtml?faces-redirect=true";

    }
     public String entrarFormCarrera() {
        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();
         this.getListaCarreraBean().setLstCarreraActiva(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarreraActiva(null);
         this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras_activas();
        

        this.getListaDeptoBean().setLstDepartamento(new ArrayList<Depto>());
        this.getListaDeptoBean().setLstSIDepartamento(null);
        this.getListaDeptoBean().cargar_departamentos();
        this.getListaDeptoBean().cargar_SI_departamentos();

        this.getListaDeptoBean().setLstDepartamentoActivo(new ArrayList<Depto>());
        this.getListaDeptoBean().setLstSIDepartamentoActivo(null);
        this.getListaDeptoBean().cargar_departamentos_activos();
        this.getListaDeptoBean().cargar_SI_departamentos_activos();

        return "carrera.xhtml?faces-redirect=true";

    }
    
    public String entrarFormCatedra() {
        this.getListaCatedraBean().setLstCatedra(new ArrayList<Catedra>());
        this.getListaCatedraBean().setLstSICatedra(null);
        this.getListaCatedraBean().cargar_catedras();
        this.getListaCatedraBean().cargar_SI_catedras();

        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();

        this.getListaCarreraBean().setLstCarreraActiva(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarreraActiva(null);
        this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras_activas();

        return "catedra.xhtml?faces-redirect=true";

    }
     public String entrarFormProyectosInvestigacion() {
        

        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();

        this.getListaCarreraBean().setLstCarreraActiva(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarreraActiva(null);
        this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras_activas();

        return "ProyectosInvestigacion.xhtml?faces-redirect=true";

    }

    public String entrarFormDocente() {

        this.getListaEspecialidadBean().cargar_especialidades();
        this.getListaEspecialidadBean().cargar_SI_especialidades();
        this.getListaProfesionBean().cargar_profesiones();
        this.getListaProfesionBean().cargar_SI_profesiones();
        this.getListaDedicacionBean().cargar_dedicaciones();
        this.getListaDedicacionBean().cargar_SI_dedicaciones();
        this.getListaComisionBean().setLstComisionActiva(new ArrayList<Comision>());
        this.getListaComisionBean().setLstSIComisionActiva(null);
        this.getListaComisionBean().cargar_comisiones_activas();
        this.getListaComisionBean().cargar_SI_comisiones_activas(); 
        this.getListaCatedraBean().setLstCatedraActiva(new ArrayList<Catedra>());
        this.getListaCatedraBean().setLstSICatedraActiva(null);
        this.getListaCatedraBean().cargar_catedras_activas();
        this.getListaCatedraBean().cargar_SI_catedras_activas(); 
        

        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaLocalidadBean().cargarLocalidades();
        this.getListaLocalidadBean().cargarSILocalidades();
        
       this.getListaCarreraBean().cargar_carreras();
       this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras();
        this.getListaCarreraBean().cargar_SI_carreras_activas();

        return "docente.xhtml?faces-redirect=true";
    }

    public String entrarFormPais() {
        this.getListaPaisBean().setLstPais(new ArrayList<Pais>());
        this.getListaPaisBean().setLstSIPais(null);

        return "pais.xhtml?faces-redirect=true";
    }

    public String entrarFormSeguimiento() {
        this.getListaProyectoBean().setLstProyecto(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyecto(null);
        this.getListaProyectoBean().cargar_proyectos();
        this.getListaProyectoBean().cargar_SI_proyectos();
        this.getListaCronogramaBean().setLstCronogramaActividad(new ArrayList<CronogramaActividad>());
        
       

        return "seguimiento_proyecto.xhtml?faces-redirect=true";
    }

    public String entrarFormProvincia() {
        this.getListaPaisBean().setLstPais(new ArrayList<Pais>());
        this.getListaPaisBean().setLstSIPais(null);
        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().setLstProvincia(new ArrayList<Provincia>());
        this.getListaProvinciaBean().setLstSIProvincia(null);

        return "provincia.xhtml?faces-redirect=true";
    }

    public String entrarFormDepartamento() {
        this.getListaPaisBean().setLstPais(new ArrayList<Pais>());
        this.getListaPaisBean().setLstSIPais(null);
        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().setLstProvincia(new ArrayList<Provincia>());
        this.getListaProvinciaBean().setLstSIProvincia(null);
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaDepartamentoBean().setLstDepartamento(new ArrayList<Departamento>());
        this.getListaDepartamentoBean().setLstSIDepartamento(null);

        return "departamento.xhtml?faces-redirect=true";
    }

    public String entrarFormLocalidad() {
        this.getListaPaisBean().setLstPais(new ArrayList<Pais>());
        this.getListaPaisBean().setLstSIPais(null);
        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().setLstProvincia(new ArrayList<Provincia>());
        this.getListaProvinciaBean().setLstSIProvincia(null);
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaDepartamentoBean().setLstDepartamento(new ArrayList<Departamento>());
        this.getListaDepartamentoBean().setLstSIDepartamento(null);
        this.getListaDepartamentoBean().cargarDepartamentos();
        this.getListaDepartamentoBean().cargarSIDepartamentos();
        this.getListaLocalidadBean().setLstLocalidad(new ArrayList<Localidad>());
        this.getListaLocalidadBean().setLstSILocalidad(null);

        return "localidad.xhtml?faces-redirect=true";
    }

    public String entrarFormBarrio() {
        this.getListaPaisBean().setLstPais(new ArrayList<Pais>());
        this.getListaPaisBean().setLstSIPais(null);
        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().setLstProvincia(new ArrayList<Provincia>());
        this.getListaProvinciaBean().setLstSIProvincia(null);
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaDepartamentoBean().setLstDepartamento(new ArrayList<Departamento>());
        this.getListaDepartamentoBean().setLstSIDepartamento(null);
        this.getListaDepartamentoBean().cargarDepartamentos();
        this.getListaDepartamentoBean().cargarSIDepartamentos();
        this.getListaLocalidadBean().setLstLocalidad(new ArrayList<Localidad>());
        this.getListaLocalidadBean().setLstSILocalidad(null);
        this.getListaLocalidadBean().cargarLocalidades();
        this.getListaLocalidadBean().cargarSILocalidades();
        this.getListaBarrioBean().setLstBarrio(new ArrayList<Barrio>());
        this.getListaBarrioBean().setLstSIBarrio(null);

        return "barrio.xhtml?faces-redirect=true";
    }

    public String entrarFormAlumnos() {
        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();
        this.getListaBarrioBean().cargarBarrios();
        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaLocalidadBean().cargarLocalidades();
        this.getListaLocalidadBean().cargarSILocalidades();
           
        this.getListaAlumnoBean().setLstAlumno(new ArrayList<Alumno>());
        this.getListaAlumnoBean().setLstSIAlumno(null);
        this.getListaAlumnoBean().cargar_alumnos();
        this.getListaAlumnoBean().cargar_SI_alumnos();
        

        return "Alumno.xhtml?faces-redirect=true";
    }

    public String entrarFormProyectos() {
        
        this.getListaProyectoBean().setLstProyecto(new ArrayList<Proyecto>());

        this.getListaProyectoBean().cargar_proyectos();

       // this.getListaProyectoBean().setHayCodirector(Boolean.FALSE);
        this.getListaAlumnoBean().setLstAlumno(new ArrayList<Alumno>());
       
        this.getListaAlumnoBean().cargar_alumnos();
        
        this.getListaAlumnoBean().setLstAlumnoFinal(new ArrayList<Alumno>());
        this.getListaAlumnoBean().setLstSIProyectoAlumno(null);
        
        this.getListaAlumnoBean().cargar_proyectos_alumnos();
        this.getListaAlumnoBean().cargar_SI_proyecto_alumno();
        
        this.getListaAlumnoBean().intercambiar();
        

        this.getListaCarreraBean().setLstCarrera(new ArrayList<Carrera>());
        this.getListaCarreraBean().setLstSICarrera(null);
        this.getListaCarreraBean().cargar_carreras();
        this.getListaCarreraBean().cargar_SI_carreras();
        this.getListaCarreraBean().cargar_carreras_activas();
        this.getListaCarreraBean().cargar_SI_carreras_activas();

        this.getListaDocenteBean().setLstDocente(new ArrayList<Docente>());
        this.getListaDocenteBean().setLstSIDocente(null);
        this.getListaDocenteBean().cargar_Docentes();
        this.getListaDocenteBean().cargar_SI_docentes();

        this.getListaProfesionalBean().setLstProfesional(new ArrayList<Profesional>());
        this.getListaProfesionalBean().setLstSIProfesional(null);
        this.getListaProfesionalBean().cargar_profesionales();
        this.getListaProfesionalBean().cargar_SI_profesionales();

        this.getListaProfesionalBean().setLstProfesionalActivo(new ArrayList<Profesional>());
        this.getListaProfesionalBean().setLstSIProfesionalActivo(null);
        this.getListaProfesionalBean().cargar_profesionales_activos();
        this.getListaProfesionalBean().cargar_SI_profesionales_activos();

        this.getListaDocenteBean().setLstDocenteActivo(new ArrayList<Docente>());
        this.getListaDocenteBean().setLstSIDocenteActivo(null);
        this.getListaDocenteBean().cargar_docentes_activos();
        this.getListaDocenteBean().cargar_SI_docentes_activos();
        
       
        
        
        this.getEnvioMailsBean().setCorreos(new String());
        

        return "proyecto.xhtml?faces-redirect=true";
    }

    public String entrarFormPresentacion() {
        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(3, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "nueva_presentacion.xhtml?faces-redirect=true";
    }

    public String entrarFormMisProyectos() {
        this.getListaProyectoBean().setLstProyectoAsesor(new ArrayList<ProyectoAsesor>());
        this.getListaProyectoBean().setLstSIProyectoAsesor(null);
        this.getListaProyectoBean().setLstproyAses(new ArrayList<Proyecto>());
        this.getListaProyectoBean().cargar_proyectos_profesionales(this.usuarioLogerBean.getUsuario().getId(), this.usuarioLogerBean.getUsuario());
        this.getListaProyectoBean().cargar_SI_proyectos_profesionales();

        return "proyectos.xhtml?faces-redirect=true";
    }

    public void entrarFormMiProyecto() {

        this.getListaMisProyectosBean().setProyecto(null);
        try {
            this.getListaMisProyectosBean().setProyecto(this.getListaProyectoBean().cargar_proyectos_alumnos(this.usuarioLogerBean.getUsuario().getId(), this.usuarioLogerBean.getUsuario()));

        } catch (Exception ex) {
            System.out.println("Error al buscar alumnos en proyectoAlumno desde el navegarBean" + ex.toString());
        }
        System.out.println("el unico proyecto al que esta el alumno es" + this.getOperacionBean().getProyecto());
        try {
            this.getListaMisProyectosBean().crear();
        } catch (Exception ex) {
            System.out.println("Error al llamar a crear" + ex.toString());
        }

    }

    public String entrarFormNuevaPresentacionBorrador() {
        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(11, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "nueva_presentacion_borrador.xhtml?faces-redirect=true";
    }

    public String entrarFormAceptacion() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);

           this.getListaProfesionalBean().setLstProfesionalActivo(new ArrayList<Profesional>());
        this.getListaProfesionalBean().setLstSIProfesionalActivo(null);
        this.getListaProfesionalBean().cargar_profesionales_activos();
        this.getListaProfesionalBean().cargar_SI_profesionales_activos();

        this.getListaDocenteBean().setLstDocenteActivo(new ArrayList<Docente>());
        this.getListaDocenteBean().setLstSIDocenteActivo(null);
        this.getListaDocenteBean().cargar_docentes_activos();
        this.getListaDocenteBean().cargar_SI_docentes_activos();
        
        //if(!this.usuarioLogerBean.isAdministracion().equals(true)){
        this.getListaProyectoBean().cargar_proyectosByEstado(1, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "aceptacion_proyecto.xhtml?faces-redirect=true";
    }

    public String entrarFormEvaluacion() {
        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);

        this.getListaProyectoBean().setLstProyectoByTribunal(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByTribunal(null);

        this.getListaProyectoBean().cargarProyectosByDocenteTribunal(this.usuarioLogerBean.getUsuario().getId(), 4L);

        // this.getListaProyectoBean().cargar_proyectosByEstado(4);
        this.getListaProyectoBean().cargar_SI_proyectosbyDocenteTribunal();
        this.getEnvioMailsBean().setCorreos(new String());

        return "evaluacion_proyecto.xhtml?faces-redirect=true";
    }

    public String entrarFormAsiganacionComisionEvaluadora() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);

        this.getListaProyectoBean().cargar_proyectosByEstado(2, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "asignacion_comision_evaluadora.xhtml?faces-redirect=true";

    }

    public String entrarFormBorradoresProyecto() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(5, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "borradores_proyecto.xhtml?faces-redirect=true";

    }

    public String entrarFormEvaluacionBorradoresProyecto() {

      
        
        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);

        this.getListaProyectoBean().setLstProyectoByTribunal(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByTribunal(null);

        this.getListaProyectoBean().cargarProyectosByDocenteTribunal(this.usuarioLogerBean.getUsuario().getId(), 8L);

        // this.getListaProyectoBean().cargar_proyectosByEstado(4);
        this.getListaProyectoBean().cargar_SI_proyectosbyDocenteTribunal();
        //   this.getListaProyectoBean().cargar_proyectosByEstado(8);
        //this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "evaluacion_borradores.xhtml?faces-redirect=true";

    }

    public String entrarFormDefensaFinal() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(9, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "defensa_trabajo_final.xhtml?faces-redirect=true";

    }

    public String entrarFormPresentacionModificacionesProyecto() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(6, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "modificaciones_proyecto.xhtml?faces-redirect=true";

    }

    public String entrarFormPresentacionModificacionesBorrador() {

        this.getListaProyectoBean().setLstProyectoByEstado(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoByEstado(null);
        this.getListaProyectoBean().cargar_proyectosByEstado(10, this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        this.getEnvioMailsBean().setCorreos(new String());

        return "modificaciones_borrador.xhtml?faces-redirect=true";

    }
    
    public String entrarFormCambiarClave() {

      

        return "cambiar_clave.xhtml?faces-redirect=true";

    }

    public String entrarFormProfesional() {

        this.getListaPaisBean().cargarPais();
        this.getListaPaisBean().cargarSIPais();
        this.getListaProvinciaBean().cargarProvincias();
        this.getListaProvinciaBean().cargarSIProvincias();
        this.getListaLocalidadBean().cargarLocalidades();
        this.getListaLocalidadBean().cargarSILocalidades();

        return "Profesional.xhtml?faces-redirect=true";
    }

    public String entrarFormComisiones() {

        this.getListaComisionBean().cargar_comisiones_activas();
        this.getListaComisionBean().cargar_SI_comisiones_activas();

        return "comision.xhtml?faces-redirect=true";
    }
    
    

    public String entrarFormAsentarOperacionProyecto() {

        System.out.println("asdasdasd");

        this.getListaOperacionBean().setLstOperacion(new ArrayList<Operacion>());
        this.getListaOperacionBean().setLstSIOperacion(null);
        this.getListaOperacionBean().cargar_Operaciones();
        this.getListaOperacionBean().cargar_SI_Operaciones();

        this.getListaProyectoBean().setLstProyectoAll(new ArrayList<Proyecto>());
        this.getListaProyectoBean().setLstSIProyectoAll(null);
        this.getListaProyectoBean().cargar_proyectosAll(this.usuarioLogerBean.getUsuario().getId());
        this.getListaProyectoBean().cargar_SI_proyectosAll();

        // this.getListaProyectoBean().cargar_SI_proyectosbyEstado();
        // this.getListaProyectoBean().cargar_proyectosByEstado(3);
        return "operaciones_proyecto.xhtml?faces-redirect=true";
    }

    public String entrarFormAutoridadesInformática() {

        
       // this.getListaProyectoBean().setHayCodirector(Boolean.FALSE);
        this.getListaAlumnoBean().setLstAlumno(new ArrayList<Alumno>());
        this.getListaAlumnoBean().setLstSIAlumno(null);
        this.getListaAlumnoBean().cargar_alumnos();
        this.getListaAlumnoBean().cargar_SI_alumnos();

       
        this.getListaDocenteBean().setLstDocente(new ArrayList<Docente>());
        this.getListaDocenteBean().setLstSIDocente(null);
        this.getListaDocenteBean().cargar_Docentes();
        this.getListaDocenteBean().cargar_SI_docentes();
        
      

      
        

        return "autoridadesDeptoInf.xhtml?faces-redirect=true";
    }
    
    public String entrarFormFechasExamen() {


        return "fechasExamen.xhtml?faces-redirect=true";
    }
    
      public String entrarFormNoticias() {

          this.getListaNoticiasBean().setLstNoticias(new ArrayList<Noticias>());
          this.getListaNoticiasBean().cargarLstNoticias();
        return "imageupload.xhtml?faces-redirect=true";
    }
      
      public String entrarFormEstados() {

          this.getListaEstadoBean().setLstEstado(new ArrayList<Estado>());
          this.getListaEstadoBean().cargar_estados();
        return "estados.xhtml?faces-redirect=true";
    }
      
       public String entrarFormProfesion() {

          this.getListaProfesionBean().setLstProfesion(new ArrayList<Profesion>());
          this.getListaProfesionBean().cargar_profesiones();
        return "profesion.xhtml?faces-redirect=true";
    }
       
        public String entrarFormEspecialidad() {
          this.getListaProfesionBean().setLstSIProfesion(null);
          this.getListaProfesionBean().cargar_SI_profesiones();
          this.getListaEspecialidadBean().setLstEspecialidad(new ArrayList<Especialidad>());
          
          this.getListaEspecialidadBean().cargar_especialidades();
        return "especialidad.xhtml?faces-redirect=true";
    }
}
