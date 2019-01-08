package oo.bootcamp.parkinglot;

import oo.bootcamp.parkinglot.domain.ParkingLot;
import oo.bootcamp.parkinglot.exception.InvalidTicketException;
import oo.bootcamp.parkinglot.exception.ParkingLotIsFullException;
import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.model.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    assertThrows(ParkingLotIsFullException.class, () -> parkingLot.park(new Car()));
  }

  @Test
  void should_pick_car_successfully_when_pick_a_car_given_park_exist_and_ticket_match() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    Ticket ticket = parkingLot.park(car);

    Car pickedCar = parkingLot.pick(ticket);

    assertEquals(pickedCar, car);
  }

  @Test
  void should_throw_pick_car_failed_exception_when_pick_a_car_given_no_ticket() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    parkingLot.park(car);

    assertThrows(InvalidTicketException.class, () -> parkingLot.pick(null));
  }

  @Test
  void should_throw_pick_car_failed_exception_when_pick_a_car_given_ticket_not_match_car() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    parkingLot.park(car);

    assertThrows(InvalidTicketException.class, () -> parkingLot.pick(new Ticket()));
  }

  @Test
  void should_park_car_successfully_when_park_a_car_given_is_full_and_a_car_leave() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    Ticket ticket = parkingLot.park(car);
    parkingLot.pick(ticket);
    Car myCar = new Car();

    assertNotNull(parkingLot.park(myCar));
  }
}
