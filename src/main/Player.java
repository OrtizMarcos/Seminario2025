package src.main;

/**
 * Clase que representa al jugador en el juego Space Invaders
 */
public class Player {
    private int x;
    private int y;
    private int health;
    private int lives;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 100;
        this.lives = 3;
    }
    
    /**
     * Mueve el jugador hacia la izquierda
     */
    public void moveLeft() {
        if (x > 0) {
            x -= 10;
        }
    }
    
    /**
     * Mueve el jugador hacia la derecha
     */
    public void moveRight() {
        if (x < 800) { // Límite de pantalla
            x += 10;
        }
    }
    
    /**
     * El jugador dispara
     */
    public void shoot() {
        System.out.println("¡Pew! Disparo desde posición (" + x + ", " + y + ")");
    }
    
    /**
     * El jugador recibe daño
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            lives--;
            health = 100;
            System.out.println("¡Vida perdida! Vidas restantes: " + lives);
        }
    }
    
    // Getters y Setters
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getLives() {
        return lives;
    }
    
    public void setLives(int lives) {
        this.lives = lives;
    }
    
    @Override
    public String toString() {
        return "Player{posicion=(" + x + ", " + y + "), salud=" + health + ", vidas=" + lives + "}";
    }
} 