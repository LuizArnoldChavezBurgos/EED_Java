
package src.modelo;

public class Cliente {
    private int codigo;
    private String nombreCompleto;
    private String identificacion;
    private String contraseña;
    private String correoElectronico;

    public Cliente(int codigo, String nombreCompleto, String identificacion, String contraseña, String correoElectronico) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
    }
    
    public Cliente(int codigo, String nombreCompleto, String identificacion, String correoElectronico) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
    }

    public Cliente() {
    }

    // Getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}

