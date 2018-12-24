package oo.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {

    private int numberOfSlot;
    private Map<Ticket, Car> parkedCars = new HashMap<>();

    ParkingLot(int numberOfSlot) {
        this.numberOfSlot = numberOfSlot;
    }

    Ticket parking(Car car) {
        if (this.numberOfSlot <= parkedCars.size()) {
            throw new NoSlotException();
        }
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        return ticket;
    }

    public Car pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            throw new PickCarFailedException();
        }
        return parkedCars.remove(ticket);
    }
}
