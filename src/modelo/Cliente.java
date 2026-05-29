package modelo;

public class Cliente {
    private String RUC;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;
    // Asociación con Rubro
    private Rubro rubro;
    // Arreglo de Ofertas (Composición)
    private Oferta[] ofertas;
    private int totalOfertas;

    public Cliente(String RUC, String razonSocial, String email, String contacto, String telefono, String clave, Rubro rubro) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.rubro = rubro;
        this.ofertas = new Oferta[50]; // Capacidad para 50 ofertas
        this.totalOfertas = 0;
    }

    public boolean agregarOferta(Oferta oferta) {
        if (totalOfertas < ofertas.length) {
            ofertas[totalOfertas] = oferta;
            totalOfertas++;
            return true;
        }
        return false;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < totalOfertas; i++) {
            if (ofertas[i] == oferta) {
                ofertas[i] = null; // Lógica simple de eliminación
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        return ofertas;
    }

    // Getters y Setters
    public String getRUC() { return RUC; }
    public void setRUC(String RUC) { this.RUC = RUC; }
    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public Rubro getRubro() { return rubro; }
    public void setRubro(Rubro rubro) { this.rubro = rubro; }
}