package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

import java.io.Console;
import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {

        var salir = false;
        var consola = new Scanner(System.in);
        //
       // IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);

            }catch (Exception e){
                System.out.println("Ocurrio un error : " + e.getMessage());
            }

            System.out.println();

        }//fin de while
    }

    private static void mostrarMenu(){
        System.out.println("""
                ***Catalogo de Peluculas***
                1. Agregar pelicula
                2.Listar peliculas
                3.Buscar pelicula
                4.Salir
                
                ****************************
                
                
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServicioPeliculas servicioPeliculas) {

        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("Itroduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));

            }
            case 2 -> {
                servicioPeliculas.listarPeliculas();
                System.out.println();
            }

            case 3 ->{
                System.out.println("Introduce la pelicula a buscar : ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!");
                salir =true;

            }
            default -> System.out.println("Opcion no se reconocida: " + opcion);


        }
        return salir;

    }

}