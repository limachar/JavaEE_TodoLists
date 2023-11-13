package com.example.todoapp.controller;

import com.example.todoapp.model.ToDoItem;
import com.example.todoapp.model.User;
import com.example.todoapp.service.ToDoItemService;
import com.example.todoapp.service.ToDoItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping("/get")
    public String getTestString(){
        return "I GOT it";
    }

    @GetMapping("/user-list")
    public List<ToDoItem> getUserToDoList(@AuthenticationPrincipal User user) {
        // The @AuthenticationPrincipal annotation allows you to access the authenticated user
        String username = user.getUsername();

        // Retrieve the user's to-do list based on the username
        List<ToDoItem> userToDoList = toDoItemService.getToDoListByUser(username);

        return userToDoList;
    }


    @GetMapping("/get-all-items")
    public List<ToDoItem> getAllToDoItems() {
        return toDoItemService.getAllToDoItems();
    }

    @GetMapping("/{id}")
    public ToDoItem getToDoItemById(@PathVariable Long id) {
        return toDoItemService.getToDoItemById(id);
    }

    @PostMapping
    public ToDoItem createToDoItem(@RequestBody ToDoItem toDoItem) {
        return toDoItemService.createToDoItem(toDoItem);
    }

    @PutMapping("/{id}")
    public ToDoItem updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem toDoItem) {
        return toDoItemService.updateToDoItem(id, toDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable Long id) {
        toDoItemService.deleteToDoItem(id);
    }
}
