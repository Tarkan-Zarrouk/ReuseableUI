package main.feature.modules;

public class ModuleMain {

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
}
