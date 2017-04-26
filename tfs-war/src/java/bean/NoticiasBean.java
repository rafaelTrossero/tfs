/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import RN.NoticiasRNLocal;
import dao.Database;
import entidad.Noticias;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean
@RequestScoped
public class NoticiasBean {

    /**
     * Creates a new instance of NoticiasBean
     */
    @ManagedProperty("#{listaNoticiasBean}")
    private ListaNoticiasBean listaNoticiasBean;
    @ManagedProperty("#{fileUploadController}")
    private FileUploadController fileUploadController;

    private UploadedFile imageFile;
    private Date fechaNotica;
    

    @EJB
    private NoticiasRNLocal noticiasRNlocal;

    private Noticias noticias;

    private CommandButton cbAction;

    public int num;

      private UploadedFile file;
    private byte[] byteData;
    
    public NoticiasBean() {

        this.noticias = new Noticias();
      
        
    }

    public ListaNoticiasBean getListaNoticiasBean() {
        return listaNoticiasBean;
    }

    public void setListaNoticiasBean(ListaNoticiasBean listaNoticiasBean) {
        this.listaNoticiasBean = listaNoticiasBean;
    }

    public Noticias getNoticias() {
        return noticias;
    }

    public void setNoticias(Noticias noticias) {
        this.noticias = noticias;
    }

    public NoticiasRNLocal getNoticiasRNlocal() {
        return noticiasRNlocal;
    }

    public void setNoticiasRNlocal(NoticiasRNLocal noticiasRNlocal) {
        this.noticiasRNlocal = noticiasRNlocal;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = 0;
    }

    public FileUploadController getFileUploadController() {
        return fileUploadController;
    }

    public void setFileUploadController(FileUploadController fileUploadController) {
        this.fileUploadController = fileUploadController;
    }

    public UploadedFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(UploadedFile imageFile) {
        this.imageFile = imageFile;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public byte[] getByteData() {
        return byteData;
    }

    public void setByteData(byte[] byteData) {
        this.byteData = byteData;
    }

    public Date getFechaNotica() {
        return fechaNotica;
    }

    public void setFechaNotica(Date fechaNotica) {
        this.fechaNotica = fechaNotica;
    }

    public void actionBtn() {

        switch (this.getListaNoticiasBean().getiActionBtnSelect()) {
            case 0:
                create();
                //limíar campos
                //this.limpiar();
                break;
            case 1:
                this.edit();
                break;
            case 2:
                //deshabilita el campo
                // this.activate(Boolean.FALSE);
                break;
            case 3:
                //habilita el campo
                // this.activate(Boolean.TRUE);
                break;

        }//fin switch
    }//fin actionBtn

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();
        System.out.println("boton select: " + btnSelect.getId());
    //0 crea
        //1: edit
        //2 delete

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbCreate")) {
            this.getCbAction().setValue("Guardar");
            this.getListaNoticiasBean().setiActionBtnSelect(0);

            //campos requeridos
            //this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbEdit")) {
            this.getCbAction().setValue("Modificar");
            this.getListaNoticiasBean().setiActionBtnSelect(1);

            System.out.println("valor del boton: " + listaNoticiasBean.getiActionBtnSelect());

            //campos requeridos
            // this.setbCamposRequeridos(true);
        } else if (btnSelect.getId().equals("cbDeshabilitado")) {
            this.getListaNoticiasBean().setiActionBtnSelect(2);

            // this.setbCamposEditables(true);
            this.getCbAction().setValue("Desactivar");

        } else if (btnSelect.getId().equals("cbHabilitado")) {
            this.getListaNoticiasBean().setiActionBtnSelect(3);

            //  this.setbCamposEditables(true);
            this.getCbAction().setValue("Reactivar");

        }

