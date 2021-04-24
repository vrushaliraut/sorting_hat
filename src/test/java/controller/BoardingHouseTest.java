package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardingHouseTest {

    @Test
    void testShouldDefinedBoardingHouseWithSameCapacity() {
        BoardingHouse boardingHouse = new BoardingHouse(25);

        assertEquals(25, boardingHouse.getCapacity());
    }
}