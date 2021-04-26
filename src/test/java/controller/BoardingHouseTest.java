package controller;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(0, boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseAWithNonVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredStudentWithClassAVegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(0001, "A", "V"));
        boardingHouse.assignedBoardingHouse(list);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassAVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(0001, "A", "V"));
        list.add(new Student(0002, "A", "NV"));
        boardingHouse.assignedBoardingHouse(list);

        assertEquals(1, boardingHouse.boardingHouseAWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseAWithNonVeg.size());
    }

    @Test
    void testShouldRegisteredTwoStudentsWithClassBVegAndNonvegPreference() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(0001, "B", "V"));
        list.add(new Student(0002, "B", "NV"));
        boardingHouse.assignedBoardingHouse(list);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(1, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldNotRegisteredStudentForDuplicateEntry() {
        BoardingHouse boardingHouse = new BoardingHouse(25);
        boardingHouse.createBoardingHouses();
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(0001, "B", "V"));
        list.add(new Student(0001, "B", "NV"));
        boardingHouse.assignedBoardingHouse(list);

        assertEquals(1, boardingHouse.boardingHouseBWithVeg.size());
        assertEquals(0, boardingHouse.boardingHouseBWithNonVeg.size());
    }

    @Test
    void testShouldReturnFinalOutputWithDifferentBoardingHousesStudents() {
        BoardingHouse boardingHouse = new BoardingHouse(11);
        boardingHouse.createBoardingHouses();
        ArrayList<Student> students = addSampleCollection();
        boardingHouse.assignedBoardingHouse(students);

        String registeredStudents = boardingHouse.registeredStudents();
        assertEquals("Final Output ::\n" +
                " AV : [1, 2, 3]\n" +
                " ANV : [4, 5, 6]\n" +
                " BV : [7, 8, 9]\n" +
                " BNV :[10, 11, 12]",registeredStudents);
    }

    private ArrayList<Student> addSampleCollection() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", "V"));
        list.add(new Student(2, "A", "V"));
        list.add(new Student(3, "A", "V"));

        list.add(new Student(4, "A", "NV"));
        list.add(new Student(5, "A", "NV"));
        list.add(new Student(6, "A", "NV"));

        list.add(new Student(7, "B", "V"));
        list.add(new Student(8, "B", "V"));
        list.add(new Student(9, "B", "V"));

        list.add(new Student(10, "B", "NV"));
        list.add(new Student(11, "B", "NV"));
        list.add(new Student(12, "B", "NV"));
        return list;
    }
}