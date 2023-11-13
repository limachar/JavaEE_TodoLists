package com.example.todoapp.service;

import com.example.todoapp.model.ToDoItem;
import com.example.todoapp.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemServiceImpl implements ToDoItemService{


    private final ToDoItemRepository toDoItemRepository;

    @Autowired
    public ToDoItemServiceImpl(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> getAllToDoItems() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem getToDoItemById(Long id) {
        return toDoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not find with ID: " + id));
    }

    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItem updateToDoItem(Long id, ToDoItem updatedToDoItem) {
        ToDoItem existingToDoItem = getToDoItemById(id);
        existingToDoItem.setCompleted(updatedToDoItem.isCompleted());
        return toDoItemRepository.save(existingToDoItem);
    }

    public void deleteToDoItem(Long id) {
        toDoItemRepository.deleteById(id);
    }

    public List<ToDoItem> getToDoListByUser(String username) {
        return null;
    }
}
