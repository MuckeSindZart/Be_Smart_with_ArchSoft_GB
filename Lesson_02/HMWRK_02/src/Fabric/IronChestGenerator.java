package Fabric;

import Interface.iGameItem;
import Product.IronChest;

public class IronChestGenerator extends ItemGenerator {

    @Override
    public iGameItem createItem() {
        return new IronChest();
    }
    
}
