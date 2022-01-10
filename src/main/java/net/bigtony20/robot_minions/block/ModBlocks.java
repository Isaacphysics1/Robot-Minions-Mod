package net.bigtony20.robot_minions.block;

import net.bigtony20.robot_minions.RobotMod;
import net.bigtony20.robot_minions.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    private static Block REINFORCED_IRON_BLOCK = regitserBlock("reinforced_iron_block", new ReinforcedIronBlock());

    public static Block regitserBlock(String name, Block block){
        regitserBlockItem(name,block);
        return  Registry.register(Registry.BLOCK, new Identifier(RobotMod.MODID, name), block);
    }
    public static Item regitserBlockItem(String name, Block block){
        return  Registry.register(Registry.ITEM, new Identifier(RobotMod.MODID, name), new BlockItem(block,new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    }
    public static void registerBlocks(){
        System.out.println("Registering Mod Blocks for " + RobotMod.MODID);
    }
}
