package net.bigtony20.robot_minions;

import net.bigtony20.robot_minions.Entities.Cubes.CubeEntity;
import net.bigtony20.robot_minions.block.ModBlocks;
import net.bigtony20.robot_minions.Entities.ModEntities;
import net.bigtony20.robot_minions.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class RobotMod implements ModInitializer{

    public static String MODID = "robot_minions";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModEntities.registerEntities();

        FabricDefaultAttributeRegistry.register(ModEntities.CUBE, CubeEntity.createMobAttributes());
    }
}