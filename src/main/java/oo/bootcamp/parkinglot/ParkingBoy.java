package oo.bootcamp.parkinglot;

import java.util.List;
import java.util.function.Supplier;

class ParkingBoy extends SuperBoy {

  ParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  Ticket park(Car car) {
    return this.parkingLots
        .stream()
        .filter(ParkingLot::hasAvailableSlot)
        .findFirst()
        .map(parkingLot -> parkingLot.park(car))
        .orElseThrow((Supplier<RuntimeException>) ParkingLotIsFullException::new);
  }

}
