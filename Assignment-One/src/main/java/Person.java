package main.java;

import java.sql.Timestamp;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class Person implements Callable {

    // Logger
    private static final Logger LOGGER = Logger.getLogger(Person.class.getName());

    // Counter for static concurrent incrementation
    private static int id_counter = 0;

    // Default Person Object parameters.
    private int id;
    private int weight;
    private int arrivalTime;
    private int arrivalFloor;
    private int destFloor;
    private Luggage luggage;
    private boolean pickedCorrectButton;

    public Person(int weight, int luggageWeight, int arrivalTime, int arrivalFloor, int destFloor) {
        this.weight = weight;
        this.arrivalTime = arrivalTime;
        this.arrivalFloor = arrivalFloor;
        this.destFloor = destFloor;
        this.luggage = new Luggage(luggageWeight);
        this.id = ++id_counter;
    }

    @Override
    public Person call() {
        Timestamp arrivalTime = new Timestamp(System.currentTimeMillis());
        LOGGER.info(String.format("Person with ID {%d} has arrived inside the Airport at time {%s}", this.id, arrivalTime.toString()));
        return this;
    }

    public long getArrivalTime() {
        return this.arrivalTime;
    }

    public int getArrivalFloor() {
        return this.arrivalFloor;
    }

    public int getDestFloor() {
        return this.destFloor;
    }

    @Override
    public String toString() {
        return String.format("Person ID {%d}", this.id);
    }
}