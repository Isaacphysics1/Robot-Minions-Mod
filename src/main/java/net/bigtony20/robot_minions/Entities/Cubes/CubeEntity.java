package net.bigtony20.robot_minions.Entities.Cubes;

import net.bigtony20.robot_minions.Socket.Client;
import net.bigtony20.robot_minions.Socket.NewMessage;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.EventListener;
import java.util.EventObject;
import java.util.UUID;

import net.bigtony20.robot_minions.Socket.MessageListener;

public class CubeEntity extends MobEntity {
    Direction MoveDirection = null;
    boolean Invurable = true;
    Client c;
    public CubeEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        setInvulnerable(true);
        setDespawnCounter(-1);
        if (!world.isClient){
            c = new Client();
            c.addMyEventListener(evt -> {
                Move();
            });
            c.start();
        }
    }
    public boolean damage(DamageSource source, float amount) {
        return Invurable;
    }
    public void Move(){
        double i = MathHelper.floor(this.getX());
        double j = MathHelper.floor(this.getY());
        double k = MathHelper.floor(this.getZ());
        if (c.LastMessage.equals("Forwards")){
            System.out.println("Moving");
            setPos(i,j,k+1);
        }
    }
    public void tickMovement() {
        super.tickMovement();
        this.setVelocity(0,0,0);
    }
    public static DefaultAttributeContainer.Builder createMoobAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1D);

    }

    @Override
    public boolean doesNotCollide(double offsetX, double offsetY, double offsetZ) {
        return true;
    }
}
