package src.main.Singleton;

/**
 * Implementación del patrón Singleton para gestionar el estado del juego
 * Garantiza una única instancia que controla puntuación, nivel y estado del juego
 */
public class GameManager {
    
    // Instancia única (Singleton)
    private static GameManager instance;
    
    // Variables de estado del juego
    private int score;
    private int level;
    private boolean gameRunning;
    private boolean gamePaused;
    
    /**
     * Constructor privado para evitar instanciación directa
     */
    private GameManager() {
        this.score = 0;
        this.level = 1;
        this.gameRunning = false;
        this.gamePaused = false;
    }
    
    /**
     * Método para obtener la instancia única del GameManager
     * Implementa lazy initialization
     */
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }
    
    /**
     * Inicia el juego
     */
    public void startGame() {
        this.gameRunning = true;
        this.gamePaused = false;
        System.out.println("¡Juego iniciado! Nivel: " + level);
    }
    
    /**
     * Pausa el juego
     */
    public void pauseGame() {
        if (gameRunning) {
            this.gamePaused = true;
            System.out.println("Juego pausado");
        }
    }
    
    /**
     * Reanuda el juego
     */
    public void resumeGame() {
        if (gameRunning) {
            this.gamePaused = false;
            System.out.println("Juego reanudado");
        }
    }
    
    /**
     * Termina el juego
     */
    public void endGame() {
        this.gameRunning = false;
        this.gamePaused = false;
        System.out.println("¡Juego terminado! Puntuación final: " + score);
    }
    
    /**
     * Añade puntos al jugador
     */
    public void addScore(int points) {
        this.score += points;
        System.out.println("¡Puntos ganados! +" + points + " (Total: " + score + ")");
        
        // Subir de nivel cada 1000 puntos
        if (score >= level * 1000) {
            levelUp();
        }
    }
    
    /**
     * Sube de nivel
     */
    private void levelUp() {
        this.level++;
        System.out.println("¡NIVEL " + level + " ALCANZADO!");
    }
    
    /**
     * Reinicia el juego
     */
    public void resetGame() {
        this.score = 0;
        this.level = 1;
        this.gameRunning = false;
        this.gamePaused = false;
        System.out.println("Juego reiniciado");
    }
    
    // Getters y Setters
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public boolean isGameRunning() {
        return gameRunning;
    }
    
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
    
    public boolean isGamePaused() {
        return gamePaused;
    }
    
    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }
    
    @Override
    public String toString() {
        return "GameManager{score=" + score + ", level=" + level + 
               ", running=" + gameRunning + ", paused=" + gamePaused + "}";
    }
} 