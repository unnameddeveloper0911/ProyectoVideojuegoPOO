package model;

/**
 * Clase para el manejo del jugador
 *
 * @author Miguel Arias
 *
 * @version 0.2
 * Notas de version:
 *  0.1:
 *      inicialización de la clase, se añaden parametros, constructores, getters y setter
 *
 *  0.2:
 *      añadir metodo de tipo toString para futuros usos en el leaderboard
 *
 */

public class Player {
    /**
     * Vidas iniciales del jugador
     */
    private final int START_LIVES = 3;

    /**
     * Puntos iniciales del jugador
     */
    private final int START_POINTS = 0;

    /**
     * Puntos del jugador. Estos se actualizan y luego se añaden al leaderboard junto al nombre
     */
    private int points;

    /**
     * Nombre del jugador. Este va junto a los puntos en el leaderboard
     */
    private String name;


    /**
     * Constructor de la clase Jugador
     *
     * @param name
     * @param points
     */
    public Player(String name, int points) {
        this.name = name;
        this.points = START_POINTS;
    }

    /**
     * Getter de vidas iniciales
     *
     * @return START_LIVES
     */
    public int getSTART_LIVES() {
        return START_LIVES;
    }

    /**
     * Getter de puntos iniciales
     *
     * @return START_POINTS
     */
    public int getSTART_POINTS() {
        return START_POINTS;
    }

    /**
     * Getter de puntos
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Setter de puntos
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Getter de nombre
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter de nombre
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para convertir la información del jugador en un solo string para usar en el leaderboard
     * @return "{name} {points}"
     */

    public String userLeaderboardInfo(String name, int points) {
        return name + " " + points;
    }


}
