/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidad.rutasArchivos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author RafaTrossero
 */
@ManagedBean(name = "fileUploadController")
@SessionScoped
public class FileUploadController {

    public String destination;
    public String destino = "A";
    private Integer numeroRuta;

    public FileUploadController() {
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumeroRuta() {
        return numeroRuta;
    }

    public void setNumeroRuta(int numeroRuta) {
        this.numeroRuta = numeroRuta;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void upload(FileUploadEvent event) {
        Long numRuta = (Long) event.getComponent().getAttributes().get("numeroRuta"); // 
        obtener_ruta(numRuta.intValue());
        System.out.println("asdasdasdasdwqe32er4wertgtytj65t34r3qwdefrgthy65te" + numRuta);
        FacesMessage msg = new FacesMessage("Exito! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("Nuevo archivo creado!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        destino = destination + fileName;
        System.out.println("la direccion del archivo es + " + destino);
    }

    public void obtener_ruta(Integer i) {
        System.out.println("entro a obtener ruta" + i);
        switch (i) {
            case 1:
                this.setDestination(rutasArchivos.AltaDeProyecto.getName());
                break;
            case 2:
                this.setDestination(rutasArchivos.NuevaPresentacionProyecto.getName());
                break;
            case 3:
                this.setDestination(rutasArchivos.NuevaPresentacionBorrador.getName());
                break;
            case 4:
                this.setDestination(rutasArchivos.ResolucionTribunalEvaluador.getName());
                break;
            case 5:
                this.setDestination(rutasArchivos.Catedras.getName());
                break;
            case 6:
                this.setDestination(rutasArchivos.Borrador.getName());
                break;
            case 7:
                this.setDestination(rutasArchivos.ModificacionesProyecto.getName());
                break;
            case 8:
                this.setDestination(rutasArchivos.ImagenesNoticias.getName());
                break;

        }
    }

}
