package src.main.Factory;

/**
 * Clase UFO que extiende de Enemy
 * Representa un enemigo más poderoso y avanzado del juego Space Invaders
 */
public class UFO extends Enemy {
    
    public UFO(int x, int y) {
        super("UFO", x, y);
        this.health = 60;
        this.damage = 20;
        this.points = 200;
    }
    
    @Override
    public void behave() {
        // Comportamiento específico del UFO
        System.out.println("UFO en posición (" + x + ", " + y + ") ejecuta patrón de ataque avanzado");
        
        // Los UFOs tienen un 50% de probabilidad de disparar (más agresivos)
        if (Math.random() < 0.5) {
            shoot();
        }
        
        // Los UFOs se mueven de forma más inteligente
        if (Math.random() < 0.7) {
            move();
        }
    }
    
    @Override
    public void move() {
        // Movimiento específico del UFO: patrón de vuelo en zigzag
        int direction = (Math.random() < 0.5) ? -1 : 1;
        x += direction * 8; // Se mueve más rápido
        y += 3; // También se mueve hacia abajo
        
        // Mantener dentro de los límites de la pantalla
        if (x < 0) x = 0;
        if (x > 800) x = 800;
        if (y > 600) y = 600;
        
        System.out.println("UFO ejecuta patrón de vuelo a posición (" + x + ", " + y + ")");
    }
    
    @Override
    public void shoot() {
        System.out.println("UFO dispara un rayo rojo potente desde posición (" + x + ", " + y + ")");
    }
    
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (health <= 0) {
            System.out.println("¡UFO destruido! +" + points + " puntos");
        } else {
            System.out.println("UFO dañado, salud restante: " + health);
        }
    }
    
    /**
     * Método específico del UFO para activar escudo
     */
    public void activateShield() {
        System.out.println("UFO activa escudo protector en posición (" + x + ", " + y + ")");
        this.health += 20; // Recupera algo de salud
    }
} 