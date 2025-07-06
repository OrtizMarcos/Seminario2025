@echo off
echo Compilando Space Invaders - Patrones de Diseño...
echo.

REM Crear directorio bin si no existe
if not exist "bin" mkdir bin

REM Listar todos los archivos .java en sources.txt
dir /S /B src\main\*.java > sources.txt

REM Compilar todos los archivos Java listados
del /Q bin\*.class >nul 2>&1
javac -d bin @sources.txt

REM Eliminar el archivo temporal de fuentes
del sources.txt

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilacion exitosa!
    echo Para ejecutar el juego, usa: java -cp bin src.main.Game
    echo.
) else (
    echo.
    echo Error en la compilacion!
    echo.
)

pause 