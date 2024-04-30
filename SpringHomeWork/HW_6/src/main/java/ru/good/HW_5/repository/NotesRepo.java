package ru.good.HW_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.good.HW_5.domain.Note;

import java.util.Optional;

public interface NotesRepo extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
