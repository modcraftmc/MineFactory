package ma.forix.industriesandmore.items;

import ma.forix.industriesandmore.IndustriesAndMore;
import net.minecraft.item.Item;

public class DrillHead extends Item {
    public DrillHead() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(IndustriesAndMore.setup.itemGroup)
        );
        setRegistryName("drill_head");
    }
}
