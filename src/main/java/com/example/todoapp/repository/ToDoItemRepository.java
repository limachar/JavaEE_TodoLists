package com.example.todoapp.repository;

import com.example.todoapp.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
