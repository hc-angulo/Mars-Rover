# Mars Rover

## Índice
- [1. Introducción](#item1)
- [2. Requisitos del proyecto](#item2)
- [3. Acerca del juego](#item3)
- [4. Cómo jugar](#item4)
- [5. Configuración del Proyecto](#item5)
- [6. Demo](#item6)
- [7. Herramientas de desarrollo](#item7)

<a name="item1"></a>
### Introducción
El proyecto Mars Rover, basado en la consigna y los requerimientos del [Mars Rover Kata](https://kata-log.rocks/mars-rover-kata), se centra en la exploración del planeta Marte mediante el envío de rovers controlados remotamente a la superficie del planeta. El objetivo principal es desarrollar una API REST que traduzca los comandos enviados desde la Tierra a instrucciones que el rover pueda entender, usando para esto **Spring Boot** y **Thymeleaf** como principales herramientas de desarrollo, 

<a name="item2"></a>
### Requisitos del Proyecto

**Punto de Partida Inicial**
Se proporciona al rover un punto de partida inicial (x, y) en el planeta Marte, junto con la dirección en la que apunta (Norte, Sur, Este u Oeste).

**Comandos**
El rover recibe una serie de comandos que pueden ser:

- Mover hacia adelante (F) o hacia atrás (B).
- Girar hacia la izquierda (L) o hacia la derecha (R).

**Envoltura en los Bordes**
Ten en cuenta que el planeta es una esfera. Esto significa que si el rover se encuentra en el borde y recibe un comando para moverse hacia adelante, debería aparecer en el lado opuesto del planeta, como si hubiera cruzado de un lado al otro.

**Detección de Obstáculos**
Antes de cada movimiento a una nueva plaza, se debe verificar si hay un obstáculo en el camino del rover. Si se encuentra un obstáculo, el rover debe detenerse en el punto anterior y notificar la presencia del obstáculo.

<a name="item3"></a>
### Acerca del juego

**Posición inicial del Rover:** Al comenzar el juego, y cada vez que reiniciemos este, el rover se ubicará en una posición inicial predeterminada, x=0, y=0, Cardinalidad = Norte.

**Instrucciones:** Deberás proporcionar una serie de instrucciones al rover para que se mueva. Las instrucciones válidas son:

- F o f: Mover hacia adelante.
- B o b: Mover hacia atrás.
- L o l: Gira el rover hacia la izquierda (cambia su dirección en sentido antihorario).
- R o r: Gira el rover hacia la derecha (cambia su dirección en sentido horario).

**Consideraciones:** Para este juego hemos considerado una grilla representativa del planeta Marte de tamaño 5x5.

**Objetivo del juego:** Tu objetivo es llevar el rover a una posición específica en el mapa de Marte.

**Obstáculos:** Ten cuidado con los obstáculos en Marte. Si el rover se encuentra con un obstáculo, detendrá su movimiento y recibirás una notificación.

**Resumen de Jugada:** Después de cada jugada, recibirás un resumen informativo que incluirá la posición inicial, la posición final, las instrucciones ejecutadas y cualquier obstáculo encontrado.

**Historial de Movimientos:** También podrás ver un historial de todos los movimientos realizados por el rover.

**Persistencia de Datos:** Se utiliza una base de datos para almacenar la información sobre la posición del rover y los obstáculos en Marte.

<a name="item4"></a>
### Cómo jugar
1. Comienza en la página principal del juego.
2. Presiona el botón "Comenzar Juego" para iniciar una nueva partida.
3. En la página de "Instrucciones", ingresa una secuencia de instrucciones válidas y presiona "Enviar Instrucciones".
4. El rover ejecutará las instrucciones y recibirás un informe con los resultados.
5. Tendrás la opción de "Reiniciar juego" o "Continuar juego". Si eliges la primera, se volverán a generar, de forma aleatoria, las posiciones de tus nuevos obstáculos y tu rover volverá a posicionarse en x=0, y=0, Cardinalidad=Norte. Si decides continuar con tu juego, tu punto de partida será la posición final de tu jugada anterior y tus obstáculos serán los mismos que cuando iniciaste el juego.
6. Si en algún momento te sientes perdido, puedes consultar la sección "help" en la parte superior de la página.

**Ejecutando una instrucción:** Veamos, con un ejemplo, cómo se vería el resultado de una instrucción enviada por un jugador. Supongamos que el Rover, antes de ejecutar la instrucción, se encuentra en la posición x=1, y=2, Cardinalidad = Este. Se envía el conjunto de instrucciones "FFR":
- La primera de estas instrucciones, "F", conducirá al Rover a la posición x=2, y=2, Cardinalidad = Este.
- La segunda de estas instrucciones, "F", conducirá al Rover a la posición x=3, y=2, Cardinalidad = Este.
- La tercera, y última, de estas instrucciones, "R", conducirá al Rover a la posición x=3, y=2, Cardinalidad = Sur.

<a name="item5"></a>
### Configuración del Proyecto
El proyecto se compone de varias clases y componentes, incluyendo:

- **RoverPosition:** Representa la posición actual del rover en la cuadrícula de Marte, incluyendo sus coordenadas (x, y) y su orientación (Norte, Sur, Este u Oeste).
- **Obstacle:** Representa un obstáculo en la cuadrícula de Marte, con coordenadas (x, y).
- **Instruction:** Clase de utilidad para validar y procesar las instrucciones ingresadas por el jugador.
- **MovementService:** Contiene la lógica para mover el rover hacia adelante, hacia atrás, a la izquierda y a la derecha, verificando obstáculos en el camino.
- **RoverPositionService:** Administra las posiciones del rover, almacena el histórico de movimientos y procesa las instrucciones del jugador.
- **ObstacleService:** Administra los obstáculos en la cuadrícula de Marte y genera obstáculos de forma aleatoria.


<a name="item6"></a>
### Demo

<a name="item7"></a>
### Herramientas

<p align="left"> 
   <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="Spring Boot" width="100" height="100"/>
  <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="Java" width="100" height="100"/>
    <a href="https://www.mysql.com/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" alt="MySQL" width="100" height="100"/>
</p>

