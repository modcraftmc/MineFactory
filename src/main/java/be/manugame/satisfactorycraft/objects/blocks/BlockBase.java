package be.manugame.satisfactorycraft.objects.blocks;

import be.manugame.satisfactorycraft.SatisfactoryCraft;
import be.manugame.satisfactorycraft.init.BlockInit;
import be.manugame.satisfactorycraft.init.ItemInit;
import be.manugame.satisfactorycraft.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {


    public BlockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setCreativeTab(SatisfactoryCraft.SC_TAB);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public void registerModels() {
        SatisfactoryCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }
}
