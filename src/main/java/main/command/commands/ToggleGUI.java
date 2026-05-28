package main.command.commands;

import main.gui.GuiScreen;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.Minecraft;

public class ToggleGUI {
    public static void init() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, __) -> {
            dispatcher.register(ClientCommandManager.literal("toggleGui").executes(ctx -> {
                Minecraft.getInstance().execute(() -> {
                    Minecraft.getInstance().setScreen(new GuiScreen());
                });
                return 1;
            }));
        });
    }
}
