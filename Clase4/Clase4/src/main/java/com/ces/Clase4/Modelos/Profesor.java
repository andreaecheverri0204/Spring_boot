package com.ces.Clase4.Modelos;
import com.ces.Clase4.Enums.Sede;
import com.ces.Clase4.Enums.Nivel;
import java.util.ArrayDeque;
import java.util.Deque;

public class Profesor {
    private String nombre;
    private Nivel nivel;
    private Sede sede;
    private int añosExperiencia;
    private Deque<Estudiante> estudiantes = new ArrayDeque<>();

    public Profesor() {}

    public Profesor(String nombre, Nivel nivel, Sede sede, int añosExperiencia) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.sede = sede;
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Deque<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Deque<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}