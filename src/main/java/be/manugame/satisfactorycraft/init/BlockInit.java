package be.manugame.satisfactorycraft.init;

import be.manugame.satisfactorycraft.objects.blocks.FrameBlock;
import be.manugame.satisfactorycraft.objects.blocks.PortableMiner;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<>();


    public static final Block PORTABLE_MINER = new PortableMiner("portable_miner");

    public static final Block MACHINE_FRAME = new FrameBlock("machine_frame");
}
