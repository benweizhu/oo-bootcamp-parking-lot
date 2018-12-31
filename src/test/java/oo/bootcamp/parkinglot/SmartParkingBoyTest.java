package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  void should_throw_parking_lot_is_full_exception_when_smart_parking_boy_park_given_parking_lot_a_is_full() {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLotA.park(new Car());

    parkingLots.add(parkingLotA);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

    Car car = new Car();

    assertThrows(ParkingLotIsFullException.class, ()-> smartParkingBoy.park(car));
  }

  @Test
  void should_park_car_in_parking_lot_b_when_smart_parking_boy_park_car_given_parking_lot_b_has_more_slots_than_a()
          throws Throwable {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(2);

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
    Car car = new Car();

    Ticket ticket = smartParkingBoy.park(car);
    Car pickedCar = parkingLotB.pick(ticket);

    assertNotNull(ticket);
    assertSame(car, pickedCar);
  }

  @Test
  void should_park_car_in_parking_lot_a_when_smart_parking_boy_park_car_given_parking_lot_b_and_s_has_equal_available()
          throws Throwable {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
    Car car = new Car();

    Ticket ticket = smartParkingBoy.park(car);
    Car pickedCar = parkingLotA.pick(ticket);

    assertNotNull(ticket);
    assertSame(car, pickedCar);
  }

  @Test
  void should_throw_parking_lot_is_full_exception_when_smart_parking_boy_park_car_given_parking_lot_a_and_b_are_full() {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    parkingLotA.park(new Car());
    parkingLotB.park(new Car());

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
    assertThrows(ParkingLotIsFullException.class, ()-> smartParkingBoy.park(new Car()));
  }

  @Test
  void should_throw_invalid_ticket_exception_when_smart_parking_boy_pick_car_given_ticket_not_match() {
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLots.add(parkingLotA);

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

    assertThrows(InvalidTicketException.class, () -> smartParkingBoy.pick(new Ticket()));
  }

    @Test
    void should_throw_invalid_ticket_exception_when_smart_parking_boy_pick_car_given_no_ticket() {
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLots.add(parkingLotA);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        assertThrows(InvalidTicketException.class, () -> smartParkingBoy.pick(null));
    }
}
