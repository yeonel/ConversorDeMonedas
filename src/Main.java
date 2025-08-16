import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        ConversorMonedas conversor = new ConversorMonedas(apiService);
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. USD → EUR");
            System.out.println("2. USD → PEN");
            System.out.println("3. EUR → USD");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                continuar = false;
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            try {
                double resultado = 0.0;
                switch (opcion) {
                    case 1 -> resultado = conversor.convertir("USD", "EUR", cantidad);
                    case 2 -> resultado = conversor.convertir("USD", "PEN", cantidad);
                    case 3 -> resultado = conversor.convertir("EUR", "USD", cantidad);
                    default -> System.out.println("Opción inválida");
                }
                if (resultado != 0.0) {
                    System.out.println("Resultado: " + resultado);
                }
            } catch (Exception e) {
                System.out.println("Error en la conversión: " + e.getMessage());
            }
        }
    }
}

