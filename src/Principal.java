import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ClienteAPI clienteAPI = new ClienteAPI();
        UsarJson analizador = new UsarJson();
        ConversorMoneda conversor = new ConversorMoneda();

        String json = clienteAPI.obtenerDatosMoneda();
        JsonObject datos = analizador.convertirAJson(json);

        while (true) {
            Menu.mostrarMenu();
            int opcion = scanner.nextInt();
            if (opcion == 7) break;

            System.out.print("\nIngrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            double resultado = 0.0;
            switch (opcion) {
                case 1 -> resultado = conversor.convertir(monto, analizador.obtenerTasa(datos, "ARS"));
                case 2 -> resultado = monto / analizador.obtenerTasa(datos, "ARS");
                case 3 -> resultado = conversor.convertir(monto, analizador.obtenerTasa(datos, "BRL"));
                case 4 -> resultado = monto / analizador.obtenerTasa(datos, "BRL");
                case 5 -> resultado = conversor.convertir(monto, analizador.obtenerTasa(datos, "COP"));
                case 6 -> resultado = monto / analizador.obtenerTasa(datos, "COP");
                default -> System.out.println("Opción no válida.");
            }

            System.out.println("Resultado: " + resultado);
        }

        System.out.println("¡Gracias por usar el conversor de monedas!");

    }
}
