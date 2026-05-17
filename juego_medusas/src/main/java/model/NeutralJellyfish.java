package model;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Clase que define el comportamiento de la medusa neutral.
 * Esta medusa solo le resta vidas al jugador si este las revienta. Pueden llegar a la superficie
 */

public class NeutralJellyfish extends Jellyfish {

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
    public NeutralJellyfish(int x, int y, BufferedImage sprite) {
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


    /**
     * Metodo update heredado, actualiza la posición de la medusa
     */
    @Override
    public void update() {
        setY(getY()+calculateDy()*speed);
    }
}
