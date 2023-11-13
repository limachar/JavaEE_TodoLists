package com.example.todoapp.service;

import com.example.todoapp.model.ToDoItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ToDoItemService {


    public List<ToDoItem> getAllToDoItems();

    public ToDoItem getToDoItemById(Long id);

    public ToDoItem createToDoItem(ToDoItem toDoItem);

    public ToDoItem updateToDoItem(Long id, ToDoItem updatedToDoItem);

    public void deleteToDoItem(Long id);

    public List<ToDoItem> getToDoListByUser(String username);
}
