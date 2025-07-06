package src.main.Factory;

/**
 * Implementación del patrón Factory para crear enemigos
 * Encapsula la lógica de creación de diferentes tipos de enemigos
 */
public class EnemyFactory {
    
    /**
     * Crea un enemigo del tipo especificado
     * @param enemyType Tipo de enemigo ("ALIEN" o "UFO")
     * @param x Posición X
     * @param y Posición Y
     * @return Instancia del enemigo creado
     */
    public Enemy createEnemy(String enemyType, int x, int y) {
        switch (enemyType.toUpperCase()) {
            case "ALIEN":
                System.out.println("Factory: Creando Alien en posición (" + x + ", " + y + ")");
                return new Alien(x, y);
                
            case "UFO":
                System.out.println("Factory: Creando UFO en posición (" + x + ", " + y + ")");
                return new UFO(x, y);
                
            default:
                System.out.println("Factory: Tipo de enemigo desconocido '" + enemyType + "', creando Alien por defecto");
                return new Alien(x, y);
        }
    }
    
    /**
     * Crea un enemigo con posición aleatoria
     * @param enemyType Tipo de enemigo
     * @return Instancia del enemigo creado
     */
    public Enemy createEnemyRandomPosition(String enemyType) {
        int x = (int) (Math.random() * 800); // Posición X aleatoria
        int y = (int) (Math.random() * 200); // Posición Y aleatoria en la parte superior
        
        return createEnemy(enemyType, x, y);
    }
    
    /**
     * Crea múltiples enemigos del mismo tipo
     * @param enemyType Tipo de enemigo
     * @param count Cantidad de enemigos a crear
     * @return Array de enemigos creados
     */
    public Enemy[] createEnemyGroup(String enemyType, int count) {
        Enemy[] enemies = new Enemy[count];
        
        for (int i = 0; i < count; i++) {
            int x = 50 + (i * 100); // Distribuir horizontalmente
            int y = 50 + ((i / 5) * 50); // Distribuir en filas
            enemies[i] = createEnemy(enemyType, x, y);
        }
        
        System.out.println("Factory: Creado grupo de " + count + " " + enemyType + "s");
        return enemies;
    }
    
    /**
     * Crea una oleada mixta de enemigos
     * @param alienCount Cantidad de Aliens
     * @param ufoCount Cantidad de UFOs
     * @return Array de enemigos creados
     */
    public Enemy[] createMixedWave(int alienCount, int ufoCount) {
        int totalEnemies = alienCount + ufoCount;
        Enemy[] enemies = new Enemy[totalEnemies];
        
        // Crear Aliens
        for (int i = 0; i < alienCount; i++) {
            int x = 50 + (i * 80);
            int y = 50;
            enemies[i] = createEnemy("ALIEN", x, y);
        }
        
        // Crear UFOs
        for (int i = 0; i < ufoCount; i++) {
            int x = 100 + (i * 120);
            int y = 100;
            enemies[alienCount + i] = createEnemy("UFO", x, y);
        }
        
        System.out.println("Factory: Creada oleada mixta con " + alienCount + " Aliens y " + ufoCount + " UFOs");
        return enemies;
    }
} 