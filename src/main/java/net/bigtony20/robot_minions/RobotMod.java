package net.bigtony20.robot_minions;

import net.bigtony20.robot_minions.block.ModBlocks;
import net.bigtony20.robot_minions.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class RobotMod implements ModInitializer{

    public static String MODID = "robot_minions";
    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}