package oo.bootcamp.parkinglot;

public interface Parkingable {
  Car pick(Ticket ticket);

  Ticket park(Car car);
}
