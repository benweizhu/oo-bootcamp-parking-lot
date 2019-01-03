package oo.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingManager {

  private ArrayList<SuperBoy> parkingBoys;

  public ParkingManager(ArrayList<SuperBoy> parkingBoys) {
    this.parkingBoys = parkingBoys;
  }

  public Ticket park(Car car) throws Throwable {
    Optional<SuperBoy> boy = this.parkingBoys.stream().filter(SuperBoy::hasAvailableSlots).findFirst();
    if (boy.isPresent()) {
      return boy.get().park(car);
    } else {
      throw new ParkingLotIsFullException();
    }
  }
}
