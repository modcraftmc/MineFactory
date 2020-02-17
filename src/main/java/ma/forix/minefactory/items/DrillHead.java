package ma.forix.minefactory.items;

import ma.forix.minefactory.MineFactory;
import net.minecraft.item.Item;

public class DrillHead extends Item {
    public DrillHead() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(MineFactory.setup.itemGroup)
        );
        setRegistryName("drill_head");
    }
}
