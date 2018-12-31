package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {

  @Test
  void should_return_ticket_when_smart_parking_boy_park_given_parking_lot_a_is_available() throws Throwable {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(2);
    parkingLots.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

    Car car = new Car();

    Ticket ticket = smartParkingBoy.park(car);

    Car pickedCar = parkingLotA.pick(ticket);
    assertNotNull(ticket);
    assertSame(car, pickedCar);
  }
}
