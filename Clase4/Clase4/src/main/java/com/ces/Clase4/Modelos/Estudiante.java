package com.ces.Clase4.Modelos;
import com.ces.Clase4.Enums.Sede;
import com.ces.Clase4.Enums.Nivel;
import java.util.Stack;
import java.util.function.Function;

public class Estudiante {
    private String nombre;
    private Nivel nivel;
    private Sede sede;
    private Stack<Integer> calificaciones = new Stack<>();

    public Estudiante() {}

    public Estudiante(String nombre, Nivel nivel, Sede sede) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.sede = sede;
    }

    public void agregarCalificacion(Integer nota) {

        this.calificaciones.push(nota);
    }

    public int verTotalPuntaje(Function<Estudiante, Integer> funcionSuma) {

        return funcionSuma.apply(this);
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Nivel getNivel() {

        return nivel;
    }

    public void setNivel(Nivel nivel) {

        this.nivel = nivel;
    }

    public Sede getSede() {

        return sede;
    }

    public void setSede(Sede sede) {

        this.sede = sede;
    }

    public Stack<Integer> getCalificaciones() {

        return calificaciones;
    }

}
