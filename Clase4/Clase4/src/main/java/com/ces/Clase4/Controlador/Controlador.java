package com.ces.Clase4.Controlador;
import com.ces.Clase4.Enums.Sede;
import com.ces.Clase4.Enums.Nivel;
import com.ces.Clase4.Modelos.Estudiante;
import com.ces.Clase4.Modelos.Profesor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class Controlador {

    private Stack<Estudiante> DatosEstudiantes() {
        Estudiante e1 = new Estudiante("Paulita Campuzano", Nivel.INTERMEDIO, Sede.ENVIGADO);
        e1.agregarCalificacion(40); e1.agregarCalificacion(20); e1.agregarCalificacion(40);
        e1.agregarCalificacion(45); e1.agregarCalificacion(35);

        Estudiante e2 = new Estudiante("Jenny Echeverri", Nivel.INTERMEDIO, Sede.ENVIGADO);
        e2.agregarCalificacion(25); e2.agregarCalificacion(50); e2.agregarCalificacion(37);
        e2.agregarCalificacion(35); e2.agregarCalificacion(38);

        Estudiante e3 = new Estudiante("Yeison Isaza", Nivel.INTERMEDIO, Sede.ENVIGADO);
        e3.agregarCalificacion(25); e3.agregarCalificacion(35); e3.agregarCalificacion(50);
        e3.agregarCalificacion(28); e3.agregarCalificacion(25);

        Estudiante e4 = new Estudiante("Fredy Bedoya", Nivel.INTERMEDIO, Sede.ENVIGADO);
        e4.agregarCalificacion(40); e4.agregarCalificacion(10); e4.agregarCalificacion(02);
        e4.agregarCalificacion(25); e4.agregarCalificacion(30);

        Estudiante e5 = new Estudiante("Luiza Isaza", Nivel.INTERMEDIO, Sede.ENVIGADO);
        e5.agregarCalificacion(32); e5.agregarCalificacion(42); e5.agregarCalificacion(38);
        e5.agregarCalificacion(15); e5.agregarCalificacion(10);


        Stack<Estudiante> stack = new Stack<>();
        stack.push(e1);
        stack.push(e2);
        stack.push(e3);
        stack.push(e4);
        stack.push(e5);
        return stack;
    }

    // peticion1
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        Stack<Estudiante> jugadores = DatosEstudiantes();

        Profesor profe = new Profesor("Pepito Perez", Nivel.INTERMEDIO, Sede.ENVIGADO, 10);
        Deque<Estudiante> dequeProfesores = new ArrayDeque<>(jugadores);
        profe.setEstudiantes(dequeProfesores);
        model.addAttribute("stack", jugadores);
        model.addAttribute("profe", profe);
        return "peticion1";
    }

    // peticion2
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        Stack<Estudiante> jugadores = DatosEstudiantes();

        List<Estudiante> listaStack = new ArrayList<>();
        ListIterator<Estudiante> itStack = jugadores.listIterator();
        while(itStack.hasNext()){
            listaStack.add(itStack.next());
        }

        Deque<Estudiante> deque = new ArrayDeque<>(jugadores);
        List<Estudiante> listaDeque = new ArrayList<>();
        Iterator<Estudiante> itDeque = deque.iterator();
        while(itDeque.hasNext()){
            listaDeque.add(itDeque.next());
        }

        model.addAttribute("listaStack", listaStack);
        model.addAttribute("listaDeque", listaDeque);
        return "peticion2";
    }

    // peticion3
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        Deque<Estudiante> deque = new ArrayDeque<>(DatosEstudiantes());

        List<String> filtrados = deque.stream()
                .filter(e -> e.getSede() == Sede.ENVIGADO)
                .map(Estudiante::getNombre)
                .collect(Collectors.toList());

        model.addAttribute("filtrados", filtrados);
        return "peticion3";
    }

    // peticion 4 y 5
    @GetMapping("/peticion4y5")
    public String peticion4y5(Model model) {
        Stack<Estudiante> jugadores = DatosEstudiantes();
        Estudiante primero = jugadores.firstElement();

        Function<Estudiante, Integer> sumaTotal = est ->
                est.getCalificaciones().stream().reduce(0, Integer::sum);

        int total = primero.verTotalPuntaje(sumaTotal);
        model.addAttribute("estudiante", primero.getNombre());
        model.addAttribute("resultado", total);
        return "peticion4y5";
    }
}