
package src.modelo;

public class DestinoTuristico {
    private int codigo;
    private String nombreLugar;
    private String fechaSalida;
    private double costoPorPersona;
    private String estado;
    private String descripcionGeneral;

    public DestinoTuristico(int codigo, String nombreLugar, String fechaSalida, double costoPorPersona, String estado, String descripcionGeneral) {
        this.codigo = codigo;
        this.nombreLugar = nombreLugar;
        this.fechaSalida = fechaSalida;
        this.costoPorPersona = costoPorPersona;
        this.estado = estado;
        this.descripcionGeneral = descripcionGeneral;
    }
    // Constructor, getters y setters
    
    public DestinoTuristico() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getCostoPorPersona() {
        return costoPorPersona;
    }

    public void setCostoPorPersona(double costoPorPersona) {
        this.costoPorPersona = costoPorPersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }
}

