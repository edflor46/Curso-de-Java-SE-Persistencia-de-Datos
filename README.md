# Curso de Java SE Persistencia de Datos

## Diseñando nuestra base de datos
![disenio_bd](https://res.cloudinary.com/dvhl6xkqf/image/upload/v1626676644/Academia-Java.-CDMX/persistencia/persistencia_xcstgy.png)

## Creando nuestra base de datos usando DDL

<pre>
    <code>
CREATE TABLE mensajes_app.mensajes(
id_mensaje INT(7) AUTO_INCREMENT,
mensaje VARCHAR(280) NOT NULL,
autor_mensaje VARCHAR(50) NOT NULL,
fecha_mensaje timestamp NOT NULL,
PRIMARY KEY(id_mensaje)
);
    </code>
</pre>
