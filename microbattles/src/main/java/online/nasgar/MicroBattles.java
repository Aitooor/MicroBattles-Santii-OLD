package online.nasgar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import online.nasgar.menus.MenuPrincipal;
import online.nasgar.utils.Utils;

public class MicroBattles extends JavaPlugin {

    private static MicroBattles instance;

    @Override
    public void onEnable() {

        MicroBattles.instance =this;

        loadAPI();
        new Manager();

    }

    @Override
    public void onDisable() {

        

    }

    public static MicroBattles getInstance() { return instance; }

    public void loadAPI() {

        // Asi se llama a la api y luego se usa - api.(...) -
        API api = (API) Bukkit.getPluginManager().getPlugin("API");
        // Tambien se puede llamar directamente a una variable sin problemas
        Utils.NoPerms();

    }

    public void Menus() {
        this.getCommand("menu").setExecutor(new MenuPrincipal());
    }

}
