package com.salah.devoir_3.controller;
import com.salah.devoir_3.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.salah.devoir_3.repository.TaskRepository;
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private  TaskRepository taskRepository;
    @PostMapping("/add")
    public @ResponseBody String addTask(@RequestBody Task task) {
        taskRepository.save(task);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Task getTask(@PathVariable Long id) {
        return taskRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/update/{id}")
    public @ResponseBody String updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task t = taskRepository.findById(id).get();
        t.setName(task.getName());
        t.setRequiredTime(task.getRequiredTime());
        taskRepository.save(t);
        return "Updated";
    }
}
