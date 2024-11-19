# Máquina de Snacks 🍫

Este proyecto simula el funcionamiento de una máquina expendedora de snacks en Java, permitiendo:

- Comprar snacks.
- Generar un ticket con el total de la compra.
- Agregar nuevos snacks al catálogo.

## Cómo usar

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/maquina-snacks.git
   cd maquina-snacks
   ```
2. Compila y ejecuta el proyecto:

   ```bash
    javac -d out src/maquina_snacks_archivos/presentacion/MaquinaSnacks.java
    java -cp out maquina_snacks_archivos.presentacion.MaquinaSnacks
   ```

Sigue las instrucciones del menú interactivo.

4. Estructura principal
  MaquinaSnacks: Lógica principal del programa.
  Snack: Modelo de los productos.
  Servicios para manejar snacks en memoria o con persistencia en archivos.
