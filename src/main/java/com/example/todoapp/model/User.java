package com.example.todoapp.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany//(mappedBy = "user")
    private List<ToDoLists> toDoLists;

    public String getPassword() {
        return null;
    }

    public void setPassword(String encryptedPassword) {
    }

    public String getUsername() {
        return null;
    }

    public Collection<Object> getRoles() {
        return null;
    }
}