package ma.forix.industriesandmore.blocks.workbench;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Workbench extends Block {
    public Workbench() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(1.0F)
        );
        setRegistryName("workbench");
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        if (entity != null){
            world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
        }
    }

    public static Direction getFacingFromEntity(BlockPos clickedBloc, LivingEntity entity){
        return Direction.getFacingFromVector((float) (entity.lastTickPosX - clickedBloc.getX()), (float) (entity.lastTickPosY - clickedBloc.getY()), (float) (entity.lastTickPosZ - clickedBloc.getZ()));
    }
}
