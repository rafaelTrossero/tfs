/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafaTrossero
 */
@Entity

@NamedQueries({
 @NamedQuery(name = "Usuario.findByUsuarioContrasena", query = "SELECT u FROM Usuario u WHERE u.username =:username AND u.password =:password "),
    @NamedQuery(name = "Usuario.findByUsuarioEmail", query = "SELECT u FROM Usuario u WHERE u.email =:email"),
  
    })
@Table(name="usuario")
public class Usuario  implements Serializable {

   
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final long serialVersionUID = 1L;
    @Column(name = "username", length = 100, nullable = false)
    private String username;
    @Column(name = "password", length = 64, nullable = false)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimiento_clave")
    private Date vencimiento_clave;
     @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private tipoUsuario tipousuario;
    @Column(name = "email", length = 100)
    private String email;
    @OneToOne
    private Grupo grupo;
    @OneToMany(mappedBy = "usuario")
    private List<Auditoria> lstAuditoria;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public tipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(tipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    /**
     *
     * @return
     */
    
    
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Auditoria> getLstAuditoria() {
        return lstAuditoria;
    }

    public void setLstAuditoria(List<Auditoria> lstAuditoria) {
        this.lstAuditoria = lstAuditoria;
    }

    public Date getVencimiento_clave() {
        return vencimiento_clave;
    }

    public void setVencimiento_clave(Date vencimiento_clave) {
        this.vencimiento_clave = vencimiento_clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*@Override
     public int hashCode() {
     int hash = 0;
     hash += (id != null ? id.hashCode() : 0);
     return hash;
     }

     @Override
     public boolean equals(Object object) {
     // TODO: Warning - this method won't work in the case the id fields are not set
     if (!(object instanceof Usuario)) {
     return false;
     }
     Usuario other = (Usuario) object;
     if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
     return false;
     }
     return true;
     }*/
    @Override
    public String toString() {
        return "entidad.Usuario[ id=" + id + " ]";
    }
   
}
