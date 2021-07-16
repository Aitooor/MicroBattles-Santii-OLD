package online.nasgar.menus;

import online.nasgar.menubuilder.Menu;
import online.nasgar.menubuilder.MenuButton;
import online.nasgar.utils.Utils;
import online.nasgar.utils.ItemBuilder;

import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class MenuPrincipal implements CommandExecutor {

    public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
        if (!(var1 instanceof Player)) {
            var1.sendMessage(Utils.erroMsg());
        } else {
            Player jugador = (Player) var1;
            Location location = jugador.getLocation();
            Sound sonido = Sound.BLOCK_NOTE_BLOCK_BASS;
            if (var2.getName().equalsIgnoreCase("menu")) {
                Menu menu = new Menu("&8&l➢ &eMENU", 5);
                menu.setInventoryOpened(c -> c.playSound(location, sonido, 1.0f , 1.0f));
                // MENU GENERAL
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &bMi Perfil")
                        .lore("&F"
                                ,"&fAccede a esta opcion para "
                                ,"&fmirar tus estadisticas y "
                                ,"&Fconfiguraciones "
                                ,"&7"
                                ,"&aClick para abrir")
                        .skullOwner(jugador.getName())
                        .build())
                        .setWhenClicked(c -> c.performCommand("perfil")), 18);
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &3Discord")
                        .lore("&F"
                                ,"&fEntra a nuestro server "
                                ,"&fde Discord. "
                                ,"&fY conoce a toda nuesta comunidad. "
                                ,"&7"
                                ,"&aClick para ver")
                        .setCustomTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19")
                        .build())
                        .setWhenClicked(c -> c.performCommand("discord")), 9);
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &aTienda")
                        .lore("&F"
                                ,"&fVisita nuestra tienda "
                                ,"&fy compra un monton "
                                ,"&fde cosas nuevas. "
                                ,"&7"
                                ,"&aClick para ver")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDg5NTBiZjdkNWYwODc0OGY2NmI0MzAwNzMyNWM3MTUzNmU0MThkMzU2M2JkMDFhODNmZDhlYjUxNWQ4NjNiMCJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("tienda")), 27);
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &eAyuda")
                        .lore("&F"
                                ,"&c¿Tienes preguntas sobre el server? "
                                ,"&fentra a esta opcion e informate"
                                ,"&Fde todo nuestros comandos y opciones"
                                ,"&7"
                                ,"&aClick para abrir")
                        .setCustomTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjFjNjNkOWI5ZmQ4NzQyZWFlYjA0YzY5MjE3MmNiOWRhNDM3ODE2OThhNTc1Y2RhYmUxYzA0ZGYxMmMzZiJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("wiki")), 19);
                // MENU PRINCIPAL
                // Lands, protection plugin
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dProtecciones")
                        .lore("&F"
                                ,"&fAccede a este menu para mirar "
                                ,"&fe informarte sobre tus protecciones "
                                ,"&fSi tienes dudas contacta a un &eSoporte/Mod"
                                ,"&7"
                                ,"&aClick para abrir")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDMwYzM4ZTVmNDYwNGNmYmZlOWEzNmExNWVhZDMyM2JmMGY1MzM5MWYzOTY0MGZhYjMwZWFiZDc4YjU4OTkzNyJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("lands")), 12);
                // Warps
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dWarps")
                        .lore("&F",
                                "&c¿Necesitas ir a algun lugar? ",
                                "&fEntra a esta opcion y yo te llevare",
                                "&Fa conocer todo el servidor."
                                ,"&7"
                                ,"&aClick para abrir")

                        .setCustomTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("warp")), 14);
                // Jobs plugin
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dTrabajos")
                        .lore("&7 "
                                ,"&c¿Necesitas dinero? "
                                ,"&fVisita nuestro catalogo de"
                                ,"&fempleos y unete a alguno"
                                ,"&7"
                                ,"&aClick para abrir")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTIzYTI3NDJjMzVlYzI3MTU4MWZhOTYwMWQwODRlZmQwZmY0YzMzZDA2YTNjNzk1NzBkYjg3MzNmZmJjMzI2NiJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("trabajos")), 16);
                // Battle Pass plugin
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dPase de Batalla")
                        .lore("&7 "
                                , "&fCompleta todos los &eretos "
                                , "&fy obten a cambio grandes recompensas"
                                , "&7"
                                , "&aClick para abrir")
                        .setCustomTextures("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQzYzc5Y2Q5YzJkMzE4N2VhMDMyNDVmZTIxMjhlMGQyYWJiZTc5NDUyMTRiYzU4MzRkZmE0MDNjMTM0ZTI3In19fQ==")
                        .build())
                        .setWhenClicked(c -> c.performCommand("battlepass:battlepass")), 22);
                // Auction plugin
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dCasa de Subastas")
                        .lore("&7 "
                                , "&fEn este mercado encontraras "
                                , "&fitems vendidos por los usarios del"
                                , "&fservidor, compra y vende tambien los tuyos"
                                , "&7"
                                , "&aClick para abrir")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE0MGJjZjM2ZjFjNGU1YjE5OTc2NTIxZTg1NzZmMTVhNDgxMjJmNWUxOTdhMmRmNDQ0OGVmNDAyMjJiNDFkZCJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("ah")), 24);
                // /server survival2 (Farming Survival Server)
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &dRecursos")
                        .lore("&7 "
                                , "&fVete ha recursos "
                                , "&fpara poder hacer &eGranjas, "
                                , "&eDungeons&f, &eCazadragones&f, ..."
                                , "&7"
                                , "&aClick para ir")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk3ODdiNjVlZGNiODI4YTFiNTk3ZjQzNjQ5ZjJlNDE3OGVmMmFmMGIyMjBiNzRhZDFkZDZlYTBjNjRjOWU3MSJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("recursos")), 32);
                // Glasses
                
                menu.registerButton(new MenuButton(new ItemBuilder(Material.PLAYER_HEAD)
                        .displayName("&8➢ &bNasgar Network")
                        .lore("&7Disfruta")
                        .setCustomTextures("e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk3ODdiNjVlZGNiODI4YTFiNTk3ZjQzNjQ5ZjJlNDE3OGVmMmFmMGIyMjBiNzRhZDFkZDZlYTBjNjRjOWU3MSJ9fX0=")
                        .build())
                        .setWhenClicked(c -> c.performCommand("recursos")), 0);
                // Open Menu
                menu.open(jugador);
            }
        }
        return false;
    }
}