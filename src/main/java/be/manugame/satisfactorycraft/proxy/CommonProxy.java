package be.manugame.satisfactorycraft.proxy;

import be.manugame.satisfactorycraft.SatisfactoryCraft;
import be.manugame.satisfactorycraft.objects.blocks.machines.TileEntityPortableMiner;
import be.manugame.satisfactorycraft.utils.handlers.RegistryHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

public class CommonProxy {

    public void preInit(File configFile)
    {
        RegistryHandler.preInitRegistries();
        GameRegistry.registerTileEntity(TileEntityPortableMiner.class, SatisfactoryCraft.MOD_ID + ":portable_miner");

    }

    public void init()
    {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }
}
