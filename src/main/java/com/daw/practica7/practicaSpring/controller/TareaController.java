package com.daw.practica7.practicaSpring.controller;

import com.daw.practica7.practicaSpring.model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping( "api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>(); // 3.1 Lista en memoria

    public TareaController() {

        tareas.add(new Tarea(1, "Tarea 1", false));
        tareas.add(new Tarea(2, "Tarea 2", false));
        tareas.add(new Tarea(3, "Tarea 3", false));


    }
    @GetMapping
    public List<Tarea> getTareas() {
        return tareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerTarea(@RequestParam int id) {
        return tareas.stream().filter(tarea -> tarea.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }

    @DeleteMapping("/{id}")
    public void eliminarTareas(@RequestBody Tarea tarea) {

        tareas.removeIf(t -> t.getId() == tarea.getId());
    }





}
