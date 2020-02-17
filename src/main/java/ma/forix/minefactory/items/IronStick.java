package ma.forix.minefactory.items;

import ma.forix.minefactory.MineFactory;
import net.minecraft.item.Item;

public class IronStick extends Item {
    public IronStick() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(MineFactory.setup.itemGroup)
        );
        setRegistryName("iron_stick");
    }
}
