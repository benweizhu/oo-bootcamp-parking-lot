package oo.bootcamp.parkinglot.domain;

import oo.bootcamp.parkinglot.model.Car;
import oo.bootcamp.parkinglot.model.Ticket;

public interface Parkingable {
  Car pick(Ticket ticket);

  Ticket park(Car car);
}
