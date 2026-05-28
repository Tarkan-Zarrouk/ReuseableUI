package main.gui;

import main.gui.components.Categories;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class GuiScreen extends Screen {
    private static final Component narratorComponent = Component.literal("Gui Narrator");

    public GuiScreen() {
        super(narratorComponent);
    }


    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.render(graphics, mouseX, mouseY, partialTicks);
        
        Categories.drawCategories(graphics);
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
