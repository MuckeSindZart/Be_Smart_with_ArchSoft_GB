package View;

import java.util.List;

import Controller.Interface.iGetView;
import Model.Domain.Student;

public class ViewStudent implements iGetView {
    public void printAllStudent(List<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}