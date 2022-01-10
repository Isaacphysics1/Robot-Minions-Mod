package net.bigtony20.robot_minions.item.custom;

import net.bigtony20.robot_minions.ModTags;
import net.bigtony20.robot_minions.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class RobotOreScanner extends Item {

    public RobotOreScanner() {
        super(new Settings()
                .group(ModItemGroup.ROBOT_MINIONS_GROUP)
                .maxCount(1000)
        );
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()){
            BlockPos positioClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
            boolean foundBlock = false;
            for (int i = -64; i <= positioClicked.getY(); i++){
                Block blockBelow = context.getWorld().getBlockState(positioClicked.down(i)).getBlock();
                if (IsValuableBlock(blockBelow)){
                    OutputValuableCordinates(blockBelow, positioClicked.add(0,-i,0),player);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock){
                player.sendMessage(new LiteralText("No Block Found"),false);
            }
        }
        context.getStack().damage(1,context.getPlayer(),
                (player -> player.sendToolBreakStatus(player.getActiveHand())));
        return super.useOnBlock(context);
    }
    boolean IsValuableBlock(Block block){
        return block.getDefaultState().isIn(ModTags.Blocks.VALUABLE_BLOCKS);
    }
    void OutputValuableCordinates(Block block, BlockPos pos, PlayerEntity player){
        player.sendMessage(new LiteralText("Found "+block.asItem().getName().getString()+" At Pos: (X:" + pos.getX()+" Y:"+pos.getY()+" Z:"+pos.getZ()),false);
    }
}
