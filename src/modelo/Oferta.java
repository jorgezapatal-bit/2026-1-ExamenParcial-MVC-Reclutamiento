package modelo;
import java.util.Date;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;
    // Arreglo de Requisitos (Composición)
    private Requisito[] requisitos;
    private int totalRequisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new Requisito[20]; // Máximo 20 requisitos por oferta
        this.totalRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (totalRequisitos < requisitos.length) {
            requisitos[totalRequisitos] = new Requisito(orden, descripcion, true);
            totalRequisitos++;
            return true;
        }
        return false;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < totalRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                requisitos[i].deshabilitar();
                return true;
            }
        }
        return false;
    }

    public Requisito[] getRequisitos() {
        return requisitos;
    }

    // Getters y Setters básicos
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public Date getFechaTermino() { return fechaTermino; }
    public void setFechaTermino(Date fechaTermino) { this.fechaTermino = fechaTermino; }
}