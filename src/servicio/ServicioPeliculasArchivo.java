package servicio;

import dominio.Pelicula;

import javax.swing.table.TableRowSorter;
import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }
            else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");

            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir archivo: " + e.getMessage());
        }
    }
    @Override
    public void listarPeliculas() {

        //abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de Peliculas");
            //abrir el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Se lee linea  a liena el archivo
            String linea;
            linea = entrada.readLine();
            //leer todas la lineas disponibles
            while (linea!=null){
                var pelicula  = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de termnar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();

            }
            //cerrar el archivo
            entrada.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());

        }

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{

            //revisar si ya exite el archivo
            anexar = archivo.exists();
            var salida =new PrintWriter(new FileWriter(archivo,anexar));
            //Agregar la pelicula ( to string)
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se agrego al archivo:  "+ pelicula);

        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula: " + e.getMessage());

        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        var archivo = new File(NOMBRE_ARCHIVO);

        try{

            //Abrir el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var pelicualBuscar = pelicula.getNombre();
            while (lineaTexto!= null){
                //Buscar sin importar mausulas y minusculas
                if (pelicualBuscar != null && pelicualBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada=true;
                    break;
                }
                //Leemos la siguiente linea de lasiguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;

            }// fin while
            //se imprime los resultados de la bucqueda
            if (encontrada){
                System.out.println("Pelicula " +lineaTexto + "encontrada - linea  " + indice );
            }else
            {
                System.out.println("No se encontro la pelicula : " + pelicula.getNombre());

            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar en el archivo: " + e.getMessage());

        }
    }
}
