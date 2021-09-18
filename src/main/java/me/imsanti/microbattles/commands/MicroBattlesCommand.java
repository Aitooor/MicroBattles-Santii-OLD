package me.imsanti.microbattles.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.imsanti.microbattles.MicroBattles;
import me.imsanti.microbattles.game.team.Team;
import me.imsanti.microbattles.game.team.TeamColor;
import me.imsanti.microbattles.map.Map;
import me.imsanti.microbattles.map.MapManager;
import me.imsanti.microbattles.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class MicroBattlesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ColorUtils.color("&cThe console can't use this command."));
            return true;
        }

        final Player player = (Player) sender;

        switch (args[0].toLowerCase()) {
            case "arena":
                final MapManager mapManager = MicroBattles.getInstance().getMapManager();
                switch (args[1].toLowerCase()) {
                    case "create":
                        final String arenaName = args[2];
                        player.sendMessage(ColorUtils.color("&aHas creado la Arena &e " + arenaName));

                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("Connect");
                        out.writeUTF(arenaName.toLowerCase());

                        player.sendPluginMessage(MicroBattles.getInstance(), "BungeeCord", out.toByteArray());
                        mapManager.loadMap(arenaName, 0, 0);
                        break;

                    case "setminplayers":
                        final Map map = mapManager.getMap(args[2]);
                        //todo: Add no existing map check
                        //microbattles arena setmaxplayers (arena) (maxplayers)

                        player.sendMessage(ColorUtils.color("&eJugadores minimos para la arena &a" + map.getServerName() + " eestablecidos a " + args[2]));


                        map.setMinPlayers(Integer.parseInt(args[3]));
                        break;
                    case "setmaxplayers":
                        //todo: Add no existing map check
                        //microbattles arena setmaxplayers (arena) (maxplayers)


                        final Map map2 = mapManager.getMap(args[2]);
                        player.sendMessage(ColorUtils.color("&eJugadores minimos para la arena &a" + map2.getServerName() + " eestablecidos a " + args[2]));
                        map2.setMaxPlayers(Integer.parseInt(args[3]));
                        break;
                    case "addteam":
                        //microbattles arena addteam (arena) (team)

                        final String teamColor = args[3].toUpperCase();
                        if(!(Arrays.toString(TeamColor.values()).contains(teamColor))) {
                            player.sendMessage(ColorUtils.color("&cEl team " + teamColor + " no es valido."));
                            return true;
                        }

                        final Team team = new Team(TeamColor.valueOf(teamColor), null);
                        mapManager.getMap(args[2]).getCreatedTeams().add(team);
                        player.sendMessage(ColorUtils.color("&aHas creado el team " + teamColor.toString()));

                        break;
                    case "setteamlocation":
                        //microbattles arena setteamlocation (arena) (team)

                        final String color = args[3].toUpperCase();

                        final Team createdTeam = mapManager.getMap(args[2]).getTeamByName(color);
                        if(createdTeam == null) {
                            player.sendMessage(ColorUtils.color("&cEl equipo " + color + " no existe."));
                            return true;
                        }

                        createdTeam.setLocation(player.getLocation());
                        player.sendMessage(ColorUtils.color("&aUbicación del team establecida a tu ubicación actual"));

                        break;
                }
        }
        return true;
    }
}
