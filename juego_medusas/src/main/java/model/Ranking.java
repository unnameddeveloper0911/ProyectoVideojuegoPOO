package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



/**
 * Clase encargada de gestionar el historial de jugadores y el
 * Top 3. Lee y escribe los datos en un archivo TXT para
 * que los datos persistan a un cuando el programa no está en ejecución
 *
 * @author Daniel Blandón
 * @version 1.0
 *
 * Notas de versión:
 *  1.0: Inicialización de la clase, se implementa la lectura
 *  y escritura en archivo txt, en el que se guarda el jugador y sus puntos
 *  1.1: Se termina de immplementar la clase con los métodos que permiten guardar los datos de los
 *  jugadores en unarchivo txt para que cuando el proggrama se deje de ejecutar los datos no se borren
 *
 *
 */
public class Ranking {
    /**
     * Ruta del archivo donde se guardará el historial de jugadores
     */
    private static final String FILE_PATH = "ranking.txt";

    /**
     * Lista de jugadores que cargará los jugadores a los jugadores
     * al archivo y también recibirá los jugadores que el archivo haya guardado
     */
    private List<Player> players;

    /**
     * Constructor que inicializa el raking cargando los
     * datos existentes desde el archivo
     */
    public Ranking(){
        this.players = new ArrayList<>();
        loadFromFile();
    }

    /**
     * Guarda un jugador en la lista y actualiza el archivo txt
     * @param player jugador a guardar en la lista con su nombre y puntaje
     */
    public void savePlayer(Player player){
        players.add(player);
        saveToFile();
    }

    /**
     * Retorna una lista con los 3 jugadores de mayor puntaje
     * ordenados de mayor a menor, los jugadores que no entre en el top 3
     * no son incluidos en la lista
     * @return Lista con el top 3 de jugadores
     */
    public List<Player> getTop3(){
        List<Player> playersSorted = new ArrayList<>(players);
        playersSorted.sort(Comparator.comparingInt(Player::getPoints).reversed());
        if(playersSorted.size() > 3){
            return playersSorted.subList(0, 3);
        }
        return playersSorted;
    }

    /**
     * Retorna todos los jugadores guardados en el historial
     * @return
     */
    public List<Player> getAllPlayers(){
        return players;
    }

    /**
     * Carga los jugadores desde el archivo de texto
     * Si el archivo no existe, inicializa la lista vacía
     */
    public void loadFromFile(){
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) !=null){
                String[] parts = line.split(",");
                if(parts.length == 2){
                    String name = parts[0];
                    int points = Integer.parseInt(parts[1]);
                    Player player = new Player(name);
                    player.setPoints(points);
                    players.add(player);
                }
            }
        }catch(IOException e){
            System.err.println("Error leyendo el ranking: " + e.getMessage());
        }
    }

    /**
     * Escribe todos los jugadores actuales en el archivo txt,
     * sobreescribiendo también los jugadores que se tenian antes
     */

    public void saveToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Player player : players){
                writer.write(player.getName() + "," + player.getPoints());
                writer.newLine();
            }
        }catch(IOException e){
            System.err.println("Error guardando el ranking: " + e.getMessage());
        }
    }
}
