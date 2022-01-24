package net.bigtony20.robot_minions.mixin;

import io.socket.client.Socket;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(BlockEntity.class)
public abstract class RobotMixin {
    private String URI;
    private Socket socket;

}