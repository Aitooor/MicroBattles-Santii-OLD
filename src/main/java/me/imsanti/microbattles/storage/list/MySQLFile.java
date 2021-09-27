package me.imsanti.microbattles.storage.list;

import me.imsanti.microbattles.MicroBattles;
import me.imsanti.microbattles.map.Map;
import me.imsanti.microbattles.storage.CoreFile;
import me.imsanti.microbattles.storage.DataType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.sql.*;

public class MySQLFile  {
     final FileConfiguration config = MicroBattles.getInstance().getStorageManager().getFile("config.yml").getConfiguration();
     private final String host = config.getString("mysql.host");
    private final String port = config.getString("mysql.port");
    private final String database = config.getString("mysql.database");
    private final String username = config.getString("mysql.username");
    private final String password = config.getString("mysql.password");
    private final boolean useSSL = config.getBoolean("mysql.useSSL");

    private Connection connection;

    public boolean isConnected() {
        return connection != null;
    }

    public void connect() {
        if(isConnected()) return;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=" + useSSL,
                    username, password);
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("No se ha podido conectar a la database. Un error ha ocurrido.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        if(!(isConnected())) return;
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public void setupSQL() {
        if(!isConnected()) return;

        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS maps " + "(NAME VARCHAR(100),MINPLAYERS INT(100),MAXPLAYERS INT(100), PRIMARY KEY (NAME))");
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void registerMap(final Map map) {
        if(!isConnected()) return;

        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM maps WHERE NAME=?");
            preparedStatement.setString(1, map.getServerName());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            PreparedStatement prep2 =  connection.prepareStatement("INSERT IGNORE INFO maps" + " (NAME,MINPLAYERS,MAXPLAYERS VALUES (?,?,?)");
            prep2.setString(1, map.getServerName());
            prep2 .setString(2, String.valueOf(map.getMinPlayers()));
            prep2.setString(3, String.valueOf(map.getMaxPlayers()));
            prep2.executeUpdate();

            return;

        }catch (SQLException exception) {

        }


    }
}