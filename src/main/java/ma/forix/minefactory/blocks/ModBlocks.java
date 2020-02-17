package ma.forix.minefactory.blocks;

import ma.forix.minefactory.MineFactory;
import ma.forix.minefactory.blocks.firstblock.FirstBlock;
import ma.forix.minefactory.blocks.firstblock.FirstBlockContainer;
import ma.forix.minefactory.blocks.firstblock.FirstBlockTile;
import ma.forix.minefactory.blocks.portableminer.PortableMiner;
import ma.forix.minefactory.blocks.portableminer.PortableMinerContainer;
import ma.forix.minefactory.blocks.portableminer.PortableMinerTile;
import ma.forix.minefactory.blocks.testblock.TestBlock;
import ma.forix.minefactory.blocks.workbench.Workbench;
import ma.forix.minefactory.blocks.workbench.WorkbenchTile;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    //FIRST BLOCK

    @ObjectHolder(MineFactory.MOD_ID+":first_block")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder(MineFactory.MOD_ID +":first_block")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;

    @ObjectHolder(MineFactory.MOD_ID+":first_block")
    public static ContainerType<FirstBlockContainer> FIRSTBLOCK_CONTAINER;


    //PORTABLE MINER

    @ObjectHolder(MineFactory.MOD_ID+":portable_miner")
    public static PortableMiner PORTABLE_MINER;

    @ObjectHolder(MineFactory.MOD_ID+":portable_miner")
    public static TileEntityType<PortableMinerTile> PORTABLE_MINER_TILE;

    @ObjectHolder(MineFactory.MOD_ID+":portable_miner")
    public static ContainerType<PortableMinerContainer> PORTABLE_MINER_CONTAINER;


    //WORKSHOP

    @ObjectHolder(MineFactory.MOD_ID+":workbench")
    public static Workbench WORKBENCH;

    @ObjectHolder(MineFactory.MOD_ID+":workbench")
    public static TileEntityType<WorkbenchTile> WORKBENCH_TILE;


    //TEST BLOCK
    @ObjectHolder(MineFactory.MOD_ID+":test_block")
    public static TestBlock TEST_BLOCK;
}
