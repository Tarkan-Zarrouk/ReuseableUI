package main.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class RenderUtil {
    public static void drawString(GuiGraphics graphics, String name, int xPos, int yPos) {
        graphics.drawString(Minecraft.getInstance().font, Component.literal(name), xPos, yPos, 0xFFFFFFFF);
    }
    public static void drawRect(GuiGraphics graphics, int xPos, int yPos, int width, int height, int colour) {
        graphics.fill(xPos, yPos, xPos + width, yPos + height, colour);
    }
    public static void drawOutlinedRect(GuiGraphics graphics, int xPos, int yPos, int width, int height, int colour) {
        graphics.fill(xPos + 1, yPos + 1, xPos + width, yPos + height, colour);
        graphics.renderOutline(xPos, yPos, width, height, 0xFFFFFFFF);
    }
}
