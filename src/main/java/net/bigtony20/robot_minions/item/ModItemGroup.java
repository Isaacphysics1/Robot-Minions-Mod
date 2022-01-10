package net.bigtony20.robot_minions.item;

import net.bigtony20.robot_minions.RobotMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static  final ItemGroup ROBOT_MINIONS_GROUP = FabricItemGroupBuilder.build(new Identifier(RobotMod.MODID, "robot_minions_itemgroup"),
        () -> new ItemStack(ModItems.REINFORCED_IRON_INGOT));
}
