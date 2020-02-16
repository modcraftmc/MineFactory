package ma.forix.industriesandmore.items;

import ma.forix.industriesandmore.IndustriesAndMore;
import net.minecraft.item.Item;

public class MachineFrame extends Item {
    public MachineFrame() {
        super(new Item.Properties()
                .maxStackSize(30000)
                .group(IndustriesAndMore.setup.itemGroup)
        );
        setRegistryName("machine_frame");
    }
}
