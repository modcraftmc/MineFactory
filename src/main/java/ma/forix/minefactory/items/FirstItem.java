package ma.forix.minefactory.items;

import ma.forix.minefactory.MineFactory;
import net.minecraft.item.Item;

public class FirstItem extends Item {
    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(4)
                .group(MineFactory.setup.itemGroup)
        );
        setRegistryName("first_item");
    }
}
