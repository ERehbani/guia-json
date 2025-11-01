import org.json.JSONObject;

public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private boolean sexo;

    public Persona() {
    }

    public Persona(String nombre, int edad, int dni, boolean sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        json.put("nombre", nombre);
        json.put("edad", edad);
        json.put("dni", dni);
        json.put("sexo", sexo);
        return json;
    }

    public static Persona fromJSON(JSONObject jsonObject){
        String nombre = jsonObject.getString("nombre");
        int edad = jsonObject.getInt("edad");
        int dni = jsonObject.getInt("dni");
        boolean sexo = jsonObject.getBoolean("sexo");
        Persona newPersona = new Persona(nombre, edad, dni, sexo);
        return newPersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", sexo=" + sexo +
                '}';
    }
}
