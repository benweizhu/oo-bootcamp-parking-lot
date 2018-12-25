package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
  @Test
  void should_return_ticket_when_parking_boy_park_car_given_parking_lot_A_is_available() {
    ParkingBoy parkingBoy = new ParkingBoy();
    Ticket ticket = parkingBoy.park(new Car());
    assertNotNull(ticket);
  }
}
