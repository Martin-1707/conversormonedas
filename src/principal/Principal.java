package principal;

import calculos.MonedaConsultar;
import calculos.MonedaConvertir;


import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        MonedaConsultar consulta = new MonedaConsultar();

        System.out.println("~~~~~~~~~~Conversor de Monedas~~~~~~~~~~");

        int option = 0;

        while (option != 9) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\n"+
                    "Ingrese la conversion de moneda que desea realizar\n\n"+
                    "1. Dolar estadounidense a Peso argentino\n"+
                    "2. Peso argentino a Dolar estadounidense\n"+
                    "3. Peso chileno a Boliviano boliviano\n"+
                    "4. Boliviano boliviano a Peso chileno\n"+
                    "5. Real brasileño a Peso colombiano\n"+
                    "6. Peso colombiano a Real brasileño\n"+
                    "7. Convertir otra moneda diferente\n"+
                    "8. Mostrar historial de conversion\n"+
                    "9. Salir\n"+
                    "~~~~~~~~~~~~~~~~~~~~~~~~");
            option = lectura.nextInt();
            lectura.nextLine();
            switch (option) {
                case 1:
                    MonedaConvertir.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    MonedaConvertir.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    MonedaConvertir.convertir("CLP", "BOB", consulta, lectura);
                    break;
                case 4:
                    MonedaConvertir.convertir("BOB", "CLP", consulta, lectura);
                    break;
                case 5:
                    MonedaConvertir.convertir("BRL", "COP", consulta, lectura);
                    break;
                case 6:
                    MonedaConvertir.convertir("COP", "BRL", consulta, lectura);
                    break;
                case 7:
                    MonedaConvertir.convertirOtraMoneda(consulta, lectura);
                    break;
                case 8:
                    MonedaConvertir.verhistorialDeConversion(lectura);
                    break;
                case 9:
                    System.out.println("Gracias por elegirnos, vuelva pronto :b ... Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
}
