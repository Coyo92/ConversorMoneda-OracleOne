package modelos;

public class CatMoneda {
    private String nombreMoneda;
    private String codigoMoneda;

    public CatMoneda() {

    }

    public CatMoneda(String nombreMoneda, String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
        this.nombreMoneda = nombreMoneda;

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

    @Override
    public String toString() {
        return "{" + "CodigoMoneda=" + codigoMoneda +
                ", NombreMoneda=" + nombreMoneda +
                '}';
    }
}
