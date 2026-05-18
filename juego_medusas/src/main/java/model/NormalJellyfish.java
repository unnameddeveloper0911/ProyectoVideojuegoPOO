package model;

import java.awt.image.BufferedImage;

/**
 * Clase que define el comportamiento de la medusa normal.
 * Esta medusa resta vidas al jugador si llega a la superficie
 * sin ser eliminada y otorga 10 puntos al ser disparada.
 *
 * @author Miguel Arias, Daniel Blandón
 * @version 1.1
 *
 * Notas de versión:
 *  1.0: Inicialización de la clase, se añaden parámetros, constructores,
 *       getters, setters y método update heredado.
 *  1.1: Se elimina speed duplicado, se corrige el constructor para recibir
 *       speed y points del padre, se elimina lógica incorrecta de INITIAL_X
 *       y setOrigin(), se eliminan llamadas redundantes en el constructor.
 */
public class NormalJellyfish extends Jellyfish {

    /**
     * Constructor que inicializa la medusa normal con su posición,
     * sprite, velocidad y puntos.
     * El ancho y alto se calculan automáticamente a partir del sprite.
     *
     * @param x      Posición horizontal inicial de la medusa.
     * @param y      Posición vertical inicial de la medusa.
     * @param sprite Imagen que representa visualmente la medusa.
     * @param speed  Velocidad de desplazamiento en píxeles por frame.
     * @param points Puntos que otorga al ser eliminada.
     */
    public NormalJellyfish(int x, int y, BufferedImage sprite, int speed, int points) {
        super(x, y, sprite, speed, points);
    }

    /**
     * Actualiza la posición de la medusa moviéndola hacia arriba
     * según su velocidad en cada frame del juego.
     */
    @Override
    public void update() {
        setY(getY() + calculateDy() * getSpeed());
    }
}