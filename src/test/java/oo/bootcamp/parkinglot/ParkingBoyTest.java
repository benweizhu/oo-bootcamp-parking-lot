package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingBoyTest {

  @Test
  void should_return_ticket_when_parking_boy_park_car_given_parking_lot_A_is_available() {
    ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
    Ticket ticket = parkingBoy.park(new Car());

    assertNotNull(ticket);
  }

  @Test
  void should_return_same_car_when_parking_boy_pick_car_given_correct_ticket() {
    ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);
    Car pickedCar = parkingBoy.pick(ticket);

    assertSame(car, pickedCar);
  }

  @Test
  void should_return_same_car_when_customer_pick_car_given_correct_ticket() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);
    Car pickedCar = parkingLot.pick(ticket);

    assertSame(car, pickedCar);
  }
}
