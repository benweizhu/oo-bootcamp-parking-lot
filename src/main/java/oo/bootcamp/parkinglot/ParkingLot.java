package oo.bootcamp.parkinglot;

class ParkingLot {

    private int amount;

    ParkingLot(int amount) {
        this.amount = amount;
    }

    Ticket park(Car car) {
        if (this.amount <= 0) {
            throw new NoSlotException();
        }
        this.amount--;
        return new Ticket();
    }
}
