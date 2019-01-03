package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_give_parking_manager_has_parking_boy_a_who_has_parking_lot_a() throws Throwable {
    ParkingLot parkingLotA = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLotA);

    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    ParkingManager parkingManager = new ParkingManager(new ArrayList<>());
    parkingManager.addParkingBoy(parkingBoy);
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

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

    ParkingManager parkingManager = new ParkingManager(new ArrayList<>());
    parkingManager.addParkingBoy(smartParkingBoy);

    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
    assertSame(car, parkingLotA.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_has_a_parking_boy_with_parking_lot_a_and_a_smart_parking_boy_with_parking_lot_b() throws Throwable {
    ParkingLot parkingLotA = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLotsA = new ArrayList<>();
    parkingLotsA.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotsA);

    ParkingLot parkingLotB = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLotsB = new ArrayList<>();
    parkingLotsB.add(parkingLotB);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLotsB);

    ParkingManager parkingManager = new ParkingManager(new ArrayList<>());
    parkingManager.addParkingBoy(smartParkingBoy);
    parkingManager.addParkingBoy(parkingBoy);
    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
    assertSame(car, parkingLotA.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_has_a_parking_boy_with_parking_lot_a_fulled_and_a_smart_parking_boy_with_parking_lot_b()
          throws Throwable {
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLotA.park(new Car());
    ArrayList<ParkingLot> parkingLotsA = new ArrayList<>();
    parkingLotsA.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotsA);

    ParkingLot parkingLotB = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLotsB = new ArrayList<>();
    parkingLotsB.add(parkingLotB);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLotsB);

    ParkingManager parkingManager = new ParkingManager(new ArrayList<>());
    parkingManager.addParkingBoy(smartParkingBoy);
    parkingManager.addParkingBoy(parkingBoy);
    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
    assertSame(car, parkingLotB.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_has_a_parking_boy_with_parking_lot_a_fulled_and_a_smart_parking_boy_with_parking_lot_b_fulled() {
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLotA.park(new Car());
    ArrayList<ParkingLot> parkingLotsA = new ArrayList<>();
    parkingLotsA.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotsA);

    ParkingLot parkingLotB = new ParkingLot(1);
    parkingLotB.park(new Car());
    ArrayList<ParkingLot> parkingLotsB = new ArrayList<>();
    parkingLotsB.add(parkingLotB);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLotsB);

    ParkingManager parkingManager = new ParkingManager(new ArrayList<>());
    parkingManager.addParkingBoy(smartParkingBoy);
    parkingManager.addParkingBoy(parkingBoy);

    Car car = new Car();
    assertThrows(ParkingLotIsFullException.class, () -> parkingManager.park(car));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_does_not_have_parking_boy_to_slave_but_himself() throws Throwable {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLot = new ParkingLot(5);
    parkingLots.add(parkingLot);
    SuperBoy parkingManager = new ParkingManager(parkingLots);

    Car car = new Car();
    Ticket ticket = parkingManager.park(car);
    assertSame(car, parkingLot.pick(ticket));
  }

  @Test
  void should_park_car_to_parking_lot_a_when_parking_manager_park_car_given_parking_manager_has_a_parking_boy_with_parking_lot_a_fulled_and_a_smart_parking_boy_with_parking_lot_b_fulled_and_manager_has_available_parking_lot() {
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLotA.park(new Car());
    ArrayList<ParkingLot> parkingLotsA = new ArrayList<>();
    parkingLotsA.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotsA);

    ParkingLot parkingLotB = new ParkingLot(1);
    parkingLotB.park(new Car());
    ArrayList<ParkingLot> parkingLotsB = new ArrayList<>();
    parkingLotsB.add(parkingLotB);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLotsB);

    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotC = new ParkingLot(2);
    parkingLots.add(parkingLotC);

    ParkingManager parkingManager = new ParkingManager(parkingLots);
    parkingManager.addParkingBoy(smartParkingBoy);
    parkingManager.addParkingBoy(parkingBoy);

    Car car = new Car();

    Ticket ticket = parkingManager.park(car);
    assertSame(car, parkingLotC.pick(ticket));
  }
}
