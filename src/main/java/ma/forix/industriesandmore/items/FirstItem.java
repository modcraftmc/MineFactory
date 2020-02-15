package ma.forix.industriesandmore.items;

import ma.forix.industriesandmore.IndustriesAndMore;
import net.minecraft.item.Item;

public class FirstItem extends Item {
    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(4)
                .group(IndustriesAndMore.setup.itemGroup)
        );
        setRegistryName("first_item");
    }
}
