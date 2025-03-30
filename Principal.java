import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Metodo metodos = new Metodo();
        Scanner scanner = new Scanner(System.in);

        int opción;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar dispositivo");
            System.out.println("2. Prestar dispositivo");
            System.out.println("3. Devolver dispositivo");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opción = scanner.nextInt();

            switch (opción) {
                case 1:
                    agregarDispositivo(scanner, metodos);
                    break;
                case 2:
                    prestarDispositivo(scanner, metodos);
                    break;
                case 3:
                    devolverDispositivo(scanner, metodos);
                    break;
                case 4:
                    metodos.mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opción != 5);

        scanner.close();
    }

    private static void agregarDispositivo(Scanner scanner, Metodo metodos) {
        System.out.print("Ingrese el tipo de dispositivo (PC/Tablet): ");
        String tipo = scanner.next();
        if (tipo.equalsIgnoreCase("PC")) {
            System.out.print("Ingrese la señal: ");
            String señal = scanner.next();
            System.out.print("Ingrese la marca: ");
            String marca = scanner.next();
            System.out.print("Ingrese la memoria RAM (GB): ");
            int memoriaRAM = scanner.nextInt();
            System.out.print("Ingrese el disco duro: ");
            String discoDuro = scanner.next();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            metodos.agregarDispositivo(new PC(señal, marca, memoriaRAM, discoDuro, precio));
        } else if (tipo.equalsIgnoreCase("Tablet")) {
            System.out.print("Ingrese la marca: ");
            String marca = scanner.next();
            System.out.print("Ingrese el tamaño (pulgadas): ");
            double tamaño = scanner.nextDouble();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            metodos.agregarDispositivo(new Tablet(marca, tamaño, precio));
        } else {
            System.out.println("Tipo de dispositivo inválido.");
        }
    }

    private static void prestarDispositivo(Scanner scanner, Metodo metodos) {
        System.out.print("Ingrese nombre del estudiante: ");
        String nombre = scanner.next();
        System.out.print("Ingrese carnet del estudiante: ");
        String carnet = scanner.next();
        metodos.prestarDispositivo(nombre, carnet, scanner);
    }

    private static void devolverDispositivo(Scanner scanner, Metodo metodos) {
        System.out.print("Ingrese carnet del estudiante: ");
        String carnet = scanner.next();
        metodos.devolverDispositivo(carnet);
    }
}