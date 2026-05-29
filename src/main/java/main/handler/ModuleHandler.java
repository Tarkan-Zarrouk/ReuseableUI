package main.handler;

import java.util.ArrayList;
import java.util.List;

import main.feature.ModuleMain;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ModuleHandler {
    private static final List<ModuleMain> modules = new ArrayList<>();

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for(ModuleMain module : modules) {
                if(module.isEnabled()) {
                    module.onTick();
                }
            }
        });
    }
    public static void addToModulesList(ModuleMain... module) {
        for(ModuleMain moduleItem : module) {
            modules.add(moduleItem);
        }
    }
    public static List<ModuleMain> getModulesList() {
        return modules;
    }
}
