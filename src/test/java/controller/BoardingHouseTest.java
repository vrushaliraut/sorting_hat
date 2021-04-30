package controller;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardingHouseTest {

    @Test
    void testShouldDefinedBoardingHouseWithSameCapacity() {
        BoardingHouse boardingHouse = new BoardingHouse(8);
        assertEquals(8, boardingHouse.getCapacity());
    }

    @Test
    void testShouldCreateBoardingHousesWithClassAndFoodPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(8);

        assertEquals(0, boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseAWithNonVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredStudentWithClassAVegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(8);
        Student student = new Student(0001, "A", "V");
        boardingHouse.assignedBoardingHouse(student);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassAVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(8);
        Student student1 = new Student(0001, "A", "V");
        Student student2 = new Student(0002, "A", "NV");
        boardingHouse.assignedBoardingHouse(student1);
        boardingHouse.assignedBoardingHouse(student2);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseAWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassBVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(8);

        Student student1 = new Student(0001, "B", "V");
        Student student2 = new Student(0002, "B", "NV");
        boardingHouse.assignedBoardingHouse(student1);
        boardingHouse.assignedBoardingHouse(student2);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldNotRegisteredStudentForDuplicateEntry() {
        BoardingHouse boardingHouse = new BoardingHouse(8);
        Student student1 = new Student(0001, "B", "V");
        Student student2 = new Student(0001, "B", "NV");
        boardingHouse.assignedBoardingHouse(student1);
        boardingHouse.assignedBoardingHouse(student2);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldReturnFinalOutputWithDifferentBoardingHousesStudents() {
        BoardingHouse boardingHouse = new BoardingHouse(12);
        addSampleCollection(boardingHouse);

        String registeredStudents = boardingHouse.getRegisteredStudents();
        assertEquals("Final Output ::\n" +
                " AV : [1, 2, 3]\n" +
                " ANV : [4, 5, 6]\n" +
                " BV : [7, 8, 9]\n" +
                " BNV : [10, 11, 12]\n" +
                " NA : []", registeredStudents);
    }

    private void addSampleCollection(BoardingHouse boardingHouse) {
        Student student1 = new Student(1, "A", "V");
        Student student2 = new Student(2, "A", "V");
        Student student3 = new Student(3, "A", "V");

        Student student4 = new Student(4, "A", "NV");
        Student student5 = new Student(5, "A", "NV");
        Student student6 = new Student(6, "A", "NV");

        Student student7 = new Student(7, "B", "V");
        Student student8 = new Student(8, "B", "V");
        Student student9 = new Student(9, "B", "V");

        Student student10 = new Student(10, "B", "NV");
        Student student11 = new Student(11, "B", "NV");
        Student student12 = new Student(12, "B", "NV");

        boardingHouse.assignedBoardingHouse(student1);
        boardingHouse.assignedBoardingHouse(student2);
        boardingHouse.assignedBoardingHouse(student3);

        boardingHouse.assignedBoardingHouse(student4);
        boardingHouse.assignedBoardingHouse(student5);
        boardingHouse.assignedBoardingHouse(student6);

        boardingHouse.assignedBoardingHouse(student7);
        boardingHouse.assignedBoardingHouse(student8);
        boardingHouse.assignedBoardingHouse(student9);

        boardingHouse.assignedBoardingHouse(student10);
        boardingHouse.assignedBoardingHouse(student11);
        boardingHouse.assignedBoardingHouse(student12);

    }
}