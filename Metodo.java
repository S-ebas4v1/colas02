import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Metodo {
    private Queue<Object> dispositivosDisponibles;
    private Queue<Prestamo> prestamosRealizados;

    public Metodo() {
        this.dispositivosDisponibles = new LinkedList<>();
        this.prestamosRealizados = new LinkedList<>();
    }

    public void agregarDispositivo(Object dispositivo) {
        dispositivosDisponibles.offer(dispositivo);
    }

    public void prestarDispositivo(String nombreEstudiante, String carnet, Scanner scanner) {
        if (!dispositivosDisponibles.isEmpty()) {
            System.out.println("Dispositivos disponibles:");
            Queue<Object> dispositivosAuxiliar = new LinkedList<>();
            int contador = 1;

            for (Object dispositivo : dispositivosDisponibles) {
                if (dispositivo instanceof PC && ((PC) dispositivo).isDisponible()) {
                    System.out.println(contador + ". " + ((PC) dispositivo).getTipo() + " - Marca: " + ((PC) dispositivo).getMarca());
                    dispositivosAuxiliar.offer(dispositivo);
                    contador++;
                } else if (dispositivo instanceof Tablet && ((Tablet) dispositivo).isDisponible()) {
                    System.out.println(contador + ". " + ((Tablet) dispositivo).getTipo() + " - Marca: " + ((Tablet) dispositivo).getMarca());
                    dispositivosAuxiliar.offer(dispositivo);
                    contador++;
                }
            }

            if (dispositivosAuxiliar.isEmpty()) {
                System.out.println("No hay dispositivos disponibles para prestamo.");
                return;
            }

            System.out.print("Seleccione el número del dispositivo a prestar: ");
            int selección = scanner.nextInt();

            if (selección >= 1 && selección < contador) {
                Object dispositivoSeleccionado = ((LinkedList<Object>) dispositivosAuxiliar).get(selección - 1);
                Prestamo prestamo = new Prestamo(nombreEstudiante, carnet, dispositivoSeleccionado);
                prestamosRealizados.offer(prestamo);
                if (dispositivoSeleccionado instanceof PC) {
                    ((PC) dispositivoSeleccionado).setDisponible(false);
                } else if (dispositivoSeleccionado instanceof Tablet) {
                    ((Tablet) dispositivoSeleccionado).setDisponible(false);
                }
                System.out.println("prestamo realizado con éxito.");

                Queue<Object> nuevaCola = new LinkedList<>();
                for (Object dispositivo : dispositivosDisponibles) {
                    if (dispositivo != dispositivoSeleccionado) {
                        nuevaCola.offer(dispositivo);
                    }
                }
                dispositivosDisponibles = nuevaCola;

            } else {
                System.out.println("Selección inválida.");
            }

        } else {
            System.out.println("No hay dispositivos disponibles para prestamo.");
        }
    }

    public void devolverDispositivo(String carnet) {
        Queue<Prestamo> colaAuxiliar = new LinkedList<>();
        boolean encontrado = false;

        while (!prestamosRealizados.isEmpty()) {
            Prestamo prestamo = prestamosRealizados.poll();
            if (prestamo.getCarnet().equals(carnet)) {
                Object dispositivo = prestamo.getDispositivo();
                if (dispositivo instanceof PC) {
                    ((PC) dispositivo).setDisponible(true);
                } else if (dispositivo instanceof Tablet) {
                    ((Tablet) dispositivo).setDisponible(true);
                }
                dispositivosDisponibles.offer(dispositivo);
                System.out.println("Dispositivo devuelto con éxito.");
                encontrado = true;
                break;
            } else {
                colaAuxiliar.offer(prestamo);
            }
        }

        while (!colaAuxiliar.isEmpty()) {
            prestamosRealizados.offer(colaAuxiliar.poll());
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún prestamo para el carnet especificado.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de dispositivos:");
        for (Object dispositivo : dispositivosDisponibles) {
            if (dispositivo instanceof PC) {
                PC pc = (PC) dispositivo;
                System.out.println(pc.getTipo() + " - Marca: " + pc.getMarca() + " - Precio: " + pc.getPrecio() + " - Disponible: " + pc.isDisponible());
            } else if (dispositivo instanceof Tablet) {
                Tablet tablet = (Tablet) dispositivo;
                System.out.println(tablet.getTipo() + " - Marca: " + tablet.getMarca() + " - Precio: " + tablet.getPrecio() + " - Disponible: " + tablet.isDisponible());
            }
        }
    }
}