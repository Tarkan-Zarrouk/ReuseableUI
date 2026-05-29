package main.feature.modules.movement;

import main.feature.ModuleMain;
import net.minecraft.client.Minecraft;

public class Sneak extends ModuleMain{

    public Sneak() {
        super("Sneak", Categories.MOVEMENT, false);
    }

    @Override
    public boolean isPlayerNull() {
        return Minecraft.getInstance().player == null;
    }

    @Override
    public void onEnable() {
        if(!isPlayerNull()) {
            Minecraft.getInstance().player.setShiftKeyDown(true);
        }
    }

    @Override
    public void onDisable() {
        if(!isPlayerNull()) {
            Minecraft.getInstance().player.setShiftKeyDown(false);
        }
    }

    @Override
    public void onTick() {
        if(!isPlayerNull()) {
            Minecraft.getInstance().player.setShiftKeyDown(true);
        }
    }
    
}
