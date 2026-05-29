package main.feature;

import main.feature.modules.clickgui.ClickGUI;
import main.feature.modules.dungeons.Dungeons;
import main.feature.modules.farming.Farming;
import main.feature.modules.movement.Sneak;
import main.feature.modules.movement.Sprint;
import main.feature.modules.visual.Visual;
import main.handler.ModuleHandler;

public abstract class ModuleMain {
    private String name;
    private Categories category;
    private boolean enabled;
    public ModuleMain(String name, Categories category, boolean enabled) {
        this.category = category;
        this.name = name;
        this.enabled = enabled;
    }
    public static void registerModules() {
        ModuleHandler.addToModulesList(
            new Sprint(),
            new Sneak(),
            new ClickGUI(),
            new Dungeons(),
            new Farming(),
            new Visual()
        );
        // ModuleHandler.addToModulesList(new Sneak());
        // ModuleHandler.addToModulesList(new Sneak());
        // ModuleHandler.addToModulesList(new ClickGUI());
        // ModuleHandler.addToModulesList();
    }
    public enum Categories {
        CLICKGUI("ClickGUI"),
        DUNGEONS("Dungeons"),
        FARMING("Farming"),
        MOVEMENT("Movement"),
        VISUAL("Visual");
        String name;
        Categories(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getName() {
        return this.name;
    }
    public Categories getCategory() {
        return this.category;
    }
    public abstract boolean isPlayerNull();
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onTick();
}
