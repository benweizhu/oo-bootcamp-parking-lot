package oo.bootcamp.parkinglot.domain;

import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.exception.ParkingLotIsFullException;
import oo.bootcamp.parkinglot.model.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class SmartParkingBoy extends SuperBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket park(Car car) {
    return this.parkingLots
        .stream()
        .max(Comparator.comparingInt(ParkingLot::getNumberOfAvailableSlots))
        .orElseThrow((Supplier<RuntimeException>) ParkingLotIsFullException::new)
        .park(car);
  }
}
