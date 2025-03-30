public class Tablet {
    private String marca;
    private double tamaño;
    private double precio;
    private boolean disponible;

    public Tablet(String marca, double tamaño, double precio) {
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.disponible = true;
    }

    public Tablet() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getTipo() { return "Tablet"; }

}