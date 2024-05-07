# Práctica 7: El problema de las 9 Reinas

El problema de las 9 reinas es un problema clásico de optimización combinatoria que consiste en encontrar la forma de colocar 9 reinas en un tablero de ajedrez de 9x9 casillas, de tal manera que ninguna de ellas se ataque entre sí.

## Ejercicio 1

El problema de las 9 reinas consiste en encontrar una disposición de 9 reinas en un tablero de ajedrez de 9x9 casillas, de tal manera que ninguna reina pueda atacar a otra. Es decir, ninguna reina debe estar alineada en la misma fila, columna o diagonal (principal o secundaria) con otra reina.

Para implementar una solución utilizando hilos y concurrencia, se puede seguir estos pasos:

- Representar el tablero de ajedrez como una matriz de 9x9, donde cada casilla puede tener el valor de 0 (vacío) o 1 (ocupado por una reina).

- Crear 9 hilos, uno por cada fila del tablero. Cada hilo se encargará de colocar una reina en su respectiva fila, buscando una columna válida donde ubicarla.

- Utilizar mecanismos de sincronización, como semáforos o monitores, para asegurar que:
   - Cada hilo pueda acceder a la matriz del tablero de forma exclusiva para verificar si una posición está disponible.
   - Ninguna reina se coloque en la misma columna o diagonal que otra.

- Implementar un algoritmo backtracking para encontrar una solución válida. Cuando un hilo no pueda colocar una reina en su fila sin violar las restricciones, deberá retroceder y probar con otra columna.

- Mantener un contador global que indique cuántas soluciones válidas se han encontrado. Esto permitirá saber cuántas configuraciones distintas de 9 reinas cumplen con las restricciones.

- (Opcional) Imprimir la matriz final del tablero, mostrando la ubicación de las 9 reinas, una vez que se haya encontrado una solución válida.

Al utilizar hilos y concurrencia, se puede explorar el espacio de soluciones de manera más eficiente, ya que cada hilo se encargará de una fila del tablero de forma independiente. Esto puede acelerar el proceso de búsqueda de una solución, especialmente en problemas de mayor tamaño.

Es importante tener en cuenta los desafíos de sincronización y evitar condiciones de carrera al acceder a la matriz del tablero. El uso adecuado de mecanismos de sincronización, como semáforos o monitores, será clave para garantizar la correcta ejecución del algoritmo.

## Entregables

Es necesario presentar un archivo para la entrega: un archivo Java `Nqueens.java`. Adicionalmente, se solicita incluir en un comentario privado los nombres de los integrantes del equipo.

- Se permite la importación de las bibliotecas necesarias para llevar a cabo la práctica.
- Los participantes pueden crear todos los métodos auxiliares, atributos, etc., que sean necesarios para completar la práctica.
- La calificación se compone de el correcto funcionamiento de la práctica y la calidad del código.

## Referencias

https://mathworld.wolfram.com/QueensProblem.html
