package controller;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardingHouseTest {

    @Test
    void testShouldDefinedBoardingHouseWithSameCapacity() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        assertEquals(25, boardingHouse.getCapacity());
    }

    @Test
    void testShouldCreateBoardingHousesWithClassAndFoodPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();

        assertEquals(0,boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(0,boardingHouse.boardingHouseAWithNonVeg.size());
        assertEquals(0,boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0,boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredStudentWithClassAVegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        Student student = new Student(0001, "A", "V");
        boardingHouse.assignedBoardingHouse(student);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassAVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        Student student = new Student(0001, "A", "V");
        Student anotherStudent = new Student(0002, "A", "NV");
        boardingHouse.assignedBoardingHouse(student);
        boardingHouse.assignedBoardingHouse(anotherStudent);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseAWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassBVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        Student student = new Student(0001, "B", "V");
        Student anotherStudent = new Student(0002, "B", "NV");
        boardingHouse.assignedBoardingHouse(student);
        boardingHouse.assignedBoardingHouse(anotherStudent);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldNotRegisteredStudentForDuplicateEntry() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        Student student = new Student(0001, "B", "V");
        Student anotherStudent = new Student(0001, "B", "NV");
        boardingHouse.assignedBoardingHouse(student);
        boardingHouse.assignedBoardingHouse(anotherStudent);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithNonVeg.size());
    }
}