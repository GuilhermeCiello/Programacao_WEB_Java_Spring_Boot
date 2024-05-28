package com.uri.progweb.userdep.controllers;

import com.uri.progweb.userdep.entities.Tarefa;
import com.uri.progweb.userdep.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa createTask(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> getAllTasks() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> getTaskById(@PathVariable Long id) {
        return tarefaService.findById(id);
    }

    @PutMapping("/{id}")
    public Tarefa updateTask(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tarefaService.deleteById(id);
    }

    @PutMapping("/{id}/finalize")
    public Tarefa finalizeTask(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.findById(id).orElseThrow();
        tarefa.setFinalizada(true);
        return tarefaService.update(tarefa);
    }
}
