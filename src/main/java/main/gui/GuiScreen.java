package main.gui;

import java.util.List;

import main.gui.components.Categories;
import main.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class GuiScreen extends Screen {
    private static final Component narratorComponent = Component.literal("Gui Narrator");

    private final List<String> categoryStrings = List.of(
        "Combat",
        "Movement",
        "Render",
        "Utility"
    );

    public GuiScreen() {
        super(narratorComponent);
    }


    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.render(graphics, mouseX, mouseY, partialTicks);

        // int paddingWidth = 10;
        // int paddingHeight = 5;
        // int spacing = 10;

        // int y = 20;
        // int x = 20;

        // for (String category : this.categoryStrings) {

        //     int textWidth = Minecraft.getInstance().font.width(category);
        //     int textHeight = Minecraft.getInstance().font.lineHeight;

        //     int rectWidth = textWidth + paddingWidth * 2;
        //     int rectHeight = textHeight + paddingHeight * 2;
            
        //     RenderUtil.drawOutlinedRect(graphics, x, y, rectWidth, rectHeight, 0xFF7D007D);
        //     RenderUtil.drawString(graphics, category, x + paddingWidth, y + paddingHeight);

        //     x += rectWidth + spacing + 50;
        // }
        Categories.drawCategories(graphics);
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
