package modelos;

import java.util.Date;

public class historialConversion {
    private String nombreMoneda;
    private String codigoMoneda;
    private String nombreMonedaConvertir;
    private String codigoMonedaConvertir;
    private double monto;
    private double montoConvertido;
    private double tipoCambio;
    private Date fechaRegistro;

    public historialConversion() {

    }

    public historialConversion(String nombreMoneda, String codigoMoneda, String nombreMonedaConvertir, String codigoMonedaConvertir, double monto, double montoConvertido, double tipoCambio, Date fechaRegistro) {
        this.nombreMoneda = nombreMoneda;
        this.codigoMoneda = codigoMoneda;
        this.nombreMonedaConvertir = nombreMonedaConvertir;
        this.codigoMonedaConvertir = codigoMonedaConvertir;
        this.monto = monto;
        this.montoConvertido = montoConvertido;
        this.tipoCambio = tipoCambio;
        this.fechaRegistro = fechaRegistro;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreMonedaConvertir() {
        return nombreMonedaConvertir;
    }

    public void setNombreMonedaConvertir(String nombreMonedaConvertir) {
        this.nombreMonedaConvertir = nombreMonedaConvertir;
    }

    public String getCodigoMonedaConvertir() {
        return codigoMonedaConvertir;
    }

    public void setCodigoMonedaConvertir(String codigoMonedaConvertir) {
        this.codigoMonedaConvertir = codigoMonedaConvertir;
    }

    @Override
    public String toString() {
        return "{" + "nombreMoneda=" + nombreMoneda +
                            ", codigoMoneda=" + codigoMoneda +
                            ", NombreMonedaConvertir=" + nombreMonedaConvertir +
                            ", CodigoMonedaConvertir=" + codigoMonedaConvertir +
                            ", Monto=" + monto +
                            ", montoConvertido=" + montoConvertido +
                            ", tipoCambio=" + tipoCambio +
                            ", fechaRegistro=" + fechaRegistro + '}';
        //return super.toString ( );
    }
}