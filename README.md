# <h1>Challenge SONDEOS</h1>
---
<h3>Desarrollo de API Rest con lenguaje de programación JAVA</h3>

Se desarrolló una API Rest con tecnologías Full Stack:

<h4><img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/check.png"> Backend:</h4> Se usó JAVA como lenguaje de programación y Spring para desarrollar el modelo clase que se usó en la API, desarrollando también el repositorio y el controlador correspondiente a dicha clase. Esto permite dar funcionalidad a la WebAPP como:

1) Ver la información registrada.
2) Registrar un nuevo libro completando los datos necesarios.
3) Modificar un libro por su título, su autor, su fecha de publicación o actualizar el precio.
4) Eliminar un libro del repositorio.

Para testear dicha aplicación se usó un test de integración que permite verificar si un libro existe en el repositorio ó si algún repositorio contiene información. Para hacer uso de este test se debe comentar las líneas de códigos donde se configura la encriptación de la contraseña del usuario, esto debido a que se agregó una capa de seguridad y se usó la configurción para encriptar dicha contraseña. El almacenamiento de datos se hace a través de la base de datos H2.

El desarrollo de esta aplicación se hizo a través de IntelliJ IDEA.

# <h4><img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/check.png"> Frontend:</h4> Para el desarrollo frontend se usó HTML5, CSS, JavaScript, los frameworks de Vue.js, SweetAlert , Moment.js y Numeral.js; de igual forma se usó la biblioteca de Bootstrap. Para mostrar la información de los libros en el repositorio se hace un llamado a la API a través de Axios.
---
<h3>Uso de la WebAPP</h3>

Para hacer uso de la WebAPP lo primero que se debe hacer es iniciar sesión esto se debe a que se le fue añadida una capa de seguridad que permite que únicamente un usuario registrado y autenticado pueda acceder al sistema. Los datos para acceder al sistema son:

<strong>Usuario:</strong> admin <br>
<strong>Contraseña:</strong> admin

<img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/inicio-sesion.png" height="150">

Una vez ingresado al sistema se puede obervar el panel principal donde se muestra un formulario de registro para títulos nuevos que se deseen registrar y una tabla con la lista de los libros registrados misma que se actualiza cada vez que se registra uno nuevo.

<img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/panel-principal.png" height="150">

Para comenzar el registro de un nuevo título se debe rellenar todos y cada uno de los campos de manera individual; una vez completado los campos va a solicitar la confirmación del registro. Cabe destacar que si un título ya existe en el repositorio el sistema va a arrojar un error, de la misma manera si el usuario introduce un valor cero (0) o negativo en el precio del libro el sitema arrojará un error con los mensajes correspondientes.

<img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/registro.png" height="150"> <img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/registro-confirmacion.png" height="150">

En la tabla de información se muestra todos los datos relacionados al registro de cada libro (título, autor, fecha de publicación y precio). También se muestran dos (02) opciones en cada fila de información, la primera para acceder a los detalles de los libros y poder modificarlos y la segunda opción para poder eliminar cada libro individualmente.

<img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/eliminar-confirmacion.png" height="150"> <img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/eliminar-exitoso.png" height="150"> 

Por útlimo tenemos el panel de modificación donde el usuario puede cambiar cada dato del libro registrado, como se puede obervar, para el cambio del título se debe hacer de manera individual ya que se evalúa si el nuevo título a registrar ya existe en el repositorio. De existir en el repositorio el sistema arrojará un error con el mensaje correspondiente.

# <img src="https://github.com/misaeljlo91/Library/blob/master/src/main/resources/static/web/assets/front-end/panel-modificacion.png" height="150">
---
