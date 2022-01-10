package net.bigtony20.robot_minions.item.custom;

import net.bigtony20.robot_minions.item.ModItemGroup;
import net.bigtony20.robot_minions.item.ModToolMaterial;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem() {
        super(ModToolMaterial.Reinforced,4,2,new Settings().group(ModItemGroup.ROBOT_MINIONS_GROUP));
    }
}
