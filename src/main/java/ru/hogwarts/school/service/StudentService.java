package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> students;
    private Long id;

    public StudentService() {
        this.students = new HashMap<>();
        this.id = 0L;
    }

    public Student add(String name, int age) {
        Student student = new Student(++id, name, age);
        students.put(student.getId(), student);
        return student;
    }

    public Student get(Long id) {
        return students.get(id);
    }

    public Student update(Student student) {
        if (students.get(student.getId()) == null) return null;
        return students.put(student.getId(), student);
    }

    public Student remove(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getAll() {
        return students.values();
    }

    public Collection<Student> getStudentsByAge (int age) {
        return getAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
