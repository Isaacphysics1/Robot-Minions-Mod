package net.bigtony20.robot_minions.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Robot extends HorizontalFacingBlock{

    private static final VoxelShape SHAPE_N = VoxelShapes.union(Block.createCuboidShape(8, 8, 8, 9, 11, 9), Block.createCuboidShape(7, 11, 8, 8, 13, 9), Block.createCuboidShape(7, 7, 8, 8, 9, 9), Block.createCuboidShape(7, 13, 8, 9, 14, 9), Block.createCuboidShape(4, 0, 2, 12, 7, 14), Block.createCuboidShape(3, 0, 3, 13, 7, 13), Block.createCuboidShape(2, 0, 4, 14, 7, 12));
    private static final VoxelShape SHAPE_E = VoxelShapes.union(Block.createCuboidShape(7, 8, 8, 8, 11, 9),Block.createCuboidShape(7, 11, 7, 8, 13, 8),Block.createCuboidShape(7, 7, 7, 8, 9, 8),Block.createCuboidShape(7, 13, 7, 8, 14, 9),Block.createCuboidShape(2, 0, 4, 14, 7, 12),Block.createCuboidShape(3, 0, 3, 13, 7, 13),Block.createCuboidShape(4, 0, 2, 12, 7, 14));
    private static final VoxelShape SHAPE_S = VoxelShapes.union(Block.createCuboidShape(7, 8, 7, 8, 11, 8),Block.createCuboidShape(8, 11, 7, 9, 13, 8),Block.createCuboidShape(8, 7, 7, 9, 9, 8),Block.createCuboidShape(7, 13, 7, 9, 14, 8),Block.createCuboidShape(4, 0, 2, 12, 7, 14),Block.createCuboidShape(3, 0, 3, 13, 7, 13),Block.createCuboidShape(2, 0, 4, 14, 7, 12));
    private static final VoxelShape SHAPE_w = VoxelShapes.union(Block.createCuboidShape(8, 8, 7, 9, 11, 8),Block.createCuboidShape(8, 11, 8, 9, 13, 9),Block.createCuboidShape(8, 7, 8, 9, 9, 9),Block.createCuboidShape(8, 13, 7, 9, 14, 9),Block.createCuboidShape(2, 0, 4, 14, 7, 12),Block.createCuboidShape(3, 0, 3, 13, 7, 13),Block.createCuboidShape(4, 0, 2, 12, 7, 14));
    public Robot() {
        super(AbstractBlock.Settings.of(Material.METAL)
                .strength(4.0f)
                .requiresTool()
        );
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        LOGGER.log(org.apache.logging.log4j.Level.ALL,"Logger Started");
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_w;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world,pos);

            if (screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }
}
