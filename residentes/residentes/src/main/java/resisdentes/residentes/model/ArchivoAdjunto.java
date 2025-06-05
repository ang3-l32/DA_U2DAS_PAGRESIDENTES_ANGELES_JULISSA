package resisdentes.residentes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "archivo_adjunto")
public class ArchivoAdjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] archivo;

    @ManyToOne
    @JoinColumn(name = "actividad_id")
    private Actividad actividad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public byte[] getArchivo() { return archivo; }
    public void setArchivo(byte[] archivo) { this.archivo = archivo; }

    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}
