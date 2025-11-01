import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

public class Curso {
    private String nombreCurso;
    private int codigo;
    private HashSet<Persona> personasInscriptas;

    public Curso() {
        this.personasInscriptas = new HashSet<>();
    }

    public Curso(String nombreCurso, int codigo) {
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.personasInscriptas = new HashSet<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void getPersonas(){
        for (Persona p : personasInscriptas){
            System.out.println('[' + p.getNombre() + ' ' + p.getEdad() + ']');
        }
    }

    public void agregarPersonas(Persona persona) {
        personasInscriptas.add(persona);
    }

    public void eliminarPersona(String nombrePersona) {
        if (nombrePersona == null) {
            throw new IllegalArgumentException("Debe envíar un nombre para ser eliminado");
        }
        try {
            Persona personaEliminada = null;
            for (Persona p : personasInscriptas) {
                if (p.getNombre().equals(nombrePersona)) {
                    personaEliminada = p;
                    break;
                }
            }
            if (personaEliminada != null) {
                personasInscriptas.remove(personaEliminada);
                System.out.println(nombrePersona + " fue eliminado correctamente");
            } else {
                System.out.println("No se encontró a " + nombrePersona);
            }
        } catch (PersonaNoEncontradaException error) {
            throw new PersonaNoEncontradaException("No se pudo eliminar a " + nombrePersona);
        }
    }

    public JSONObject toJSON(){
        JSONObject json = new JSONObject();
        json.put("nombreCurso", nombreCurso);
        json.put("codigo", codigo);
        json.put("personasInscriptas", personasInscriptas);
        return json;
    }

    public static Curso fromJSON(JSONObject jsonObject){
        String nombre = jsonObject.getString("nombreCurso");
        int codigo = jsonObject.getInt("codigo");
        JSONArray personasInscriptas = jsonObject.getJSONArray("personasInscriptas");

        Curso curso = new Curso(nombre, codigo);
        for (int i = 0; i < personasInscriptas.length(); i++){
            JSONObject personaJson = personasInscriptas.getJSONObject(i);
            Persona persona = Persona.fromJSON(personaJson);
            curso.agregarPersonas(persona);
        }
        return curso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombreCurso='" + nombreCurso + '\'' +
                ", codigo=" + codigo +
                ", personasInscriptas=" + personasInscriptas +
                '}';
    }
}
