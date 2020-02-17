package ma.forix.minefactory.items;

import ma.forix.minefactory.MineFactory;
import net.minecraft.item.Item;

public class MachineFrame extends Item {
    public MachineFrame() {
        super(new Item.Properties()
                .maxStackSize(30000)
                .group(MineFactory.setup.itemGroup)
        );
        setRegistryName("machine_frame");
    }
}
