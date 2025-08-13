import java.util.Scanner;

public class clasificacionVeterinaria {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("""
                **************Bienvenido al Sistema de Veterinario Papitas.org**************
                
                Llene los datos a continuación para ofercerle un mejor servicio ->
                
                Por favor ingrese su tipo de mascota:
                1. Perro
                2. Gato
                3. Ave
                4. Otro
                """);
        int tipo = lector.nextInt();

        while (tipo > 4 || tipo < 1){
            System.out.println("""
                    Opción inválida
                            Seleccione un tipo de mascota:
                    
                            1. Perro
                            2. Gato
                            3. Ave
                            4. Otro
                    """);
            tipo = lector.nextInt();
        }


        System.out.print("Por favor ingrese la edad actual de su mascota (en años): ");
        int edad = lector.nextInt();

        switch (tipo) {
            case 1, 2 -> {
                if (edad > 5) {
                    System.out.println("Debido a que su mascota tiene más de 5 años, necesita una vacuna adicional");
                }
                System.out.println("Lo atenderá el veterinario especialista en gatos y perros: El doctor Juan Estaban Lozada Jaramillo");
            }
            case 3 -> System.out.println("Lo atenderá el veterinario especialista en aves: La doctora Lucia Martinez Henao");
            case 4 -> System.out.println("Lo atenderá el veterinario general: El doctor Sebastian Gomez Hurtado");
        }
    }
}

