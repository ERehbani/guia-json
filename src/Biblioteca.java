import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.libros = new ArrayList<>();
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public void agregarLibros(Libro libro){
        libros.add(libro);
    }

    public void eliminarLibros(String nombreLibro){
        if(nombreLibro == null){
            System.out.println("Se debe envíar un nombre de libro para que se elimine");
        }
        try {
            Libro libroEliminado = null;
            for (Libro libro: libros){
                if(libro.getNombre().equals(nombreLibro)){
                    libroEliminado = libro;
                    break;
                }
            }
            if(libroEliminado != null){
                libros.remove(libroEliminado);
                System.out.println("El libro: " + nombreLibro + " ha sido eliminado correctamente");
            } else {
                System.out.println("No se encontró " + nombreLibro);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("nombreBiblioteca", nombreBiblioteca);
        json.put("libros", libros);
        return json;
    }

    public static Biblioteca fromJSON(JSONObject jsonObject){
        String nombre = jsonObject.getString("nombreBiblioteca");
        JSONArray libros = jsonObject.getJSONArray("libros");

        Biblioteca biblioteca = new Biblioteca(nombre);

        for(int i = 0; i < libros.length(); i++){
            JSONObject libroJson = libros.getJSONObject(i);
            Libro libro = Libro.fromJSON(libroJson);
            biblioteca.agregarLibros(libro);
        }
        return biblioteca;
    }
}
