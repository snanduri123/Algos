package Concepts;


import java.util.Comparator;
import java.util.PriorityQueue;

class Slot {
    int distanceFromEntry;
    boolean isOccupied;

    Slot(int distanceFromEntry) {
        this.distanceFromEntry = distanceFromEntry;
    }

    @Override
    public boolean equals(Object newSlot) {
        if (newSlot instanceof Slot) {
            Slot s = (Slot) newSlot;
            return (this.distanceFromEntry == s.distanceFromEntry);
        } else {
            return false;
        }
    }
}

public class ParkingLot {

    PriorityQueue<Slot> parkingLotQueue;

    public ParkingLot(int numOfSlots) {

        int num = 0;


        parkingLotQueue = new PriorityQueue<Slot>(numOfSlots, new Comparator<Slot>() {
            @Override
            public int compare(Slot o1, Slot o2) {

                return (o1.isOccupied ? 1000 : 1 + o1.distanceFromEntry) - (o2.isOccupied ? 1000 : 1 + o2.distanceFromEntry);
            }
        });

        for (int i = 1; i <= numOfSlots; i++) {

            parkingLotQueue.add(new Slot(num++));

        }

    }

    public Slot park() {

        Slot slot = new Slot(findNearestAvailSlot());
        if (slot == null) {
            System.out.println("parking is full");
        } else {
            parkingLotQueue.remove(slot);
            slot.isOccupied = true;
            parkingLotQueue.add(slot);
        }

        return slot;
    }

    public Slot unPark(Slot slot) {
        if (parkingLotQueue.contains(slot)) {
            parkingLotQueue.remove(slot);
            slot.isOccupied = false;
            parkingLotQueue.add(slot);
        }
        return slot;
    }


    public int findNearestAvailSlot() {
        if (!parkingLotQueue.peek().isOccupied) {
            return parkingLotQueue.peek().distanceFromEntry;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);
        lot.park();
        System.out.println(lot.findNearestAvailSlot());
        lot.park();
        System.out.println(lot.findNearestAvailSlot());
        lot.park();
        System.out.println(lot.findNearestAvailSlot());
        lot.park();
        System.out.println(lot.findNearestAvailSlot());
        lot.park();
        System.out.println(lot.findNearestAvailSlot());
        lot.unPark(new Slot(4));
        System.out.println(lot.findNearestAvailSlot());
        lot.unPark(new Slot(1));
        System.out.println(lot.findNearestAvailSlot());


    }

}
