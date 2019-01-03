package oo.bootcamp.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

class SmartParkingBoy extends SuperBoy {

  SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  Ticket park(Car car) {
    return this.parkingLots
        .stream()
        .max(Comparator.comparingInt(ParkingLot::getNumberOfAvailableSlots))
        .orElseThrow((Supplier<RuntimeException>) ParkingLotIsFullException::new)
        .park(car);
  }
}
