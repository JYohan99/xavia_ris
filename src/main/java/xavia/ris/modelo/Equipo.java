package xavia.ris.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Equipo")
public class Equipo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombreEquipo;

  @Column(nullable = false)
  private String local;

  @Column(nullable = false)
  private String departamento;

  private Boolean compatibleDICOM;

  @Column(nullable = false)
  private String entidadDeApliPACS;

  @Column(nullable = false, length = 15)
  private String direccionIp;

  @Column(nullable = false)
  private String estadoOperacional;

  public Equipo() {}

  public Equipo(
    String nombreEquipo,
    String local,
    String departamento,
    Boolean compatibleDICOM,
    String entidadDeApliPACS,
    String direccionIp,
    String estadoOperacional
  ) {
    this.nombreEquipo = nombreEquipo;
    this.local = local;
    this.departamento = departamento;
    this.compatibleDICOM = compatibleDICOM;
    this.entidadDeApliPACS = entidadDeApliPACS;
    this.direccionIp = direccionIp;
    this.estadoOperacional = estadoOperacional;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombreEquipo() {
    return nombreEquipo;
  }

  public void setNombreEquipo(String nombreEquipo) {
    this.nombreEquipo = nombreEquipo;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public Boolean getCompatibleDICOM() {
    return compatibleDICOM;
  }

  public void setCompatibleDICOM(Boolean compatibleDICOM) {
    this.compatibleDICOM = compatibleDICOM;
  }

  public String getEntidadDeApliPACS() {
    return entidadDeApliPACS;
  }

  public void setEntidadDeApliPACS(String entidadDeApliPACS) {
    this.entidadDeApliPACS = entidadDeApliPACS;
  }

  public String getDireccionIp() {
    return direccionIp;
  }

  public void setDireccionIp(String direccionIp) {
    this.direccionIp = direccionIp;
  }

  public String getEstadoOperacional() {
    return estadoOperacional;
  }

  public void setEstadoOperacional(String estadoOperacional) {
    this.estadoOperacional = estadoOperacional;
  }
}
