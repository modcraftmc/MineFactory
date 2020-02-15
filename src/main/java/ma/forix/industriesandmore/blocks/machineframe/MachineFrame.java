package ma.forix.industriesandmore.blocks.machineframe;

import ma.forix.industriesandmore.tools.handlers.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MachineFrame extends Block implements IHasModel {

    public MachineFrame() {
        super(Properties.create(Material.CLAY)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(2.0F)
        );
        setRegistryName("machine_frame");
    }

    @Override
    public void RegisterModels() {

    }
}
