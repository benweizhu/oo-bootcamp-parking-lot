package oo.bootcamp.parkinglot;

public class ParkingBoy {

  private ParkingLot parkingLot;

  public ParkingBoy(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

  public Ticket park(Car car) {
    return this.parkingLot.parking(car);
  }

  public Car pick(Ticket ticket) {
    return this.parkingLot.pick(ticket);
  }
}
