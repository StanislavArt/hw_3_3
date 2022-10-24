package ru.hogwarts.school.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private Map<Long, Faculty> faculties;
    private Long id;

    public FacultyService() {
        this.faculties = new HashMap<>();
        this.id = 0L;
    }

    public Faculty add(String name, String color) {
        Faculty faculty = new Faculty(++id, name, color);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty get(Long id) {
        return faculties.get(id);
    }

    public Faculty update(Faculty faculty) {
        if (faculties.get(faculty.getId()) == null) return null;
        return faculties.put(faculty.getId(), faculty);
    }

    public Faculty remove(Long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> getAll() {
        return faculties.values();
    }

    public Collection<Faculty> getFacultiesByColor (String color) {
        return getAll().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
