package src.main.Factory;

/**
 * Clase Alien que extiende de Enemy
 * Representa un enemigo básico del juego Space Invaders
 */
public class Alien extends Enemy {
    
    public Alien(int x, int y) {
        super("ALIEN", x, y);
        this.health = 30;
        this.damage = 10;
        this.points = 100;
    }
    
    @Override
    public void behave() {
        // Comportamiento específico del Alien
        System.out.println("Alien en posición (" + x + ", " + y + ") se comporta de manera agresiva");
        
        // Los aliens tienen un 30% de probabilidad de disparar
        if (Math.random() < 0.3) {
            shoot();
        }
        
        // Los aliens se mueven de forma errática
        if (Math.random() < 0.5) {
            move();
        }
    }
    
    @Override
    public void move() {
        // Movimiento específico del Alien: se mueve horizontalmente
        int direction = (Math.random() < 0.5) ? -1 : 1;
        x += direction * 5;
        
        // Mantener dentro de los límites de la pantalla
        if (x < 0) x = 0;
        if (x > 800) x = 800;
        
        System.out.println("Alien se mueve a posición (" + x + ", " + y + ")");
    }
    
    @Override
    public void shoot() {
        System.out.println("Alien dispara un rayo verde desde posición (" + x + ", " + y + ")");
    }
    
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (health <= 0) {
            System.out.println("¡Alien destruido! +" + points + " puntos");
        }
    }
} 