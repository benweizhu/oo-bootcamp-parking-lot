package oo.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ParkingManager extends SuperBoy {

  private List<SuperBoy> parkingBoys = new ArrayList<>();

  public ParkingManager(List<ParkingLot> parkingLots) {
    super(parkingLots);
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
