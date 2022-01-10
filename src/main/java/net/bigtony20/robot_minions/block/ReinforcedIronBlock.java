package net.bigtony20.robot_minions.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class ReinforcedIronBlock extends Block {
    public ReinforcedIronBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .strength(4.0f)
                .requiresTool()
        );
    }
}
