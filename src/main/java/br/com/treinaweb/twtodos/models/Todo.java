package br.com.treinaweb.twtodos.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = true)
    private LocalDate fineshedAt;

    public Todo(){
        this.createdAt = LocalDateTime.now();
    }

    public Todo(Long id, String title, LocalDateTime createdAt, LocalDate deadline, LocalDate fineshedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.fineshedAt = fineshedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getFineshedAt() {
        return fineshedAt;
    }

    public void setFineshedAt(LocalDate fineshedAt) {
        this.fineshedAt = fineshedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
