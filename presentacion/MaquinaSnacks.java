package maquina_snacks_archivos.presentacion;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServicioSnacks;
import maquina_snacks_archivos.servicio.ServicioSnacksLista;
import maquina_snacks_archivos.servicio.ServiciosSnacksArchivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //creamos el objeto para obtener el servicio de snacks
        //IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServiciosSnacksArchivos();
        List<Snack> productos = new ArrayList<>();
        System.out.println("---- Maquina de Snacks ----");
        servicioSnacks.mostrarSnacks();
        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones (opcion, consola, productos,servicioSnacks);
            }catch (Exception e){
                System.out.println("Ocurrio un Error: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar Ticket
                3. Agregar nuevo Snack
                4. Salir
                Elige una opcion: \s""");
        return Integer.parseInt(consola.nextLine());

    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos,IServicioSnacks servicioSnacks){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola, servicioSnacks);
            case 4 -> {
                System.out.println("Saliendo del programa");
                salir = true;
            }
            default -> System.out.println("Opcion invalida.");

        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks){
        System.out.println("¿Que Snack deseas Comprar? (id):");
        var idSnack = Integer.parseInt(consola.nextLine());
        var snackEncontrado = false;
        for(var snack: servicioSnacks.getSnacks()){
            if (idSnack == snack.getIdSnack()){
                productos.add(snack);
                System.out.println("Snack Agregado: "+ snack);
                snackEncontrado = true;
                break;
            }
        }

        if(!snackEncontrado){
            System.out.println("Id de snack no encontrado: "+ idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "*** Ticket de venta ***";

        var total = 0.0;
        for (var producto: productos){
            ticket += "\n\t-"+producto.getNombre()+ " - $"+producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\t Total = $"+ total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola, IServicioSnacks servicioSnacks){
        System.out.println("Nombre del snack: ");
        var nombre = consola.nextLine();
        System.out.println("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu Snack se ha agregado correctamente");
        servicioSnacks.mostrarSnacks();
    }
}
