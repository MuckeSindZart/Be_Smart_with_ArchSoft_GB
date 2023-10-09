package Classes;

import java.awt.Color;

import Enumerator.BodyType;
import Enumerator.FuelType;
import Enumerator.GearBoxType;

public abstract class Car {
    private String make;
    private String model;
    private Color color;
    private BodyType bodyType;
    private int numberOfWheels;
    private GearBoxType gearBoxType;
    private FuelType fuelType;
    private float engineCapacity;

    public Car(String make, String model, Color color,
            BodyType bodyType, int numberOfWheels,
            GearBoxType gearBoxType, FuelType fuelType,
            float engineCapacity) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.bodyType = bodyType;
        this.numberOfWheels = numberOfWheels;
        this.gearBoxType = gearBoxType;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
    }

    public void movement() {
    }

    public void maintains() {
    }

    public boolean turnLights() {
        return true;
    }


    public boolean turnWrappers(){
        return true;
    }

}
