package oo.bootcamp.parkinglot.domain;

import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.exception.InvalidTicketException;
import oo.bootcamp.parkinglot.exception.ParkingLotIsFullException;
import oo.bootcamp.parkinglot.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkingable {

  private int numberOfSlot;
  private Map<Ticket, Car> parkedCars = new HashMap<>();

  public ParkingLot(int numberOfSlot) {
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
