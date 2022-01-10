package net.bigtony20.robot_minions.item;

import net.bigtony20.robot_minions.item.custom.*;
import net.minecraft.item.*;
import net.bigtony20.robot_minions.RobotMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Simple Items
    public static final Item REINFORCED_IRON_INGOT = regitserItem("reinforced_iron_ingot",
            new Item(new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    public static final Item ROBOT_SENSOR = regitserItem("robot_sensor",
            new Item(new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    public static final Item ROBOT_BODY = regitserItem("robot_body",
            new Item(new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    public static final Item ROBOT_ANTENNA = regitserItem("robot_antenna",
            new Item(new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    public static final Item REINFORCED_STICK = regitserItem("reinforced_stick",
            new Item(new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));

    //Advanced Items
    public static final Item ROBOT_ORE_SCANNER = regitserItem("robot_ore_scanner", new RobotOreScanner());

    //tools
    //public static final Item REINFORCED_SWORD = regitserItem("reinforced_sword",
            //new ModSwordItem(ModToolMaterial.Reinforced,15,2,new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    //public static final PickaxeItem REINFORCED_PICKAXE = regitserItem("reinforced_pickaxe", new ModPickaxeItem());
    //public static final Item REINFORCED_HOE = regitserItem("reinforced_hoe",
            //new ModHoeItem(ModToolMaterial.Reinforced,1,1,new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    //public static final Item REINFORCED_AXE = regitserItem("reinforced_axe",
            //new ModAxeItem(ModToolMaterial.Reinforced,10,2,new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));
    //public static final Item REINFORCED_SHOVEL = regitserItem("reinforced_shovel",
            //new ModShovelItem(ModToolMaterial.Reinforced,1,2,new Item.Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP)));


    public static Item regitserItem(String name, Item item){
        return  Registry.register(Registry.ITEM, new Identifier(RobotMod.MODID, name), item);
    }
    public static void registerItems(){
        System.out.println("Registering Mod Items for " + RobotMod.MODID);
    }
}
