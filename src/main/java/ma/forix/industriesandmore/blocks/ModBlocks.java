package ma.forix.industriesandmore.blocks;

import ma.forix.industriesandmore.IndustriesAndMore;
import ma.forix.industriesandmore.blocks.firstblock.FirstBlock;
import ma.forix.industriesandmore.blocks.firstblock.FirstBlockContainer;
import ma.forix.industriesandmore.blocks.firstblock.FirstBlockTile;
import ma.forix.industriesandmore.blocks.portableminer.PortableMiner;
import ma.forix.industriesandmore.blocks.portableminer.PortableMinerContainer;
import ma.forix.industriesandmore.blocks.portableminer.PortableMinerTile;
import ma.forix.industriesandmore.blocks.workbench.Workbench;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    //FIRST BLOCK

    @ObjectHolder(IndustriesAndMore.MOD_ID+":first_block")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder(IndustriesAndMore.MOD_ID +":first_block")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;

    @ObjectHolder(IndustriesAndMore.MOD_ID+":first_block")
    public static ContainerType<FirstBlockContainer> FIRSTBLOCK_CONTAINER;


    //PORTABLE MINER

    @ObjectHolder(IndustriesAndMore.MOD_ID+":portable_miner")
    public static PortableMiner PORTABLE_MINER;

    @ObjectHolder(IndustriesAndMore.MOD_ID+":portable_miner")
    public static TileEntityType<PortableMinerTile> PORTABLE_MINER_TILE;

    @ObjectHolder(IndustriesAndMore.MOD_ID+":portable_miner")
    public static ContainerType<PortableMinerContainer> PORTABLE_MINER_CONTAINER;


    //WORKSHOP

    @ObjectHolder(IndustriesAndMore.MOD_ID+":workbench")
    public static Workbench WORKBENCH;
}
