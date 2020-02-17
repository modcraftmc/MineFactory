package ma.forix.minefactory;

import ma.forix.minefactory.blocks.firstblock.FirstBlock;
import ma.forix.minefactory.blocks.firstblock.FirstBlockContainer;
import ma.forix.minefactory.blocks.firstblock.FirstBlockTile;
import ma.forix.minefactory.blocks.ModBlocks;
import ma.forix.minefactory.blocks.portableminer.PortableMiner;
import ma.forix.minefactory.blocks.portableminer.PortableMinerContainer;
import ma.forix.minefactory.blocks.portableminer.PortableMinerTile;
import ma.forix.minefactory.blocks.testblock.TestBlock;
import ma.forix.minefactory.blocks.workbench.Workbench;
import ma.forix.minefactory.blocks.workbench.WorkbenchTile;
import ma.forix.minefactory.items.DrillHead;
import ma.forix.minefactory.items.FirstItem;
import ma.forix.minefactory.items.IronStick;
import ma.forix.minefactory.items.MachineFrame;
import ma.forix.minefactory.setup.ClientProxy;
import ma.forix.minefactory.setup.IProxy;
import ma.forix.minefactory.setup.ModSetup;
import ma.forix.minefactory.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MineFactory.MOD_ID)
public class MineFactory {

    public static final String MOD_ID = "mf";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public MineFactory() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.init();
        setup.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new FirstBlock());
            event.getRegistry().register(new PortableMiner());
            event.getRegistry().register(new Workbench());
            event.getRegistry().register(new TestBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, properties).setRegistryName("first_block"));
            event.getRegistry().register(new BlockItem(ModBlocks.PORTABLE_MINER, properties).setRegistryName("portable_miner"));
            event.getRegistry().register(new BlockItem(ModBlocks.WORKBENCH, properties).setRegistryName("workbench"));
            event.getRegistry().register(new BlockItem(ModBlocks.TEST_BLOCK, properties).setRegistryName("test_block"));

            event.getRegistry().register(new FirstItem());
            event.getRegistry().register(new MachineFrame());
            event.getRegistry().register(new DrillHead());
            event.getRegistry().register(new IronStick());
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event){
            event.getRegistry().register(TileEntityType.Builder.create(FirstBlockTile::new, ModBlocks.FIRSTBLOCK).build(null).setRegistryName("first_block"));
            event.getRegistry().register(TileEntityType.Builder.create(PortableMinerTile::new, ModBlocks.PORTABLE_MINER).build(null).setRegistryName("portable_miner"));
            event.getRegistry().register(TileEntityType.Builder.create(WorkbenchTile::new, ModBlocks.WORKBENCH).build(null).setRegistryName("workbench"));
        }

        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new FirstBlockContainer(windowId, MineFactory.proxy.getClientWorld(), pos, inv, MineFactory.proxy.getClientPlayer());
            }).setRegistryName("first_block"));
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new PortableMinerContainer(windowId, MineFactory.proxy.getClientWorld(), pos, inv, MineFactory.proxy.getClientPlayer());
            }).setRegistryName("portable_miner"));
        }
    }
}