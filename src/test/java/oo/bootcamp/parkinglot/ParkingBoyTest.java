package oo.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

  @Test
  void should_return_ticket_when_parking_boy_park_car_given_parking_lot_A_is_available() throws Throwable {
    ParkingLot parkingLot = new ParkingLot(1);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Ticket ticket = parkingBoy.park(new Car());

    assertNotNull(ticket);
  }

  @Test
  void should_return_same_car_when_parking_boy_pick_car_given_correct_ticket() throws Throwable {
    ParkingLot parkingLot = new ParkingLot(1);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);
    Car pickedCar = parkingBoy.pick(ticket);

    assertSame(car, pickedCar);
  }

  @Test
  void should_return_same_car_when_customer_pick_car_given_correct_ticket() throws Throwable {
    ParkingLot parkingLot = new ParkingLot(1);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);
    Car pickedCar = parkingLot.pick(ticket);

    assertSame(car, pickedCar);
  }

  @Test
  void should_return_ticket_when_parking_boy_park_car_given_parking_lot_A_is_full_parking_lot_b_is_available() throws Throwable {
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    parkingLotA.parking(new Car());
    parkingLots.add(parkingLotA);
    ParkingLot parkingLotB = new ParkingLot(1);
    parkingLots.add(parkingLotB);

    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

    assertNotNull(parkingBoy.park(new Car()));
  }

  @Test
  void should_return_same_car_when_parking_boy_pick_car_given_car_parked_in_parking_lot_b() throws Throwable {
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    parkingLotA.parking(new Car());

    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);
    Car pickedCar = parkingBoy.pick(ticket);

    assertSame(car, pickedCar);
  }

  @Test
  void should_return_same_car_when_customer_pick_car_given_car_parked_in_parking_lot_b() throws Throwable {
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    parkingLotA.parking(new Car());

    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car();
    Ticket ticket = parkingBoy.park(car);

    assertSame(car, parkingLotB.pick(ticket));
  }

  @Test
  void should_throw_no_slot_exception_when_parking_boy_park_car_given_parking_lot_a_and_b_both_full(){
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingLot parkingLotA = new ParkingLot(1);
    ParkingLot parkingLotB = new ParkingLot(1);

    parkingLots.add(parkingLotA);
    parkingLots.add(parkingLotB);

    parkingLotA.parking(new Car());
    parkingLotB.parking(new Car());

    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car();
    assertThrows(ParkingLotIsFullException.class, ()-> parkingBoy.park(car));
  }}
