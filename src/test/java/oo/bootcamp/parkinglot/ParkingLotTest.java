package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @Test
    void should_return_ticket_when_parking_a_car_given_parking_lot_is_available() {
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(new Car());

        assertNotNull(ticket);
    }

    @Test
    void should_throw_no_slot_exception_when_parking_a_car_given_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        assertThrows(NoSlotException.class, () -> parkingLot.park(new Car()));
    }
}
