package io.github.pedrokase;

import io.github.pedrokase.Commands.RollDice;
import org.bukkit.plugin.java.JavaPlugin;

public class DawnEngine extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("roll").setExecutor(new RollDice());
    }

    @Override
    public void onDisable() {

    }
}

