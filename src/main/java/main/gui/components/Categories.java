package main.gui.components;

import main.feature.modules.ModuleMain;
import main.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

public class Categories {
    private static final ModuleMain.Categories[] categories = ModuleMain.Categories.values();
    private static final Minecraft mc = Minecraft.getInstance();
    public static void drawCategories(GuiGraphics graphics) {
        int paddingWidth = 10;
        int paddingHeight = 5;
        int spacingBetweenCategories = 10;

        int startY = 20;
        int startX = 20;

        for(ModuleMain.Categories category : categories) {
            int textWidth = mc.font.width(category.getName());
            int textHeight = mc.font.lineHeight;
            int categoryWidth = textWidth + (paddingWidth * 2) + 10;
            int categoryHeight = textHeight + (paddingHeight * 2);

            RenderUtil.drawOutlinedRect(graphics, startX, startY, categoryWidth, categoryHeight, 0xFF7D007D);
            RenderUtil.drawString(graphics, category.getName(), startX + paddingWidth, startY + paddingHeight);
            startX += categoryWidth + spacingBetweenCategories + 50;
        }
    }
}
