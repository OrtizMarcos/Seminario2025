@echo off
echo Ejecutando Space Invaders - Patrones de Diseño...
echo.

REM Verificar si existe el directorio bin
if not exist "bin" (
    echo Error: El proyecto no ha sido compilado.
    echo Ejecuta compile.bat primero.
    echo.
    pause
    exit /b 1
)

REM Ejecutar el juego
java -cp bin src.main.Game

echo.
echo Juego terminado.
pause 