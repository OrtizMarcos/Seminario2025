package src.main.Strategy;

/**
 * Implementación de la estrategia de movimiento hacia la izquierda
 */
public class MoveLeft implements MoveStrategy {
    
    private int speed;
    
    public MoveLeft() {
        this.speed = 5; // Velocidad por defecto
    }
    
    public MoveLeft(int speed) {
        this.speed = speed;
    }
    
    @Override
    public int[] move(int x, int y) {
        // Mover hacia la izquierda
        int newX = x - speed;
        
        // Mantener dentro de los límites de la pantalla
        if (newX < 0) {
            newX = 0;
        }
        
        return new int[]{newX, y};
    }
    
    @Override
    public String getStrategyName() {
        return "MoveLeft";
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