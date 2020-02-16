package ma.forix.industriesandmore.items;

import ma.forix.industriesandmore.IndustriesAndMore;
import net.minecraft.item.Item;

public class IronStick extends Item {
    public IronStick() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(IndustriesAndMore.setup.itemGroup)
        );
        setRegistryName("iron_stick");
    }
}
