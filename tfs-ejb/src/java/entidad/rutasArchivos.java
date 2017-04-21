/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;



/**
 *
 * @author RafaTrossero
 */
public enum rutasArchivos {
    
   
    AltaDeProyecto("/home/filesTfs/altaDeProyecto/"),
    NuevaPresentacionProyecto("/home/filesTfs/nuevaPresentacionProyecto/"),
    NuevaPresentacionBorrador("/home/filesTfs/nuevaPresentacionBorrador/"),
    ResolucionTribunalEvaluador("/home/filesTfs/resolucionTribunalEvaluador/"),
    Catedras("/home/filesTfs/catedras/"),
    Borrador("/home/filesTfs/borradorProyecto/"),
    ModificacionesProyecto("/home/filesTfs/modificacionesProyecto/"),
    ImagenesNoticias("C:\\filesTFS\\imagenesNoticias\\");
    
  
private String name;

    private rutasArchivos (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
