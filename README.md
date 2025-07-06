# Space Invaders - Patrones de Diseño

## Descripción
Implementación del clásico juego Space Invaders en Java utilizando los siguientes patrones de diseño:

### Patrones Implementados

1. **Singleton** - `GameManager`
   - Controla la instancia única del juego
   - Maneja puntuación, nivel, estado del juego
   - Garantiza una sola instancia en toda la aplicación

2. **Factory** - `EnemyFactory`
   - Crea diferentes tipos de enemigos (Alien, UFO)
   - Encapsula la lógica de creación de objetos
   - Permite fácil extensión para nuevos tipos de enemigos

3. **Strategy** - `MoveStrategy`
   - Permite cambiar el comportamiento de movimiento de los enemigos
   - Implementaciones: MoveLeft, MoveRight
   - Cambio dinámico de estrategia en tiempo de ejecución

## Estructura del Proyecto
```
src/
├── main/
│   ├── Game.java                 # Clase principal del juego
│   ├── Player.java               # Jugador principal
│   ├── Singleton/
│   │   └── GameManager.java     # Patrón Singleton
│   ├── Factory/
│   │   ├── EnemyFactory.java    # Patrón Factory
│   │   ├── Enemy.java           # Clase base para enemigos
│   │   ├── Alien.java           # Tipo de enemigo
│   │   └── UFO.java             # Tipo de enemigo
│   └── Strategy/
│       ├── MoveStrategy.java     # Interfaz Strategy
│       ├── MoveLeft.java         # Estrategia de movimiento
│       ├── MoveRight.java        # Estrategia de movimiento
│       └── EnemyWithStrategy.java # Enemigo con Strategy
```

## Cómo Ejecutar
1. Compilar: `javac src/main/*.java src/main/*/*.java`
2. Ejecutar: `java src.main.Game`

## Características del Juego
- Sistema de puntuación
- Múltiples tipos de enemigos
- Diferentes estrategias de movimiento
- Gestión centralizada del estado del juego 