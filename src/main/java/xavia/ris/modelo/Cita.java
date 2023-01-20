package xavia.ris.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cita {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String procedencia;

  @Column(nullable = false)
  private String fechaCita;

  @Column(nullable = false)
  private String estado;

  @OneToOne
  @JoinColumn
  private Paciente paciente;

  @OneToOne
  private Equipo equipo;

  @OneToOne
  private TipoEstudio tipoEstudio;

  @OneToOne
  private Medico medico;

  public Cita() {}

  public Cita(
    String procedencia,
    String fechaCita,
    String estado,
    Paciente paciente,
    Equipo equipo,
    TipoEstudio tipoEstudio,
    Medico medico
  ) {
    this.procedencia = procedencia;
    this.fechaCita = fechaCita;
    this.estado = estado;
    this.paciente = paciente;
    this.equipo = equipo;
    this.tipoEstudio = tipoEstudio;
    this.medico = medico;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProcedencia() {
    return procedencia;
  }

  public void setProcedencia(String procedencia) {
    this.procedencia = procedencia;
  }

  public String getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(String fechaCita) {
    this.fechaCita = fechaCita;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
  }

  public TipoEstudio getTipoEstudio() {
    return tipoEstudio;
  }

  public void setTipoEstudio(TipoEstudio tipoEstudio) {
    this.tipoEstudio = tipoEstudio;
  }

  public Medico getMedico() {
    return medico;
  }

  public void setMedico(Medico medico) {
    this.medico = medico;
  }
}
