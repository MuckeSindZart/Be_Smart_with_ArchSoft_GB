package Fabric;

import Interface.iGameItem;
import Product.WoodBox;

public class WoodBoxGenerator extends ItemGenerator {

    @Override
    public iGameItem createItem() {
        return new WoodBox();
    }
    
}
