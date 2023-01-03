package com.spring.Todo.webApp.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {
    public Todo() {
    }

    public Todo(int id, String username, String description, LocalDate date, boolean done) {
        this.Id = id;
        this.username = username;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    @Id
    @GeneratedValue
    private int Id;
    private String username;

    @Size(min = 10 , message = "Enter 10 or more characters")
    private String description;
    private LocalDate date;
    private boolean done;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
