import java.time.LocalDate;

public class Prestamo {
    private String nombreEstudiante;
    private String carnet;
    private Object dispositivo;
    private LocalDate fechaPrestamo;

    public Prestamo(String nombreEstudiante, String carnet, Object dispositivo) {
        this.nombreEstudiante = nombreEstudiante;
        this.carnet = carnet;
        this.dispositivo = dispositivo;
        this.fechaPrestamo = LocalDate.now();
    }

    public Prestamo() {
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Object getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Object dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    
}