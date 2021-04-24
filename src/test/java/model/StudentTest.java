package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void shouldGetRegistrationNumberOfStudent() {
        Student student = new Student(0001, "", "");
        assertEquals(1,student.getRegNumber());
    }

    @Test
    void shouldGetClassOfStudent() {
        Student student = new Student(0001, "A", "");
        assertEquals("A",student.getStudClass());
    }


    @Test
    void shouldGetFoodPreferenceOfStudent() {
        Student student = new Student(0001, "", "V");
        assertEquals("V",student.getFoodPreference());
    }

    @Test
    void shouldCheckStudentRegistrationIsDuplicate() {
        Student student = new Student(0002, "A", "V");
        Student anotherStudent = new Student(00002, "A", "V");

        assertEquals(student,anotherStudent);
    }

    @Test
    void shouldCheckStudentRegistrationIsUnique() {
        Student student = new Student(00002, "A", "V");
        Student anotherStudent = new Student(00003, "A", "V");

        assertNotEquals(student,anotherStudent);;
    }
}