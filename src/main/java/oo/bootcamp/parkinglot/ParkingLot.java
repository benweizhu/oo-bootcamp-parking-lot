package oo.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

class ParkingLot implements Parkingable{

  private int numberOfSlot;
  private Map<Ticket, Car> parkedCars = new HashMap<>();

  ParkingLot(int numberOfSlot) {
    this.numberOfSlot = numberOfSlot;
  }

  @Override
  public Ticket park(Car car) {
    if (!hasAvailableSlot()) {
      throw new ParkingLotIsFullException();
    }
    Ticket ticket = new Ticket();
    parkedCars.put(ticket, car);
    return ticket;
  }

  boolean hasAvailableSlot() {
    return this.numberOfSlot > parkedCars.size();
  }

  @Override
  public Car pick(Ticket ticket) {
    if (!hasMyCar(ticket)) {
      throw new InvalidTicketException();
    }
    return parkedCars.remove(ticket);
  }

  boolean hasMyCar(Ticket ticket) {
    return parkedCars.containsKey(ticket);
  }

  int getNumberOfAvailableSlots() {
    return this.numberOfSlot - parkedCars.size();
  }
}
