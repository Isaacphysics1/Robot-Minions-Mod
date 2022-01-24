package net.bigtony20.robot_minions.Entities;

import net.bigtony20.robot_minions.Entities.Cubes.CubeEntity;
import net.bigtony20.robot_minions.RobotMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static EntityType regitserEntity(String name, EntityType entity){
        return  Registry.register(Registry.ENTITY_TYPE, new Identifier(RobotMod.MODID, name), entity);
    }

    public static final EntityType<CubeEntity> CUBE = regitserEntity("cube",
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static void registerEntities(){
        System.out.println("Registering Mod Entities for " + RobotMod.MODID);
    }
}
