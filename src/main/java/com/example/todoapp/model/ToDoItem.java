package com.example.todoapp.model;

import jakarta.persistence.*;

@Entity
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ToDoLists List;

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
