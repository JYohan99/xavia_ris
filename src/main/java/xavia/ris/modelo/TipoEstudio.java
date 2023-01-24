package xavia.ris.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoEstudio implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String sistemaOrganico;

  private String tipoTecnica;

  private String localizacionAnatomica;

  private String calificatorio;

  private String nombreComun;

  private String nombreDICOM;

  private String observaciones;

  private String modalidad;

  private Boolean consPeliRadiog;

  public TipoEstudio() {}

  public TipoEstudio(
    Long id,
    String sistemaOrganico,
    String tipoTecnica,
    String localizacionAnatomica,
    String calificatorio,
    String nombreComun,
    String nombreDICOM,
    String observaciones,
    String modalidad,
    Boolean consPeliRadiog
  ) {
    this.id = id;
    this.sistemaOrganico = sistemaOrganico;
    this.tipoTecnica = tipoTecnica;
    this.localizacionAnatomica = localizacionAnatomica;
    this.calificatorio = calificatorio;
    this.nombreComun = nombreComun;
    this.nombreDICOM = nombreDICOM;
    this.observaciones = observaciones;
    this.modalidad = modalidad;
    this.consPeliRadiog = consPeliRadiog;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSistemaOrganico() {
    return sistemaOrganico;
  }

  public void setSistemaOrganico(String sistemaOrganico) {
    this.sistemaOrganico = sistemaOrganico;
  }

  public String getTipoTecnica() {
    return tipoTecnica;
  }

  public void setTipoTecnica(String tipoTecnica) {
    this.tipoTecnica = tipoTecnica;
  }

  public String getLocalizacionAnatomica() {
    return localizacionAnatomica;
  }

  public void setLocalizacionAnatomica(String localizacionAnatomica) {
    this.localizacionAnatomica = localizacionAnatomica;
  }

  public String getCalificatorio() {
    return calificatorio;
  }

  public void setCalificatorio(String calificatorio) {
    this.calificatorio = calificatorio;
  }

  public String getNombreComun() {
    return nombreComun;
  }

  public void setNombreComun(String nombreComun) {
    this.nombreComun = nombreComun;
  }

  public String getNombreDICOM() {
    return nombreDICOM;
  }

  public void setNombreDICOM(String nombreDICOM) {
    this.nombreDICOM = nombreDICOM;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getModalidad() {
    return modalidad;
  }

  public void setModalidad(String modalidad) {
    this.modalidad = modalidad;
  }

  public Boolean getConsPeliRadiog() {
    return consPeliRadiog;
  }

  public void setConsPeliRadiog(Boolean consPeliRadiog) {
    this.consPeliRadiog = consPeliRadiog;
  }
}
