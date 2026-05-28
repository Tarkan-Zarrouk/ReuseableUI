package main.gui.components;

import java.util.List;

import main.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

public class Categories {
    private static final List<String> categories = List.of(
        "Category One",
        "Category Two",
        "Category Three",
        "Category Four",
        "Clickgui"
    );
    private static final Minecraft mc = Minecraft.getInstance();
    public static void drawCategories(GuiGraphics graphics) {
        int paddingWidth = 10;
        int paddingHeight = 5;
        int spacingBetweenCategories = 10;

        int startY = 20;
        int startX = 20;

        for(String category : categories) {
            int textWidth = mc.font.width(category);
            int textHeight = mc.font.lineHeight;
            int categoryWidth = textWidth + (paddingWidth * 2) + 25;
            int categoryHeight = textHeight + (paddingHeight * 2);

            RenderUtil.drawOutlinedRect(graphics, startX, startY, categoryWidth, categoryHeight, 0xFF7D007D);
            RenderUtil.drawString(graphics, category, startX + paddingWidth, startY + paddingHeight);
            startX += categoryWidth + spacingBetweenCategories + 50;
        }
    }
}
