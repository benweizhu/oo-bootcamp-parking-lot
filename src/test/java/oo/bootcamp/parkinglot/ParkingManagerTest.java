package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingManagerTest {
  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_give_parking_manager_has_parking_boy_a_who_has_parking_lot_a() throws Throwable {
    ParkingLot parkingLotA = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLotA);

    ArrayList<SuperBoy> parkingBoys = new ArrayList<>();
    parkingBoys.add(new ParkingBoy(parkingLots));

    ParkingManager parkingManager = new ParkingManager(parkingBoys);
    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
    assertSame(car, parkingLotA.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_give_parking_manager_has_smart_parking_boy_a_who_has_parking_lot_a() throws Throwable {
    ParkingLot parkingLotA = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLotA);

    ArrayList<SuperBoy> parkingBoys = new ArrayList<>();
    parkingBoys.add(new SmartParkingBoy(parkingLots));

    ParkingManager parkingManager = new ParkingManager(parkingBoys);
    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
    assertSame(car, parkingLotA.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_has_a_parking_boy_with_parking_lot_a_and_a_smart_parking_boy_with_parking_lot_b() throws Throwable {
      ArrayList<SuperBoy> parkingBoys = new ArrayList<>();

      ParkingLot parkingLotA = new ParkingLot(10);
      ArrayList<ParkingLot> parkingLotsA = new ArrayList<>();
      parkingLotsA.add(parkingLotA);
      parkingBoys.add(new SmartParkingBoy(parkingLotsA));

      ParkingLot parkingLotB = new ParkingLot(10);
      ArrayList<ParkingLot> parkingLotsB = new ArrayList<>();
      parkingLotsB.add(parkingLotB);
      parkingBoys.add(new ParkingBoy(parkingLotsB));

      ParkingManager parkingManager = new ParkingManager(parkingBoys);
      Car car = new Car();
      Ticket ticket = parkingManager.park(car);
      assertNotNull(ticket);
      assertSame(car, parkingLotA.pick(ticket));
  }
}
