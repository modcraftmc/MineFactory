package ma.forix.industriesandmore.setup;

import ma.forix.industriesandmore.blocks.firstblock.FirstBlockScreen;
import ma.forix.industriesandmore.blocks.ModBlocks;
import ma.forix.industriesandmore.blocks.portableminer.PortableMinerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
    @Override
    public void init() {
        ScreenManager.registerFactory(ModBlocks.FIRSTBLOCK_CONTAINER, FirstBlockScreen::new);
        ScreenManager.registerFactory(ModBlocks.PORTABLE_MINER_CONTAINER, PortableMinerScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
