import org.json.JSONObject;

public class Libro {
    public String nombre;
    private int anio;
    private String autor;

    public Libro() {
    }

    public Libro(String nombre, int anio, String autor) {
        this.nombre = nombre;
        this.anio = anio;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre", nombre);
        jsonObject.put("anio", anio);
        jsonObject.put("autor", autor);
        return jsonObject;
    }

    public static Libro fromJSON(JSONObject jsonObject){
        String nombre = jsonObject.getString("nombre");
        String autor = jsonObject.getString("autor");
        int anio = jsonObject.getInt("anio");
        Libro libro =new Libro(nombre, anio, autor);
        return libro;
    }
}
