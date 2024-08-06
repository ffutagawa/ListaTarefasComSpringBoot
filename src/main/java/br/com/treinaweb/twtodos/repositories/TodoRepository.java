package br.com.treinaweb.twtodos.repositories;

import br.com.treinaweb.twtodos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
