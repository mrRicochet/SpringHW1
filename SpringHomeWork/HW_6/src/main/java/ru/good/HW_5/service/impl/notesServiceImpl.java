package ru.good.HW_5.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.good.HW_5.domain.Note;
import ru.good.HW_5.repository.NotesRepo;
import ru.good.HW_5.service.NotesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class notesServiceImpl implements NotesService {

    private final NotesRepo notesRepo;
    @Override
    public List<Note> getAllNotes() {
        return notesRepo.findAll();
    }

    @Override
    public Note createNote(Note note) {
        return notesRepo.save(note);
    }

    @Override
    public Note getNoteById(Long id) {
        return notesRepo.findById(id).orElse(null);
    }

    @Override
    public Note updateNote(Long id, String head, String text) {
        Note noteById = getNoteById(id);
        noteById.setHead(head);
        noteById.setText(text);
        return notesRepo.save(noteById);
    }

    @Override
    public void deleteById(Long id) {
        Note noteById =  getNoteById(id);
        notesRepo.delete(noteById);
    }
}
