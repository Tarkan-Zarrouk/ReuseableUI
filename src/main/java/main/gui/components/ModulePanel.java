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
    private static final int colour = Categories.getColour();
    public static void drawModulePanel(GuiGraphics graphics) {
        // drawPanelBackground(graphics);
        drawModules(graphics);
        // Map<ModuleMain.Categories, Integer> moduleHeight = new HashMap<>();
        // for(ModuleMain.Categories category : ModuleMain.Categories.values()) {
        //     moduleHeight.put(category, startY + 39);
        // }

        // Map<ModuleMain.Categories, Integer> categoryX = new HashMap<>();
        // int baseX = startX;

        // for (ModuleMain.Categories cat : ModuleMain.Categories.values()) {
        //     int width = categoryRectWidths.get(cat);
        //     categoryX.put(cat, baseX);
        //     baseX += width + spacing + 50;
        // }
        // for (ModuleMain module : modules) {

        //     ModuleMain.Categories cat = module.getCategory();
        //     int x = categoryX.get(cat);
        //     int w = categoryRectWidths.get(cat);
        //     int h = categoryRectHeights.get(cat);

        //     int centeredString = x + (w / 2) - (RenderUtil.getStringWidth(module.getName()) / 2);

        //     RenderUtil.drawRect(graphics, x, startY, w, h, colour);
        //     RenderUtil.drawString(graphics, module.getName(), centeredString, startY + 5);

        //     moduleHeight.put(cat, startY + h + 5);
        // }
    }
    // private static void drawPanelBackground(GuiGraphics graphics) {
    //     Map<ModuleMain.Categories, Integer> numOfModulesInCategory = new HashMap<>(); // Category and the height of every category
    //     // get the number of modules per category
    //     for (ModuleMain.Categories categoryConstant : ModuleMain.Categories.values()) {
    //         int count = 0;
    //         for (ModuleMain module : modules) {
    //             if (module.getCategory().getName().equals(categoryConstant.getName())) {
    //                 count++;
    //             }
    //         }
    //         numOfModulesInCategory.put(categoryConstant, count);
    //     }
    //     // get the height of every panel
    //     Map<ModuleMain.Categories, Integer> categoryHeights = new HashMap<>();
    //     for (ModuleMain.Categories cat : ModuleMain.Categories.values()) {
    //         int moduleHeight = numOfModulesInCategory.get(cat) * (categoryRectHeights.get(cat) + spacing); // numberOfModulesInCategory * (heightOfCategory + spacing)
    //         categoryHeights.put(cat, moduleHeight);
    //     }
    //     for (ModuleMain.Categories cat : ModuleMain.Categories.values()) {
    //         if (numOfModulesInCategory.get(cat) == 0) {
    //             continue;
    //         }
    //         int x = startX;
    //         for (ModuleMain.Categories c : ModuleMain.Categories.values()) {
    //             if (c == cat) {
    //                 break;
    //             } else {
    //                 x += categoryRectWidths.get(c) + spacing + 50;
    //             }
    //         }
    //         RenderUtil.drawRect(graphics, x, startY, categoryRectWidths.get(cat), categoryHeights.get(cat), colour);
    //     }
    // }
    private static void drawModules(GuiGraphics graphics) {
        /**
         * Step 1: Calculate the x position for each category and store it in a map.
         * Step 2: For each module, get its category, find the corresponding x position 
         * and draw the module's name at that position, incrementing the y position for each module in the same category.
         * Step 3: Use the categoryRectWidths and categoryRectHeights maps to determine the width and height of each module's rectangle.
         * Step 4: Draw the rectangle and the module name using RenderUtil.drawRect and RenderUtil.drawString, ensuring that the text is centered within the rectangle.
         */
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
