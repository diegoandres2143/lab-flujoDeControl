import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;

public class controlParking {

    public LocalTime pedirHora() {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese la hora (0-23): ");
        int hora = lector.nextInt();
        while (hora > 23 || hora < 0) {
            System.out.println("""
                    Opción inválida
                            Por favor ingrese un valor válido para su hora de llegada:
                            -> Un número entre el 0 y el 23:
                    """);
            hora = lector.nextInt();
        }

        System.out.print("Ingrese los minutos (0-59): ");
        int minutos = lector.nextInt();
        while (minutos > 59 || minutos < 0) {
            System.out.println("""
                    Opción inválida
                            Por favor ingrese un valor válido para su minuto de llegada:
                            -> Un número entre el 0 y el 59:
                    """);
            minutos = lector.nextInt();
        }

        return LocalTime.of(hora, minutos);
    }

    public void compararHoras(LocalTime horaLlegada, LocalTime horaSalida, double precioHora) {
        Duration diferencia = Duration.between(horaLlegada, horaSalida).abs();
        long diferenciaMinutos = diferencia.toMinutes();
        long horas = diferenciaMinutos / 60;
        long minutos = diferenciaMinutos % 60;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        double pagoTotal = (diferenciaMinutos * precioHora) / 60.0;

        String recibo = String.format("""
            Hora de llegada: %s
            Hora de salida: %s
            Tiempo total de servicio: %d horas, %d minutos
            Costo por hora: $%.2f
            Total a pagar: $%.2f
            """,
                horaLlegada.format(formato),
                horaSalida.format(formato),
                horas, minutos, precioHora, pagoTotal
        );

        System.out.println(recibo);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("""
                **************Bienvenido al Sistema de Parqueadero Papitas.org**************
                
                Llene los datos a continuación para ofrecerle un mejor servicio ->
                
                Por favor ingrese su tipo de vehículo:
                1. Auto
                2. Moto
                3. Bicicleta
                """);
        int tipo = lector.nextInt();

        while (tipo > 3 || tipo < 1) {
            System.out.println("""
                    Opción inválida
                            Por favor ingrese su tipo de vehículo:
                            1. Auto
                            2. Moto
                            3. Bicicleta
                    """);
            tipo = lector.nextInt();
        }

        double precioHora = 0; // Declarada antes del switch

        switch (tipo) {
            case 1 -> precioHora = 5000.00;
            case 2 -> precioHora = 2500.00;
            case 3 -> precioHora = 1000.00;
        }

        controlParking util = new controlParking();

        LocalTime horaLlegada = util.pedirHora();
        LocalTime horaSalida = LocalTime.now();

        util.compararHoras(horaLlegada, horaSalida, precioHora);
    }
}
