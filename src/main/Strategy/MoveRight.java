package src.main.Strategy;

/**
 * Implementación de la estrategia de movimiento hacia la derecha
 */
public class MoveRight implements MoveStrategy {
    
    private int speed;
    
    public MoveRight() {
        this.speed = 5; // Velocidad por defecto
    }
    
    public MoveRight(int speed) {
        this.speed = speed;
    }
    
    @Override
    public int[] move(int x, int y) {
        // Mover hacia la derecha
        int newX = x + speed;
        
        // Mantener dentro de los límites de la pantalla
        if (newX > 800) {
            newX = 800;
        }
        
        return new int[]{newX, y};
    }
    
    @Override
    public String getStrategyName() {
        return "MoveRight";
    }
    
    /**
     * Obtiene la velocidad de movimiento
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * Establece la velocidad de movimiento
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
} 