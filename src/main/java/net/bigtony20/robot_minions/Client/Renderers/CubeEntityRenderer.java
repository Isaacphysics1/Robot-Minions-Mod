package net.bigtony20.robot_minions.Client.Renderers;

import net.bigtony20.robot_minions.Client.Models.CubeEntityModel;
import net.bigtony20.robot_minions.Entities.Cubes.CubeEntity;
import net.bigtony20.robot_minions.RobotModClient;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel<CubeEntity>> {
    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(RobotModClient.MODEL_CUBE_LAYER)), 0.25F);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("robot_minions", "textures/entity/cube/cube.png");
    }
}
