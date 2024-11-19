package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70));
        snacks.add(new Snack("Bebida", 50));
        snacks.add(new Snack("Completo", 120));
    }

    public  void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public  void mostrarSnacks(){
        var inventarioSnacks = "";
        for(var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("*** INVENTARIO DE SNACKS ***");
        System.out.println(inventarioSnacks);
    }

    public  List<Snack> getSnacks(){
        return snacks;
    }
}
