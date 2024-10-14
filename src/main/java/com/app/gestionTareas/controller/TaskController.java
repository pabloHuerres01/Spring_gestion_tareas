package com.app.gestionTareas.controller;

import com.app.gestionTareas.model.Task;
import com.app.gestionTareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Método para obtener todas las tareas en formato JSON (API REST)
    @GetMapping(produces = "application/json")
    @ResponseBody // Indica que la respuesta debe ser el cuerpo de la respuesta, no una vista
    public List<Task> getAllTasksApi() {
        return taskService.getAllTasks();
    }

    // Método para obtener todas las tareas en una vista (Thymeleaf)
    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // Nombre de la vista Thymeleaf
    }

    // Método para crear una nueva tarea desde la interfaz web
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks"; // Redirigir después de crear la tarea
    }

    // Método para actualizar una tarea
    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.updateTask(id, task);
        return "redirect:/tasks"; // Redirigir después de actualizar la tarea
    }

    // Método para eliminar una tarea
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks"; // Redirigir después de eliminar la tarea
    }
}
