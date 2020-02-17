package ma.forix.minefactory.blocks.testblock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {
    public TestBlock() {
        super(Properties.create(Material.CLAY)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(2.0F)
        );
        setRegistryName("test_block");
    }
}
