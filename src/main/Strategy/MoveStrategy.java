package src.main.Strategy;

/**
 * Interfaz que define el contrato para las estrategias de movimiento
 * Implementación del patrón Strategy
 */
public interface MoveStrategy {
    
    /**
     * Ejecuta la estrategia de movimiento
     * @param x Posición X actual
     * @param y Posición Y actual
     * @return Array con las nuevas posiciones [nuevaX, nuevaY]
     */
    int[] move(int x, int y);
    
    /**
     * Obtiene el nombre de la estrategia
     * @return Nombre de la estrategia
     */
    String getStrategyName();
} 