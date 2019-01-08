package oo.bootcamp.parkinglot.domain;

import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.exception.InvalidTicketException;
import oo.bootcamp.parkinglot.model.Ticket;

import java.util.List;
import java.util.function.Supplier;

abstract class SuperBoy implements Parkingable {

  List<ParkingLot> parkingLots;

  SuperBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  @Override
  public Car pick(Ticket ticket) {
    return this.parkingLots
        .stream()
        .filter(parkingLot -> parkingLot.hasMyCar(ticket))
        .map(parkingLot -> parkingLot.pick(ticket))
        .findFirst()
        .orElseThrow((Supplier<RuntimeException>) InvalidTicketException::new);
  }

  boolean containsCar(Ticket ticket) {
    return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasMyCar(ticket));
  }

  boolean hasAvailableSlots() {
    return this.parkingLots.stream().anyMatch(ParkingLot::hasAvailableSlot);
  }

}
