# Práctica 2: Semáforos - El problema del productor-consumidor

La práctica 2 se centra en el problema del productor-consumidor y explorar su implementación utilizando semáforos en un entorno concurrente. El objetivo es comprender los beneficios y desafíos asociados con la programación concurrente.

## Ejercicio 1: El problema del Productor-Consumidor

El problema del productor-consumidor (también conocido como el problema del búfer limitado (bounded-buffer problem)) es un ejemplo clásico de sincronización de procesos. El problema describe dos procesos, el productor y el consumidor, que comparten un búfer de tamaño fijo. El trabajo del productor es generar datos y colocarlos en el búfer. Al mismo tiempo, el consumidor está consumiendo los datos de uno a la vez. El problema es asegurarse de que el productor no trate de añadir datos en el búfer si está lleno y que el consumidor no trate de eliminar datos de un búfer vacío.

La clase `Buffer` representa el buffer compartido entre el productor y el consumidor. Utiliza semáforos para controlar el acceso concurrente al buffer y garantizar la sincronización entre los productores y los consumidores. El buffer almacena los elementos producidos por el productor y los consume el consumidor.

La clase `Productor` implementa la lógica del productor en el problema del productor-consumidor. Su función es generar elementos y colocarlos en el buffer compartido.

La clase `Consumidor` representa el consumidor en el problema del productor-consumidor. Su tarea principal es consumir elementos del buffer compartido.

## Entregables

Es necesario presentar `4` archivos para la entrega: `3` archivos Java, `Buffer.java`, `Consumidor.java` y `Productor.java`; una captura de pantalla que evidencie la ejecución exitosa de los archivos `bbou.java` y `bbpc.java`. Adicionalmente, se solicita incluir en un comentario privado los nombres de los integrantes del equipo.

- Se permite la importación de las bibliotecas necesarias para llevar a cabo la práctica.
- Los participantes pueden crear todos los métodos auxiliares, atributos, etc., que sean necesarios para completar la práctica.
- La calificación se compone de el correcto funcionamiento de la práctica, la calidad del código y la ejecución correcta de los archivos `bbou.java` y `bbpc.java`.
