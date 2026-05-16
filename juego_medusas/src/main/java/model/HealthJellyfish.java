package model;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Clase que define el comportamiento de la medusa de salud. Esta medusa añade una vida al jugador cuando este la revienta.
 * Esta no resta vidas al llegar a la superficie
 *
 * @author Miguel Arias
 * @version 1.0
 *
 * Notas de la version:
 *  1.0: Inicialización de la clase, se añade constructores, parametros, getters, setters y metodo update heredado
 *
 */

public class HealthJellyfish extends Jellyfish {
    /**
     * Velocidad de la medusa
     */
    private int speed;

    /**
     * Random para definir lugar de origen
     */
    Random rand=new Random();
    /**
     * Definir posicion de inicio
     */
    private int origin= rand.nextInt(4);

    /**
     * Posicion inicial en X
     */
    private final int INITIAL_X= setOrigin(origin);
    /**
     * Posición inicial en Y
     */
    private final int INITIAL_Y= 0;

    /**
     * Constructor que inicializa la entidad con su posición y sprite.
     * El ancho y alto se calculan automáticamente a partir de la imagen.
     *
     * @param x      Posición horizontal inicial de la entidad.
     * @param y      Posición vertical inicial de la entidad.
     * @param sprite Imagen que representa visualmente la entidad.
     */
    public HealthJellyfish(int x, int y, BufferedImage sprite) {
        super(x, y, sprite);
    }

    /**
     * Getter para velocidad
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter para velocidad
     * @param speed
     */

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void update() {
        setY(getY()+calculateDy()*speed);
    }
}
