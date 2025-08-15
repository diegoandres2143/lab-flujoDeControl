import java.util.Scanner;

public class descuentoShop {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        int cantidadCamisa = 0;
        int cantidadPantalon = 0;
        int cantidadChaqueta = 0;
        int continuar = 1;
        double descuento = 0;
        double precioCamisa = 50000;
        double precioPantalon = 90000;
        double precioChaqueta = 120000;


        System.out.print("""
        *************Bienvenido al sistema de Tiendas Papitas.org***********
        
        Para brindarle un mejor servicio por favor responda las siguientes preguntas:
        """);

        while (continuar == 1) {
            System.out.print("""
                    -> Introduzca el tipo prenda que desea comprar:
                        1) Camisa
                        2) Pantalón
                        3) Chaqueta
                    
                    ->""");
            int opcionRopa = lector.nextInt();

            System.out.print("Ingrese la cantidad que desea comprar: ");
            int cantidadPrendas = lector.nextInt();

            switch (opcionRopa) {
                case 1 -> cantidadCamisa = cantidadPrendas;
                case 2 -> cantidadPantalon = cantidadPrendas;
                case 3 -> cantidadChaqueta = cantidadPrendas;
            }

            System.out.println("""
                    ¿Desea continuar comprando prendas?
                    1. Sí
                    2. No
                    ->""");

            continuar = lector.nextInt();
        }

        if (cantidadCamisa + cantidadChaqueta + cantidadPantalon > 5) {
        descuento = 15;
        }

        double precioFinal = ((cantidadCamisa * precioCamisa) + (cantidadPantalon * precioPantalon)
        + (cantidadChaqueta * precioChaqueta));

        double descuentoAplicado = (precioFinal - (precioFinal * ((100 - descuento)/100)));

        String recibo = String.format("""
            ---------------------------Recibo de compra-----------------------------
            
            Productos comprados
            
            Prenda                  Cantidad                 Total
            
            * Camisas               -> %d                    -> %.2f
            * Pantalones            -> %d                    -> %.2f
            * Chaquetas             -> %d                    -> %.2f
            
            Descuento               -> %%%.0f                  -> -%.2f
            
            Total a pagar                                   -> %.2f
            
            
            --------------------------¡Gracias, vuelva pronto!----------------------
            """,
                cantidadCamisa, precioCamisa,
                cantidadPantalon, precioPantalon,
                cantidadChaqueta, precioChaqueta,
                descuento, descuentoAplicado,
                precioFinal
        );

        System.out.println(recibo);

    }
}
