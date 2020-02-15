package be.manugame.satisfactorycraft;

import be.manugame.satisfactorycraft.proxy.CommonProxy;
import be.manugame.satisfactorycraft.tabs.SCtab;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = SatisfactoryCraft.MOD_ID,
        name = SatisfactoryCraft.MOD_NAME,
        version = SatisfactoryCraft.VERSION
)
public class SatisfactoryCraft {

    public static final String MOD_ID = "sc";
    public static final String MOD_NAME = "SatisfactoryCraft";
    public static final String VERSION = "2019.3-1.3.2";

    //GUI

    public static final int GUI_PORTABLE_FURNACE = 0;

    public static final CreativeTabs SC_TAB = new SCtab("Satifactory Craft");

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static SatisfactoryCraft INSTANCE;

    public static Logger logger;



    @SidedProxy(clientSide = "be.manugame.satisfactorycraft.proxy.ClientProxy", serverSide = "be.manugame.satisfactorycraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

}
