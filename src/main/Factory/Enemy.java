package src.main.Factory;

/**
 * Clase base abstracta para todos los enemigos del juego
 * Define las propiedades y comportamientos comunes
 */
public abstract class Enemy {
    protected String type;
    protected int x;
    protected int y;
    protected int health;
    protected int damage;
    protected int points;
    
    public Enemy(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Método abstracto que cada enemigo debe implementar
     * Define cómo se comporta el enemigo
     */
    public abstract void behave();
    
    /**
     * Método para que el enemigo reciba daño
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println(type + " destruido en posición (" + x + ", " + y + ")");
        }
    }
    
    /**
     * Método para que el enemigo se mueva
     */
    public void move() {
        // Movimiento básico hacia abajo
        y += 5;
        System.out.println(type + " se mueve a posición (" + x + ", " + y + ")");
    }
    
    /**
     * Método para que el enemigo dispare
     */
    public void shoot() {
        System.out.println(type + " dispara desde posición (" + x + ", " + y + ")");
    }
    
    /**
     * Verifica si el enemigo está vivo
     */
    public boolean isAlive() {
        return health > 0;
    }
    
    // Getters y Setters
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
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
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    @Override
    public String toString() {
        return type + "{posicion=(" + x + ", " + y + "), salud=" + health + 
               ", daño=" + damage + ", puntos=" + points + "}";
    }
} 