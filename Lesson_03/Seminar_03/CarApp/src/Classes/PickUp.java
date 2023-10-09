package Classes;

import java.awt.Color;

import Enumerator.BodyType;
import Enumerator.FuelType;
import Enumerator.GearBoxType;
import Interfaces.iFuelStation;
import Interfaces.iWip;

public class PickUp extends Car implements iFuelStation , iWip{

    private float loadCapacity;

    public PickUp(String make, String model,
            Color color, int numberOfWheels,
            GearBoxType gearBoxType, FuelType fuelType,
            float engineCapacity, float loadCapacity) {
        super(make, model, color, BodyType.PICKUP , numberOfWheels, gearBoxType, fuelType, engineCapacity);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void wipWindShield() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wipWindShield'");
    }

    @Override
    public void wipHeadLights() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wipHeadLights'");
    }

    @Override
    public void wipMirrors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wipMirrors'");
    }

    @Override
    public void fuel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fuel'");
    }

}
