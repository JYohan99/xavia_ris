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
  uniqueConstraints = @UniqueConstraint(columnNames = "nIdentidadM")
)
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String foto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String sexo;

    private Integer telefono;

    @Column(nullable = false, length = 11)
    private String nIdentidadM;

    @Column(nullable = false)
    private String direccionActual;

    public Medico() {}

    public Medico(String foto, String nombre, String especialidad, String apellido, Integer edad, String sexo,
        Integer telefono, String nIdentidadM, String direccionActual) {
      this.foto = foto;
      this.nombre = nombre;
      this.especialidad = especialidad;
      this.apellido = apellido;
      this.edad = edad;
      this.sexo = sexo;
      this.telefono = telefono;
      this.nIdentidadM = nIdentidadM;
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

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getEspecialidad() {
      return especialidad;
    }

    public void setEspecialidad(String especialidad) {
      this.especialidad = especialidad;
    }

    public String getApellido() {
      return apellido;
    }

    public void setApellido(String apellido) {
      this.apellido = apellido;
    }

    public Integer getEdad() {
      return edad;
    }

    public void setEdad(Integer edad) {
      this.edad = edad;
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

    public String getnIdentidadM() {
      return nIdentidadM;
    }

    public void setnIdentidadM(String nIdentidadM) {
      this.nIdentidadM = nIdentidadM;
    }

    public String getDireccionActual() {
      return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
      this.direccionActual = direccionActual;
    }

  
}
