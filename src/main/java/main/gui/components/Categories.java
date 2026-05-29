package main.gui.components;

import java.util.HashMap;
import java.util.Map;

import main.feature.ModuleMain;
import main.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

public class Categories {
    private static final ModuleMain.Categories[] categories = ModuleMain.Categories.values();
    private static final Minecraft mc = Minecraft.getInstance();
    private static final Map<ModuleMain.Categories, Integer> rectWidths = new HashMap<>();
    private static final Map<ModuleMain.Categories, Integer> rectHeights = new HashMap<>();
    private static final int colour = 0xFF7D007D;
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

            rectWidths.put(category, categoryWidth);
            rectHeights.put(category, categoryHeight);
            // get centered string
            int centeredString = startX + (categoryWidth / 2) - (textWidth / 2);

            RenderUtil.drawOutlinedRect(graphics, startX, startY, categoryWidth, categoryHeight, 0xFF7D007D);
            RenderUtil.drawString(graphics, category.getName(), centeredString, startY + paddingHeight);
            startX += categoryWidth + spacingBetweenCategories + 50;
        }
    }
    public static final int getColour() {
        return colour;
    }
    public static Map<ModuleMain.Categories, Integer> getRectWidths() {
        return rectWidths;
    }
    public static Map<ModuleMain.Categories, Integer> getRectHeights() {
        return rectHeights;
    }
}
