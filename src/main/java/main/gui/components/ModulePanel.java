package main.gui.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.feature.ModuleMain;
import main.handler.ModuleHandler;
import main.util.RenderUtil;
import net.minecraft.client.gui.GuiGraphics;

public class ModulePanel {
    private static final List<ModuleMain> modules = ModuleHandler.getModulesList(); 
    private static final Map<ModuleMain.Categories, Integer> categoryRectWidths = Categories.getRectWidths();
    private static final Map<ModuleMain.Categories, Integer> categoryRectHeights = Categories.getRectHeights();

    private static final int startX = 20;
    private static final int startY = 39;
    private static final int spacing = 10;
    public static void drawModulePanel(GuiGraphics graphics) {
        drawModules(graphics);
    }
    private static void drawModules(GuiGraphics graphics) {
        Map<ModuleMain.Categories, Integer> categoryX = new HashMap<>();
        int baseX = startX;
        for (ModuleMain.Categories cat : ModuleMain.Categories.values()) {
            int width = categoryRectWidths.get(cat);
            categoryX.put(cat, baseX);
            baseX += width + spacing + 50;
        }
        Map<ModuleMain.Categories, Integer> moduleHeight = new HashMap<>();
        for(ModuleMain.Categories category : ModuleMain.Categories.values()) {
            moduleHeight.put(category, startY);
        }
        for (ModuleMain module : modules) {
            ModuleMain.Categories cat = module.getCategory();
            int x = categoryX.get(cat);
            int w = categoryRectWidths.get(cat);
            int h = categoryRectHeights.get(cat);
            int y = moduleHeight.get(cat);

            int centeredString = x + (w / 2) - (RenderUtil.getStringWidth(module.getName()) / 2);

            RenderUtil.drawRect(graphics, x, y, w, h, 0xFF540d54);
            // examplemodule
            if(module.getName().length() >= 10) {
                String shortenedName = module.getName().substring(0, 10) + "...";
                centeredString = x + (w / 2) - (RenderUtil.getStringWidth(shortenedName) / 2);
                RenderUtil.drawString(graphics, shortenedName, centeredString, y + 5);
            } else {
                RenderUtil.drawString(graphics, module.getName(), centeredString, y + 5);
            }

            moduleHeight.put(cat, y + h);
        }
    }
}
