package modelo;
import java.util.Date;

public class Postulante {
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    // Asociación
    private GradoEstudio gradoEstudio;
    // Arreglo de Postulaciones (Composición)
    private Postulacion[] postulaciones;
    private int totalPostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, Date nacimiento, String clave) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        this.postulaciones = new Postulacion[50];
        this.totalPostulaciones = 0;
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {
        this.gradoEstudio = grado;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (totalPostulaciones < postulaciones.length) {
            postulaciones[totalPostulaciones] = new Postulacion(new Date(), oferta);
            totalPostulaciones++;
            return true;
        }
        return false;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        for (int i = 0; i < totalPostulaciones; i++) {
            if (postulaciones[i] == postulacion) {
                postulaciones[i].setAnulado(true);
                postulaciones[i].setFechaAnulacion(new Date());
                return true;
            }
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        return postulaciones;
    }

    // Getters y Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Date getNacimiento() { return nacimiento; }
    public void setNacimiento(Date nacimiento) { this.nacimiento = nacimiento; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public GradoEstudio getGradoEstudio() { return gradoEstudio; }
}