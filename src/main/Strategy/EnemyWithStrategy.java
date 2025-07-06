package src.main.Strategy;

/**
 * Clase que implementa el patrón Strategy para enemigos
 * Permite cambiar dinámicamente la estrategia de movimiento
 */
public class EnemyWithStrategy {
    
    private String type;
    private int x;
    private int y;
    private int health;
    private MoveStrategy moveStrategy;
    
    public EnemyWithStrategy(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.health = 50;
        // Estrategia por defecto: movimiento hacia la izquierda
        this.moveStrategy = new MoveLeft();
    }
    
    /**
     * Establece la estrategia de movimiento
     * @param strategy Nueva estrategia de movimiento
     */
    public void setMoveStrategy(MoveStrategy strategy) {
        this.moveStrategy = strategy;
        System.out.println(type + " cambia a estrategia: " + strategy.getStrategyName());
    }
    
    /**
     * Ejecuta el movimiento usando la estrategia actual
     */
    public void move() {
        if (moveStrategy != null) {
            int[] newPosition = moveStrategy.move(x, y);
            this.x = newPosition[0];
            this.y = newPosition[1];
            
            System.out.println(type + " se mueve usando " + moveStrategy.getStrategyName() + 
                             " a posición (" + x + ", " + y + ")");
        }
    }
    
    /**
     * Ejecuta el comportamiento del enemigo
     */
    public void behave() {
        System.out.println(type + " en posición (" + x + ", " + y + ") ejecuta comportamiento");
        
        // El enemigo puede cambiar de estrategia basado en su posición
        if (x <= 100) {
            // Si está cerca del borde izquierdo, cambiar a movimiento hacia la derecha
            setMoveStrategy(new MoveRight());
        } else if (x >= 700) {
            // Si está cerca del borde derecho, cambiar a movimiento hacia la izquierda
            setMoveStrategy(new MoveLeft());
        }
        
        // Ejecutar movimiento
        move();
    }
    
    /**
     * El enemigo dispara
     */
    public void shoot() {
        System.out.println(type + " dispara desde posición (" + x + ", " + y + ")");
    }
    
    /**
     * El enemigo recibe daño
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println(type + " destruido en posición (" + x + ", " + y + ")");
        } else {
            System.out.println(type + " dañado, salud restante: " + health);
        }
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
    
    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
    
    @Override
    public String toString() {
        return type + "{posicion=(" + x + ", " + y + "), salud=" + health + 
               ", estrategia=" + (moveStrategy != null ? moveStrategy.getStrategyName() : "Ninguna") + "}";
    }
} 