# Práctica 4: Monitores - El problema del productor-consumidor

La práctica 2 se centra en el problema del productor-consumidor y explora su implementación utilizando semáforos en un entorno concurrente. En contraste, en esta práctica 4 abordaremos el mismo problema pero utilizando monitores como mecanismo de sincronización en lugar de semáforos. 

## Ejercicio 1: El problema del Productor-Consumidor con monitores

Al igual que en la práctica 2, el problema del productor-consumidor (también conocido como el problema del búfer limitado (bounded-buffer problem)) es un ejemplo clásico de sincronización de procesos. El problema describe dos procesos, el productor y el consumidor, que comparten un búfer de tamaño fijo.  

Sin embargo, en esta práctica implementaremos la sincronización utilizando monitores en lugar de semáforos. Los monitores proveen sincronización a nivel de objetos, permitiendo que sólo un hilo acceda a un método del objeto monitor a la vez.

La clase `Buffer` representará el monitor que implementa el buffer compartido entre el productor y el consumidor. Utilizará métodos sincronizados para controlar el acceso concurrente al buffer y garantizar la sincronización.

Las clases `Productor` y `Consumidor` serán similares a la práctica 2, implementando la lógica de producir y consumir elementos, pero accediendo al buffer compartido mediante sus métodos sincronizados.

## Entregables

Es necesario presentar `4` archivos para la entrega: `3` archivos Java, `Buffer.java`, `Consumidor.java` y `Productor.java`; una captura de pantalla que evidencie la ejecución exitosa de los archivos `bbmo.java` y `bbpc.java`. Adicionalmente, se solicita incluir en un comentario privado los nombres de los integrantes del equipo.

- Se permite la importación de las bibliotecas necesarias para llevar a cabo la práctica.
- Los participantes pueden crear todos los métodos auxiliares, atributos, etc., que sean necesarios para completar la práctica.
- La calificación se compone de el correcto funcionamiento de la práctica, la calidad del código y la ejecución correcta de los archivos `bbmo.java` y `bbpc.java`.
