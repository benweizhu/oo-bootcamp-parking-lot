package oo.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {

    private int amount;
    private Map<Ticket, Car> parkedCars = new HashMap<>();

    ParkingLot(int amount) {
        this.amount = amount;
    }

    Ticket parking(Car car) {
        if (this.amount <= 0) {
            throw new NoSlotException();
        }
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        this.amount--;
        return ticket;
    }

    public Car pick(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)) {
            throw new PickCarFailedException();
        }
        return parkedCars.remove(ticket);
    }
}
