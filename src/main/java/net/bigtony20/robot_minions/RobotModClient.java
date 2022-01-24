package net.bigtony20.robot_minions;

import net.bigtony20.robot_minions.Client.Models.CubeEntityModel;
import net.bigtony20.robot_minions.Client.Renderers.CubeEntityRenderer;
import net.bigtony20.robot_minions.Entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RobotModClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ROBOT_LAYER = new EntityModelLayer(new Identifier(RobotMod.MODID, "robot"), "robot_render_layer");
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("entitytesting", "cube"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CUBE, (context) -> {
            return new CubeEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);

    }
}
