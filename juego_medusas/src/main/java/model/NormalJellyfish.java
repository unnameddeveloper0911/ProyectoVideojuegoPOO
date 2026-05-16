package model;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Clase para el funcionamiento de la medusa normal
 *
 * @author Miguel Arias
 * @version 1.0
 *
 * Notas de la version:
 *  1.0:
 *      Inicialización de la clase, se añaden parametros, constructores, getters, setters y metodo update heredado.
 *  2.0:
 *
 */

public class NormalJellyfish extends Jellyfish {
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
    public NormalJellyfish(int x, int y, BufferedImage sprite) {
        super(x, y, sprite);
        this.speed = 3;
        setX(INITIAL_X);
        setY(INITIAL_Y);
        setActive(true);
        setSpeed(3);
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
     * Metodo Update() heredado de clase padre
     */
    @Override
    public void update() {
        setY(getY()+calculateDy()*speed);
    }


}
