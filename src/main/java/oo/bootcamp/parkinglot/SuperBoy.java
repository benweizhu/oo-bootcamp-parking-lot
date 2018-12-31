package oo.bootcamp.parkinglot;

import java.util.List;
import java.util.function.Supplier;

abstract class SuperBoy {

  List<ParkingLot> parkingLots;

  SuperBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  Car pick(Ticket ticket) throws Throwable {
    return this.parkingLots
        .stream()
        .filter(parkingLot -> parkingLot.hasMyCar(ticket))
        .map(parkingLot -> parkingLot.pick(ticket))
        .findFirst()
        .orElseThrow((Supplier<Throwable>) InvalidTicketException::new);
  }

  abstract Ticket park(Car car) throws Throwable;
}
