package Fabric;

import Interface.iGameItem;
import Product.ResetBox;

public class ResetBoxGenerator extends ItemGenerator {

    @Override
    public iGameItem createItem() {
        return new ResetBox();
    }
    
}
