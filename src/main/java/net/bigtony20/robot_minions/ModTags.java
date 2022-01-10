package net.bigtony20.robot_minions;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static  final Tag<Block> VALUABLE_BLOCKS = createTag("valuable_ore");

        private static Tag<Block> createTag(String name){
            return TagFactory.BLOCK.create(new Identifier(RobotMod.MODID,name));
        }
        private static Tag<Block> createCommonTag(String name){
            return TagFactory.BLOCK.create(new Identifier("c",name));
        }

    }
    public static class Items{
        private static Tag<Item> createTag(String name){
            return TagFactory.ITEM.create(new Identifier(RobotMod.MODID,name));
        }
        private static Tag<Item> createCommonTag(String name){
            return TagFactory.ITEM.create(new Identifier("c",name));
        }
    }
}