        //fin else
    }//fin setBtnSelect

    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        FacesContext context1 = FacesContext.getCurrentInstance();
       
        try {

                          
            
            //noticias.setActive(Boolean.TRUE);
            noticiasRNlocal.create(noticias);
            
           
            
            sMensaje = "El dato fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            this.getCbAction().setDisabled(true);

            //agregar a la lista
            this.getListaNoticiasBean().getLstNoticias().add(noticias);

            //limpiar campos
            this.limpiar();

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgNoticias').hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear

    private void limpiar() {
        this.noticias = new Noticias();
    }

    public void edit() {
        System.out.println("Entro al edit");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //get la fila seleccionada 
            System.out.println("El contenido esssssssssssssssssssssssssssssssssssss" + noticias.getContenido());
            System.out.println("El contenido esssssssssssssssssssssssssssssssssssss" + noticias.getTitulo());
            System.out.println("El contenido esssssssssssssssssssssssssssssssssssss" + noticias.getFecha_agregado());
            noticiasRNlocal.edit(this.getNoticias());

            sMensaje = "Información actualizada con éxito";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego el organismo modificado a la lista
            int iPos = this.getListaNoticiasBean().getLstNoticias().indexOf(this.getNoticias());
            this.getListaNoticiasBean().getLstNoticias().remove(iPos);
            this.getListaNoticiasBean().getLstNoticias().add(iPos, this.getNoticias());

            this.getCbAction().setValue("Modificar");
            this.getCbAction().setDisabled(true);

            //this.setbCamposRequeridos(false);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dlgNoticias.hide()");

        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al actualizar:" + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, "");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }

    public String paginaSig() {
        System.out.println("entro a cambiar pagina1" + num);
        this.num = num + 1;

        System.out.println("entro a cambiar pagina2" + num);

        System.out.println("entr9o a cambiar pagina3" + num);
        return "prueba.xhtml";
    }

    public String paginaAnt() {
        System.out.println("entro a cambiar ant" + num);
        this.num = num - 1;

        System.out.println("entro a cambiar ant" + num);

        System.out.println("entr9o a cambiar ant" + num);
        return "prueba.xhtml";
    }
    
    public void handleFileUploadPhoto(FileUploadEvent event) {
        
         System.out.println("sssssENTRO AL UPLOAD IMAGEN DE  NOTICIAS BEAN" + event.getFile());
         file = event.getFile();
         System.out.println("sssssENTRO AL UPLOAD IMAGEN DE  NOTICIAS BEAN2222222222222222");
        if (file != null) {
            try {
                System.out.println(file.getFileName());
                InputStream fin2 = file.getInputstream();
                Connection con = Database.getConnection();
              //  PreparedStatement pre = con.prepareStatement("insert into noticias (imageNoticia) values(?) where id='" + noticias.getId() + "' ");
                PreparedStatement pre = con.prepareStatement("update noticias set imageNoticia = ? where id=?");
                
                
                pre.setBinaryStream(1, fin2, file.getSize());
                pre.setLong(2, noticias.getId());
                pre.executeUpdate();
               
                System.out.println("Inserting Successfully!");
               // pre.close();
                FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
   public void upload() {
        System.out.println("sssss");
        System.out.println("sssssENTRO AL UPLOAD IMAGEN DE not bean" + file);
       
        
        if (file != null) {
            try {
                System.out.println(file.getFileName());
                InputStream fin2 = file.getInputstream();
                Connection con = Database.getConnection();
                PreparedStatement pre = con.prepareStatement("insert into noticias (titulo,contenido,imageNoticia,fecha_agregado) values(?,?,?,?)");
                 pre.setString(1, noticias.getTitulo());
                 pre.setString(2, noticias.getContenido());
                pre.setBinaryStream(3, fin2, file.getSize());
                pre.setDate(4, sqlDate(noticias.getFecha_agregado()));
                pre.executeUpdate();
                System.out.println("Inserting Successfully!");
                pre.close();
                FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                cargarNoticias();

            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

   
   public java.sql.Date sqlDate(java.util.Date calendarDate) {
  return new java.sql.Date(calendarDate.getTime());
}
   public void cargarNoticias(){
       this.noticias = new Noticias();
       this.getListaNoticiasBean().setLstNoticias(new ArrayList<Noticias>());
       this.getListaNoticiasBean().cargarLstNoticias();
       
   }
    }

