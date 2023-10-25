package Model;

import java.util.List;

import Controller.Interface.iGetModel;
import Model.Domain.Student;

public class ModelStudent implements iGetModel {

    private List<Student> students;

    public ModelStudent(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
