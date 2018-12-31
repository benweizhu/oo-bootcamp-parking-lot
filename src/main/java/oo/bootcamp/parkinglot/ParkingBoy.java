package oo.bootcamp.parkinglot;

import java.util.List;
import java.util.function.Supplier;

class ParkingBoy {

  private List<ParkingLot> parkingLots;

  ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  Ticket park(Car car) throws Throwable {
    return this.parkingLots
        .stream()
        .filter(ParkingLot::hasAvailableSlot)
        .findFirst()
        .map(parkingLot -> parkingLot.parking(car))
        .orElseThrow((Supplier<Throwable>) ParkingLotIsFullException::new);
  }

  Car pick(Ticket ticket) throws Throwable {
    return this.parkingLots
        .stream()
        .filter(parkingLot -> parkingLot.hasMyCar(ticket))
        .map(parkingLot -> parkingLot.pick(ticket))
        .findFirst()
        .orElseThrow((Supplier<Throwable>) InvalidTicketException::new);
  }
}
