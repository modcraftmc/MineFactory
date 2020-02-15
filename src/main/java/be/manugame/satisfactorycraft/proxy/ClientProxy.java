package be.manugame.satisfactorycraft.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.io.File;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(File configFile)
    {
        // TODO Auto-generated method stub
        super.preInit(configFile);
    }

    @Override
    public void init()
    {
        // TODO Auto-generated method stub
        super.init();
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
