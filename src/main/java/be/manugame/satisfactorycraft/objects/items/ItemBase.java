package be.manugame.satisfactorycraft.objects.items;

import be.manugame.satisfactorycraft.SatisfactoryCraft;
import be.manugame.satisfactorycraft.init.ItemInit;
import be.manugame.satisfactorycraft.utils.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name)  {
        setRegistryName(name);
        setCreativeTab(SatisfactoryCraft.SC_TAB);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        SatisfactoryCraft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
