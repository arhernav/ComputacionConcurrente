# Práctica 1: Exploración de la Concurrencia

Esta práctica se enfoca en destacar los beneficios inherentes del uso de programas concurrentes. Se busca medir la mejora obtenida al emplear operaciones concurrentes y compararla con la teoría de la Ley de Amdahl.

Cada ejercicio incluirá una comparativa entre los tiempos de ejecución secuenciales y concurrentes. Además, se analizará la aceleración lograda en la solución concurrente en relación con los principios de la Ley de Amdahl. Para realizar estas comparaciones, se presentarán tablas con los siguientes datos:

- Número de hilos
- Aceleración teórica
- Aceleración obtenida
- Porcentaje de código paralelo

## Ejercicio 1: Identificación de Números Primos

El objetivo de este ejercicio es implementar una función que determine si un número entero es primo o no. En la clase `PrimeNumberCalculator`, debe implementar el método `isPrime(int n)` que realizará esta verificación. La clase `PrimeNumberCalculatorTest` contiene las pruebas unitarias que se utilizarán para verificar la corrección de la implementación. El constructor de la clase `PrimeNumberCalculator` recibe como argumento el número de hilos que se utilizarán en el método `isPrime(int n)` para resolver el problema.

El algoritmo propuesto para esta solución es el siguiente: dado un número entero $N$ y $M$ hilos, se divide el segmento $[2,N−1]$ en $M$ partes iguales y se asigna cada subsegmento a un hilo. Cada hilo se encarga de verificar si algún número del segmento asignado divide a $N$. Al final, se reporta si alguno de los hilos encontró un divisor para $N$ en su segmento asignado. En caso afirmativo, el método devuelve `false`; de lo contrario, devuelve `true`.

## Ejercicio 2: Cálculo del Promedio

Dada una matriz de enteros, el objetivo es encontrar el promedio de la suma de sus elementos. En la clase `MatrixUtils`, se debe completar la implementación del método `findAverage(int[][] matrix)` que calculará este promedio.

El algoritmo propuesto para esta solución es el siguiente: dado un número de hilos $N$, se divide la matriz en $N$ o más submatrices de tamaños similares y se asigna una o más matrices a cada hilo. Cada hilo reporta el promedio de la matriz en la que trabajó en un arreglo. Posteriormente, en una pasada secuencial, se calcula el promedio de ese arreglo, el cual se reporta como el promedio de la submatriz correspondiente. Luego, se calcula el promedio de todas las submatrices para obtener el promedio total de la matriz.

## Entregables

Es necesario presentar `3` archivos para la entrega: `2` archivos Java, `MatrixUtils.java` y `PrimeNumberCalculator.java`, junto con una captura de pantalla que evidencie la ejecución exitosa del archivo `muls.java`. Adicionalmente, se solicita incluir en un comentario privado los nombres de los integrantes del equipo.

- Se permite la importación de las bibliotecas necesarias para llevar a cabo la práctica.
- Los participantes pueden crear todos los métodos auxiliares, atributos, etc., que sean necesarios para completar la práctica.
- La calificación se compone de un 80% en las pruebas unitarias junto con el correcto funcionamiento de la práctica, y un 20% se evaluará la calidad del código.
