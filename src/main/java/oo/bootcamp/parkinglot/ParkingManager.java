package oo.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ParkingManager implements Parkingable {

  private List<SuperBoy> parkingBoys = new ArrayList<>();
  private List<ParkingLot> parkingLots;

  public ParkingManager(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  @Override
  public Ticket park(Car car) {
    return this.parkingBoys
        .stream()
        .filter(SuperBoy::hasAvailableSlots)
        .findFirst()
        .map(boy -> boy.park(car))
        .orElseGet(() -> managerPark(car));
  }

  @Override
  public Car pick(Ticket ticket) {
    return this.parkingBoys
        .stream()
        .filter(superBoy -> superBoy.containsCar(ticket))
        .findAny()
        .map(superBoy -> superBoy.pick(ticket))
        .orElseGet(() -> this.pick(ticket));
  }

  private Ticket managerPark(Car car) {
    return parkingLots
        .stream()
        .filter(ParkingLot::hasAvailableSlot)
        .findFirst()
        .map(parkingLot -> parkingLot.park(car))
        .orElseThrow((Supplier<RuntimeException>) ParkingLotIsFullException::new);
  }

  public void addParkingBoy(SuperBoy superBoy) {
    parkingBoys.add(superBoy);
  }
}
