package oo.bootcamp.parkinglot.domain;

import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.exception.ParkingLotIsFullException;
import oo.bootcamp.parkinglot.model.Ticket;

import java.util.List;
import java.util.function.Supplier;

public class ParkingBoy extends SuperBoy {

  public ParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public Ticket park(Car car) {
    return this.parkingLots
        .stream()
        .filter(ParkingLot::hasAvailableSlot)
        .findFirst()
        .map(parkingLot -> parkingLot.park(car))
        .orElseThrow((Supplier<RuntimeException>) ParkingLotIsFullException::new);
  }

}
