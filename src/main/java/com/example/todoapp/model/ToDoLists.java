package com.example.todoapp.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class ToDoLists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany//(mappedBy = "list")
    private List<ToDoItem> toDoItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
