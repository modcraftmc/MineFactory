package be.manugame.satisfactorycraft.tabs;

import be.manugame.satisfactorycraft.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SCtab extends CreativeTabs {

    public SCtab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockInit.PORTABLE_MINER);
    }
}
