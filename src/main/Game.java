package src.main;

import src.main.Singleton.GameManager;
import src.main.Factory.EnemyFactory;
import src.main.Factory.Enemy;
import src.main.Strategy.EnemyWithStrategy;
import src.main.Strategy.MoveLeft;
import src.main.Strategy.MoveRight;

/**
 * Clase principal del juego Space Invaders
 * Demuestra la implementación de los patrones Singleton, Factory y Strategy
 */
public class Game {
    
    public static void main(String[] args) {
        System.out.println("=== SPACE INVADERS - PATRONES DE DISEÑO ===\n");
        
        // 1. DEMOSTRACIÓN DEL PATRÓN SINGLETON
        System.out.println("1. PATRÓN SINGLETON - GameManager");
        System.out.println("=====================================");
        
        GameManager gameManager1 = GameManager.getInstance();
        GameManager gameManager2 = GameManager.getInstance();
        
        System.out.println("Instancia 1: " + gameManager1);
        System.out.println("Instancia 2: " + gameManager2);
        System.out.println("¿Son la misma instancia? " + (gameManager1 == gameManager2));
        
        gameManager1.setScore(100);
        gameManager1.setLevel(1);
        System.out.println("Puntuación: " + gameManager2.getScore());
        System.out.println("Nivel: " + gameManager2.getLevel());
        System.out.println();
        
        // 2. DEMOSTRACIÓN DEL PATRÓN FACTORY
        System.out.println("2. PATRÓN FACTORY - EnemyFactory");
        System.out.println("=================================");
        
        EnemyFactory enemyFactory = new EnemyFactory();
        
        Enemy alien1 = enemyFactory.createEnemy("ALIEN", 50, 50);
        Enemy ufo1 = enemyFactory.createEnemy("UFO", 100, 100);
        Enemy alien2 = enemyFactory.createEnemy("ALIEN", 150, 50);
        
        System.out.println("Enemigo creado: " + alien1.getType() + " en posición (" + 
                          alien1.getX() + ", " + alien1.getY() + ")");
        System.out.println("Enemigo creado: " + ufo1.getType() + " en posición (" + 
                          ufo1.getX() + ", " + ufo1.getY() + ")");
        System.out.println("Enemigo creado: " + alien2.getType() + " en posición (" + 
                          alien2.getX() + ", " + alien2.getY() + ")");
        System.out.println();
        
        // 3. DEMOSTRACIÓN DEL PATRÓN STRATEGY
        System.out.println("3. PATRÓN STRATEGY - MoveStrategy");
        System.out.println("==================================");
        
        EnemyWithStrategy enemyWithStrategy = new EnemyWithStrategy("ALIEN", 200, 200);
        
        System.out.println("Posición inicial: (" + enemyWithStrategy.getX() + ", " + 
                          enemyWithStrategy.getY() + ")");
        
        // Usar estrategia de movimiento hacia la izquierda
        enemyWithStrategy.setMoveStrategy(new MoveLeft());
        enemyWithStrategy.move();
        System.out.println("Después de MoveLeft: (" + enemyWithStrategy.getX() + ", " + 
                          enemyWithStrategy.getY() + ")");
        
        // Cambiar a estrategia de movimiento hacia la derecha
        enemyWithStrategy.setMoveStrategy(new MoveRight());
        enemyWithStrategy.move();
        System.out.println("Después de MoveRight: (" + enemyWithStrategy.getX() + ", " + 
                          enemyWithStrategy.getY() + ")");
        
        // Volver a la izquierda
        enemyWithStrategy.setMoveStrategy(new MoveLeft());
        enemyWithStrategy.move();
        System.out.println("Después de MoveLeft: (" + enemyWithStrategy.getX() + ", " + 
                          enemyWithStrategy.getY() + ")");
        System.out.println();
        
        // 4. SIMULACIÓN DE JUEGO
        System.out.println("4. SIMULACIÓN DE JUEGO");
        System.out.println("=======================");
        
        Player player = new Player(400, 500);
        System.out.println("Jugador creado en posición: (" + player.getX() + ", " + player.getY() + ")");
        
        // Simular disparo del jugador
        player.shoot();
        System.out.println("¡Jugador dispara!");
        
        // Actualizar puntuación
        gameManager1.addScore(50);
        System.out.println("Nueva puntuación: " + gameManager1.getScore());
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
} 