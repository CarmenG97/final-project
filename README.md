# POCKET UNIVERSE - Desmontando la astrología

### Proyecto de astrofísica
<p align="center">
    <img src = 'James_Webb.jpg' width='450'>
</p>

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Bienvenido a un proyecto donde aprenderás sobre constelaciones y estrellas, a la vez que desmontas el gran mito de la astrología. Descubre qué es una enana blanca, cómo ver Aries
en el cielo y apúntate a ver la lluvia de estrellas en los eventos disponibles!
<p align="center">
<img src = '' width='250'>

-----------------------------------------------------------------------------------------------------------------------------------------

###  Backend

El trabajo consta de cuatro bases de datos: una de estrellas, otra de constelaciones, una de amatteurs y otra de eventos. Esta información se trabaja en el backend de JAVA 
en cinco microservicios proxy, un edge (puerto 8080) y el eureka server donde se realizan peticiones http de tipo GET y POST que manipulan los datos de MySQL.

Estas peticiones se reciben en el frontem de Angular mediente la capa de servicios en el puerto 4200.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

###  MODELO DE USO

Para que el programa funcione, debe levantar los servidores del backend en JAVA. 
- Primero se levanta el Eureka Server.
- A continuación se levantan los microservicios proxy en el orden que prefiera (su orden natural sería: starCoordinates, Stars, Contellations, Amatteurs, Events)
- Por último, se levanta el microservicio edge en el puerto 8080. Este es el encargado de mandar y recibir la información del frotend.

Por último, levante el programa en Angular con el comando "ng serve" en la terminal y disfrute de la magia.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
¡Muchas gracias!
