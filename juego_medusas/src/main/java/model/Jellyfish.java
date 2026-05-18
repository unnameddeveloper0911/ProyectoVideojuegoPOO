package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * Clase abstracta que representa la base de todas las medusas del juego.
 * Define los atributos comunes de posición, dimensiones, estado, velocidad,
 * puntos y sprite, así como los métodos que cada medusa debe implementar
 * para definir su comportamiento en pantalla.
 *
 * @author Daniel Blandón
 * @version 1.2
 *
 * Notas de versión:
 *  1.0: Se crea la clase, se definen parámetros, getters, setters y constructor.
 *       También se añade el método abstracto update().
 *  1.1: Se define el método para randomizar el lugar de salida de las medusas en el mapa.
 *  1.2: Se corrige calculateDy(), se reemplaza setOrigin() por getSpawnX(),
 *       se agrega getHitbox(), y se añaden atributos speed y points.
 */
public abstract class Jellyfish {

    /** Posición horizontal de la medusa en pantalla. */
    private int x;

    /** Posición vertical de la medusa en pantalla. */
    private int y;

    /** Ancho de la medusa, calculado automáticamente a partir del sprite. */
    private int width;

    /** Alto de la medusa, calculado automáticamente a partir del sprite. */
    private int height;

    /** Indica si la medusa está activa en el juego o ya fue eliminada. */
    private boolean active;

    /** Sprite o imagen que representa visualmente la medusa. */
    private BufferedImage sprite;

    /** Dirección actual de movimiento de la medusa. */
    private int direction;

    /** Velocidad de desplazamiento de la medusa en píxeles por frame. */
    private int speed;

    /** Puntos que otorga la medusa al ser eliminada. */
    private int points;

    /** Constante que define la dirección de movimiento hacia arriba. */
    private static final int DIR_UP = 2;

    /** Constante que define cuando no hay dirección de movimiento. */
    private static final int DIR_NONE = 0;

    /**
     * Constructor que inicializa la medusa con su posición, sprite, velocidad y puntos.
     * El ancho y alto se calculan automáticamente a partir de la imagen.
     *
     * @param x      Posición horizontal inicial de la medusa.
     * @param y      Posición vertical inicial de la medusa.
     * @param sprite Imagen que representa visualmente la medusa.
     * @param speed  Velocidad de desplazamiento en píxeles por frame.
     * @param points Puntos que otorga al ser eliminada.
     */
    public Jellyfish(int x, int y, BufferedImage sprite, int speed, int points) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        if (sprite != null) {
            this.width = sprite.getWidth();
            this.height = sprite.getHeight();
        }
        this.active = true;
        this.direction = DIR_UP;
        this.speed = speed;
        this.points = points;
    }

    /**
     * Actualiza la lógica y posición de la medusa en cada frame del juego.
     * Cada subclase define su propio comportamiento de actualización.
     */
    public abstract void update();

    /**
     * Retorna el área de colisión de la medusa en su posición actual,
     * utilizada para detectar si el disparo del jugador la impactó.
     *
     * @return Rectángulo que representa el hitbox de la medusa.
     */
    public Rectangle getHitbox() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Calcula el desplazamiento vertical según la dirección actual.
     * Como las medusas solo se mueven hacia arriba, Y decrece.
     *
     * @return -1 si se mueve hacia arriba, 0 si no hay movimiento vertical.
     */
    public int calculateDy() {
        if (direction == DIR_UP) return -1;
        return 0;
    }

    /**
     * Calcula la posición horizontal de spawn según la cueva de origen,
     * distribuyendo las cuevas uniformemente a lo ancho del panel.
     *
     * @param origin     Índice de la cueva de origen (0 a 3).
     * @param panelWidth Ancho total del panel de juego en píxeles.
     * @return Posición X correspondiente al centro de la cueva indicada.
     */
    public static int getSpawnX(int origin, int panelWidth) {
        int seccion = panelWidth / 4;
        return seccion * origin + seccion / 2;
    }

    /**
     * Carga una imagen desde la carpeta de recursos del proyecto.
     *
     * @param nombre Nombre del archivo de imagen incluyendo su extensión.
     * @return La imagen cargada como BufferedImage, o null si no se encontró.
     */
    public static BufferedImage uploadImage(String nombre) {
        try {
            InputStream is = Jellyfish.class.getResourceAsStream("/images/" + nombre);
            if (is == null) {
                System.err.println("Imagen no encontrada: " + nombre);
                return null;
            }
            return ImageIO.read(is);
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + nombre);
            return null;
        }
    }

    /**
     * Retorna la posición horizontal de la medusa.
     * @return Valor de x.
     */
    public int getX() { return x; }

    /**
     * Establece la posición horizontal de la medusa.
     * @param x Nueva posición horizontal.
     */
    public void setX(int x) { this.x = x; }

    /**
     * Retorna la posición vertical de la medusa.
     * @return Valor de y.
     */
    public int getY() { return y; }

    /**
     * Establece la posición vertical de la medusa.
     * @param y Nueva posición vertical.
     */
    public void setY(int y) { this.y = y; }

    /**
     * Retorna el ancho de la medusa.
     * @return Ancho en píxeles.
     */
    public int getWidth() { return width; }

    /**
     * Establece el ancho de la medusa.
     * @param width Nuevo ancho en píxeles.
     */
    public void setWidth(int width) { this.width = width; }

    /**
     * Retorna el alto de la medusa.
     * @return Alto en píxeles.
     */
    public int getHeight() { return height; }

    /**
     * Establece el alto de la medusa.
     * @param height Nuevo alto en píxeles.
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * Indica si la medusa está activa en el juego.
     * @return true si está activa, false si fue eliminada.
     */
    public boolean isActive() { return active; }

    /**
     * Establece el estado activo de la medusa.
     * @param active true para activar, false para desactivar.
     */
    public void setActive(boolean active) { this.active = active; }

    /**
     * Retorna el sprite actual de la medusa.
     * @return Imagen del sprite.
     */
    public BufferedImage getSprite() { return sprite; }

    /**
     * Establece el sprite de la medusa.
     * @param sprite Nueva imagen del sprite.
     */
    public void setSprite(BufferedImage sprite) { this.sprite = sprite; }

    /**
     * Retorna la dirección actual de movimiento de la medusa.
     * @return Constante de dirección (DIR_NONE o DIR_UP).
     */
    public int getDirection() { return direction; }

    /**
     * Establece la dirección de movimiento de la medusa.
     * @param direction Constante de dirección a asignar.
     */
    public void setDirection(int direction) { this.direction = direction; }

    /**
     * Retorna la velocidad de desplazamiento de la medusa.
     * @return Velocidad en píxeles por frame.
     */
    public int getSpeed() { return speed; }

    /**
     * Establece la velocidad de desplazamiento de la medusa.
     * @param speed Nueva velocidad en píxeles por frame.
     */
    public void setSpeed(int speed) { this.speed = speed; }

    /**
     * Retorna los puntos que otorga la medusa al ser eliminada.
     * @return Cantidad de puntos.
     */
    public int getPoints() { return points; }

    /**
     * Establece los puntos que otorga la medusa al ser eliminada.
     * @param points Nueva cantidad de puntos.
     */
    public void setPoints(int points) { this.points = points; }
}