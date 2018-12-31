package oo.bootcamp.parkinglot;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket park(Car car) throws Throwable {
    return this.parkingLots
        .stream()
        .map(parkingLot -> getTicket(car, parkingLot))
        .filter(Objects::nonNull)
        .findAny()
        .orElseThrow((Supplier<Throwable>) ParkingLotIsFullException::new);
  }

  private Ticket getTicket(Car car, ParkingLot parkingLot) {
    try {
      return parkingLot.parking(car);
    } catch (ParkingLotIsFullException e) {
      return null;
    }
  }

  public Car pick(Ticket ticket) throws Throwable {
    return this.parkingLots
        .stream()
        .map(parkingLot -> getCar(ticket, parkingLot))
        .filter(Objects::nonNull)
        .findAny()
        .orElseThrow((Supplier<Throwable>) InvalidTicketException::new);
  }

  private Car getCar(Ticket ticket, ParkingLot parkingLot) {
    try {
      return parkingLot.pick(ticket);
    } catch (InvalidTicketException e) {
      return null;
    }
  }
}
