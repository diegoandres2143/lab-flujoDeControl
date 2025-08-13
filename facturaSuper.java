import java.util.Scanner;

public class facturaSuper {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("""
                **************Bienvenido al Sistema de Facturación Papitas.org**************
                
                Llene los datos a continuación para ofrecerle un descuento ->
                """);
        System.out.print("1. Por favor ingrese el monto total de su compra: ");
        double monto = lector.nextDouble();

        System.out.print("2. Por favor ingrese la cantidad de productos comprados: ");
        int cantidad = lector.nextInt();

        System.out.println("""
        3. ¿Usted posee una membresía con nuestro supermercado?: 
            1. Sí
            2. No
        """);
        int siNo = lector.nextInt();

        float descuento = 0;

        if (siNo == 1) {
            descuento = descuento + 10;

            if (cantidad > 10) {
                descuento = (descuento + 5);
            }
            monto = (monto * ((100-descuento)/100));
        }

        System.out.println("El descuento total es del: " + String.format("%.2f", descuento) + "%");
        System.out.println("Su nuevo monto a pagar corresponde a: $" + String.format("%.2f", monto));
    }
}

