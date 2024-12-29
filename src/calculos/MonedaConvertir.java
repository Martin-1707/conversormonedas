package calculos;

import model.MonedaDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonedaConvertir {

    public static List<String> historial = new ArrayList<>();

    public static void convertir(String monedaBase, String monedaTarget, MonedaConsultar consulta, Scanner lectura) {

        double cantidad = 0;
        double CantidadConvertida = 0;

        MonedaDTO moneda = consulta.buscarMoneda(monedaBase, monedaTarget);
        System.out.println("El tipo de cambio de hoy " + LocalDate.now() + " es: 1 " + monedaBase + " = " + moneda.conversion_rate() + " " + monedaTarget);
        System.out.println("Ingrese la cantidad a convertir de " + monedaBase + ": ");
        try {
            cantidad = Double.parseDouble(lectura.nextLine());
            CantidadConvertida = cantidad * moneda.conversion_rate();

            String entradaHistorial = cantidad + " " + monedaBase + " = " + CantidadConvertida + " " + monedaTarget;
            historial.add(entradaHistorial);

        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un numero valido");
            return;
        }

        System.out.println( cantidad + " " + monedaBase + " = " + CantidadConvertida + " " + monedaTarget);
        System.out.println("\nPresiona Enter para continuar...");
        lectura.nextLine();
    }

    public static void convertirOtraMoneda(MonedaConsultar consulta, Scanner lectura) {
        try {

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n");

            System.out.println("Obteniendo códigos de moneda disponibles...");
            List<String> codigos = consulta.obtenerCodigosMoneda();

            System.out.println("Códigos de moneda soportados:");
            for (String codigo : codigos) {
                System.out.println("- " + codigo);
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n");

            System.out.println("Ingrese el codigo de la moneda base: ");
            String monedaBase = lectura.nextLine().toUpperCase();

            System.out.println("Ingrese el codigo de la moneda a cambiar: ");
            String monedaCambio = lectura.nextLine().toUpperCase();

            convertir(monedaBase, monedaCambio, consulta, lectura);

            } catch (Exception e) {
        System.out.println("Error al obtener los códigos de moneda: " + e.getMessage());
        }

    }

    public static void verhistorialDeConversion(Scanner lectura) {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("Historial de conversiones:");
            for (String entrada : historial) {
                System.out.println(entrada);
            }
        }
        System.out.println("\nPresiona Enter para continuar...");
        lectura.nextLine();
    }
}