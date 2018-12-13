# Guerreros

> Establecimiento: Universidad de Belgrano

> Carrera: Tecnicatura en Programación en Computadoras

> Materia: Testing y Desarrollo de Software

> Profesor: Didier Renard

> Integrantes: Gabriel Espina - Pedro Rodriguez


## Introducción
Para este Trabajo Práctico Final, se desarrolla el juego de ‘Guerreros’, que consta de un minijuego desarrollado en Java, se lleva a cabo una interacción por consola, en el cual mediante distintos tipos de juego, uno o dos jugadores comienzan una batalla contra enemigos que poco a poco van evolucionando su fuerza, sus vidas y varias caracteristicas que serán vitales durante los enfrentamientos.

Para desarrollar la inteligencia de los guerreros, se llevo a cabo la implementación de código genético. Donde un jugador se enfrenta a una cantidad de cuatro enemigos, estos a medida que el mismo va pasando por niveles, van aumentando sus caracteristicas con respecto a vida, energia, estamina, ataque , defensa y demas.

Si bien los primeros niveles son fáciles de llevar, poco a poco el juego requiere mayor estrategia para vencer a los enemigos ya que los mismos cada vez se vuelven mas y mas invencibles.

## Desarrollo del juego

### Inicio
El juego comienza, y en primera instancia, pregunta por qué opción queremos movernos, si queremos iniciar un juego nuevo, ver los records guardados, ver algun tutorial para entender el mismo o simplemente finalizar el juego.

### Modo de Juego
Si elegimos inicar una partida nueva, debemos indicar que tipo de partida vamos a jugar, por lo cual pasamos a elegirla.

### Propiedades del Jugador
En este caso se desarrollara la jugabilidad con un solo jugador asi que pasamos a elegir la primera opción y pasamos a indicar nuestro nombre de usuario que utilizaremos durante los enfrentamientos

Ingresamos nuestro nombre, y pasamos al menu donde tendremos tiendas de habilidades, items y la asignación de puntos. También tenemos los detalles de nuestro jugador(nombre , puntos y que propiedades de la tienda tenemos comprados).

### Tienda Items
Pasamos a la tienda de items para ver que podemos comprar con los puntos que tenemos a mano. A primera vista se pueden comprar Items Activos e Items Pasivos. 

#### Items Activos
Tenemos disponible en la tienda cuatro items activos para comprar y hacer uso de los mismos, como podemos ver tenemos solo dos slots para utilizar. A la derecha de los items tenemos el precio de puntos que cuesta cada uno. Mientras mas efectivo en la batalla sea el item, mas caro será. 

- Elegimos una de las opciones y se despliega un detalle del msmo para realizar la compra 

- Elegimos el slot que vamos a utilizar y lo confirmamos

#### Items Pasivos
El camino de los items pasivos es el mismo que los activos, solo que sus acciones son diferentes ya que los mismos se ejecutan durante la partida sin intervencion del jugador

La compra de los mismos es exactamente igual, pero se puede apreciar la diferencia del costo de puntos, ya que cuestan solo 5 puntos todos por igual.



