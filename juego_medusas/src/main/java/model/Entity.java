package model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase abstracta que representa la base de todas las entidades del juego.
 * Define los atributos comunes de posición, alto y ancho, estado y sprite
 * o imagen asignada, así como los métodos abstractos que cada entidad debe implementar
 * para definir su comportamiento y forma de dibujarse en pantalla.
 *
 * @author Daniel Blandón, Miguel Arias, Yulieth Paola Domínguez
 * @version 1.0
 */
public abstract class Entity {
    /**
     * posición en X del de la entidad
     */
    private int x;
    /**
     * posición en Y del de la entidad
     */
    private int y;
    /**
     * Ancho de la entidad
     */
    private int width;
    /**
     * Alto de la entidad
     */
    private int height;
    /**
     * Variable de estado para saber si estaactiva o no
     */
    private boolean active;
    /**
     * Sprite o imagen que tendrá la entidad
     */
    private BufferedImage sprite;

    /**
     * representa la dirección en la que se mueve la entidad
     */
    private int direction;

    /**
     * Constante que define la dirección de movimiento hacia arriba
     */
    private static final int DIR_UP = 2;

    /**
     * Constate que define cuando no hay dirección
     * de movimiento
     */
    private static final int DIR_NONE = 0;

    /**
     * Constructor que inicializa la entidad con su posición y sprite.
     * El ancho y alto se calculan automáticamente a partir de la imagen.
     *
     * @param x      Posición horizontal inicial de la entidad.
     * @param y      Posición vertical inicial de la entidad.
     * @param sprite Imagen que representa visualmente la entidad.
     */
    public Entity(int x, int y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        if (sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        }
        this.active = true;
        this.direction = DIR_UP;
    }

    /**
     * Retorna la posición en X de la entidad
     * @return posición en X
     */
    public int getX() {
        return x;
    }

    /**
     * Establece una nueva posición en x de la entidad
     * @param x Valor de x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna la posición en Y de la entidad
     * @return Valor de Y
     */
    public int getY() {
        return y;
    }

    /**
     * Establece una nueva posición en Y
     * @param y valor de Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retorna el ancho de la entidad
     * @return valor del ancho
     */
    public int getWidth() {
        return width;
    }

    /**
     * Establece un nuevo valor para el ancho de la entidad
     * @param width valor del ancho
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Retorna la altura de la entidad
     * @return valor de la altura
     */
    public int getHeight() {
        return height;
    }

    /**
     * Establece un nuevo valor de la altura de la entidad
     * @param height valor de la altura
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Retorna si la entidad está activa o no
     * @return valor del estado de la entidad
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Establece un nuevo valor para el estado de la entidad
     * @param active valor del estado de la entidad
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Retorna el sprite de la entidad
     * @return sprite de la entidad
     */
    public BufferedImage getSprite() {
        return sprite;
    }

    /**
     * Establece un nuevo sprite para entidad
     * @param sprite sprite de la entidad
     */
    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    /**
     * Retorna la dirección de la entidad
     * @return dirección actual de la entidad
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Establece una nueva dirección para la entidad
     * @param direction dirección actual de la entidad
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
