import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JSONArray jsonArray = new JSONArray();

        Persona persona = new Persona("juan", 31, 323132, false);
        Persona persona1 = new Persona("pedro", 42, 53352, true);
        Persona persona2 = new Persona("evaristo", 19, 19231, true);
        //Ejercicio 1
        //jsonArray.put(persona.toJSON());

        //Utilities.grabarUnJson(jsonArray, "persona.json");

        //Ejercicio 2
        /*String contenido = Utilities.leer("persona");
        JSONArray jsonLeido = new JSONArray(contenido);
        ArrayList<Persona> personas = new ArrayList<>();

        for(int i = 0; i < jsonLeido.length(); i++) {
            JSONObject jsonPersona = jsonLeido.getJSONObject(i);
            Persona persona = Persona.fromJSON(jsonPersona);
            personas.add(persona);
        }

        System.out.println("Personas del array");

        for (Persona persona: personas){
            System.out.println(persona);
        } */

        /*Curso curso = new Curso("Python 0 to god", 23123);
        Curso curso2 = new Curso("AWS S3 for developers", 51212);
        curso.agregarPersonas(persona);
        curso2.agregarPersonas(persona1);
        curso2.agregarPersonas(persona2);

        curso2.eliminarPersona("pedro");

        jsonArray.put(curso2.toJSON());
        jsonArray.put(curso.toJSON());
        Utilities.grabarUnJson(jsonArray, "cursos.json");

        String contenido = Utilities.leer("cursos");
        JSONArray jsonLeido = new JSONArray(contenido);
        ArrayList<Curso> cursos = new ArrayList<>();

        for (int i = 0; i < jsonLeido.length(); i++){
            JSONObject jsonCurso = jsonLeido.getJSONObject(i);
            Curso curso1 = Curso.fromJSON(jsonCurso);
            cursos.add(curso1);
        }
        for (Curso c: cursos){
            System.out.println(c);
        }*/



    }
}