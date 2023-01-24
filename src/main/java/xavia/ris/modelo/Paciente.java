package xavia.ris.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
  name = "Paciente",
  uniqueConstraints = @UniqueConstraint(columnNames = "nIdentidadP")
)
public class Paciente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String foto;

  @Column(nullable = false, length = 11)
  private String nIdentidadP;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String paisNacimiento;

  @Column(nullable = false)
  private String apellido;

  @Column(nullable = false)
  private String estadoRecidencia;

  @Column(nullable = false)
  private Integer edad;

  @Column(nullable = false)
  private String municipioRecidencia;

  private String ficha;

  @Column(nullable = false)
  private String fechaNacimiento;

  @Column(nullable = false)
  private String sexo;

  private Integer telefono;

  @Column(nullable = false)
  private String direccionActual;

  public Paciente() {}

  public Paciente(
    String foto,
    String nIdentidadP,
    String nombre,
    String paisNacimiento,
    String apellido,
    String estadoRecidencia,
    Integer edad,
    String municipioRecidencia,
    String ficha,
    String fechaNacimiento,
    String sexo,
    Integer telefono,
    String direccionActual
  ) {
    this.foto = foto;
    this.nIdentidadP = nIdentidadP;
    this.nombre = nombre;
    this.paisNacimiento = paisNacimiento;
    this.apellido = apellido;
    this.estadoRecidencia = estadoRecidencia;
    this.edad = edad;
    this.municipioRecidencia = municipioRecidencia;
    this.ficha = ficha;
    this.fechaNacimiento = fechaNacimiento;
    this.sexo = sexo;
    this.telefono = telefono;
    this.direccionActual = direccionActual;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public String getnIdentidadP() {
    return nIdentidadP;
  }

  public void setnIdentidadP(String nIdentidadP) {
    this.nIdentidadP = nIdentidadP;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPaisNacimiento() {
    return paisNacimiento;
  }

  public void setPaisNacimiento(String paisNacimiento) {
    this.paisNacimiento = paisNacimiento;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEstadoRecidencia() {
    return estadoRecidencia;
  }

  public void setEstadoRecidencia(String estadoRecidencia) {
    this.estadoRecidencia = estadoRecidencia;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public String getMunicipioRecidencia() {
    return municipioRecidencia;
  }

  public void setMunicipioRecidencia(String municipioRecidencia) {
    this.municipioRecidencia = municipioRecidencia;
  }

  public String getFicha() {
    return ficha;
  }

  public void setFicha(String ficha) {
    this.ficha = ficha;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Integer getTelefono() {
    return telefono;
  }

  public void setTelefono(Integer telefono) {
    this.telefono = telefono;
  }

  public String getDireccionActual() {
    return direccionActual;
  }

  public void setDireccionActual(String direccionActual) {
    this.direccionActual = direccionActual;
  }
}
