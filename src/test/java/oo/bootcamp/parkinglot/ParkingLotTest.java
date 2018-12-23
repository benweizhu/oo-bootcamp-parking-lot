package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void should_return_ticket_when_parking_a_car_given_parking_lot_is_available() {
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.parking(new Car());

        assertNotNull(ticket);
    }

    @Test
    void should_throw_no_slot_exception_when_parking_a_car_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car());

        assertThrows(NoSlotException.class, () -> parkingLot.parking(new Car()));
    }

    @Test
    void should_pick_car_successfully_when_pick_a_car_given_park_exist_and_ticket_match() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car parkedCard = new Car();
        Ticket ticket = parkingLot.parking(parkedCard);

        Car pickedCar = parkingLot.pick(ticket);

        assertEquals(pickedCar, parkedCard);

    }
}
