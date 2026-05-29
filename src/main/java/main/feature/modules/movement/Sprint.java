package main.feature.modules.movement;

import main.feature.ModuleMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

public class Sprint extends ModuleMain {
    private static final LocalPlayer player = Minecraft.getInstance().player;
    public Sprint() {
        super("Sprint", Categories.MOVEMENT, false);
    }

    @Override
    public void onEnable() {
        if(isPlayerNull() == false)
            player.setSprinting(true);
    }

    @Override
    public void onDisable() {
        if(isPlayerNull() == false)
            player.setSprinting(false);
    }

    @Override
    public void onTick() {
        if(isPlayerNull() == false)
            player.setSprinting(true);
    }

    @Override
    public boolean isPlayerNull() {
        return player == null;
    }

    
}
