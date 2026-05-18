package model;

/**
 * Clase para el manejo del jugador.
 *
 * @author Miguel Arias
 * @version 0.4
 *
 * Notas de versión:
 *  0.1: Inicialización de la clase, se añaden parámetros, constructores, getters y setters.
 *  0.2: Se añade método toString para futuros usos en el leaderboard.
 *  0.3: Se añaden métodos de sumar, restar vidas y sumar puntos.
 *  0.4: Se corrigen errores lógicos en addPoints(), lossLive() y addLives().
 */
public class Player {

    /** Vidas iniciales del jugador. */
    private final int START_LIVES = 3;

    /** Puntos iniciales del jugador. */
    private final int START_POINTS = 0;

    /** Puntos actuales del jugador. */
    private int points;

    /** Nombre del jugador. */
    private String name;

    /** Vidas actuales del jugador. */
    private int lives;

    /**
     * Constructor de la clase Player.
     *
     * @param name Nombre del jugador ingresado en la pantalla de inicio.
     */
    public Player(String name) {
        this.name = name;
        this.points = START_POINTS;
        this.lives = START_LIVES;
    }

    /**
     * Añade una cantidad de puntos al puntaje actual del jugador.
     *
     * @param amount Cantidad de puntos a sumar.
     */
    public void addPoints(int amount) {
        this.points += amount;
    }

    /**
     * Resta una vida al jugador cuando una medusa escapa o es una medusa eléctrica.
     */
    public void lossLive() {
        this.lives -= 1;
    }

    /**
     * Añade una vida al jugador cuando elimina una medusa de salud.
     */
    public void addLives() {
        this.lives += 1;
    }

    /**
     * Indica si el jugador aún tiene vidas disponibles.
     *
     * @return true si tiene al menos una vida, false si perdió todas.
     */
    public boolean isAlive() {
        return this.lives > 0;
    }

    /**
     * Retorna la información del jugador formateada para el leaderboard.
     *
     * @return String con nombre y puntos del jugador.
     */
    public String userLeaderboardInfo() {
        return name + " " + points;
    }

    /**
     * Retorna las vidas iniciales del jugador.
     * @return START_LIVES
     */
    public int getStartLives() {
        return START_LIVES;
    }

    /**
     * Retorna los puntos iniciales del jugador.
     * @return START_POINTS
     */
    public int getStartPoints() {
        return START_POINTS;
    }

    /**
     * Retorna los puntos actuales del jugador.
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Establece los puntos del jugador.
     * @param points Nuevo valor de puntos.
     */
    public void setPoints(int points) {
        this.points = points;

    }

    /**
     * Retorna el nombre del jugador.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del jugador.
     * @param name Nuevo nombre.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna las vidas actuales del jugador.
     * @return lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * Establece las vidas del jugador.
     * @param lives Nuevo valor de vidas.
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
}
