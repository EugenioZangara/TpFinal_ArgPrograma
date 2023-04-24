# TpFinal_ArgPrograma
# Proyecto de predicción de resultados de fútbol

Este proyecto en Java permite al usuario ingresar dos archivos CSV: uno con el fixture de un campeonato de fútbol y otro con los pronósticos de los resultados previstos por el usuario. El programa compara el fixture con los resultados finales y los pronósticos del usuario y devuelve un puntaje en función de si la predicción fue acertada.

## Cómo utilizar

Para utilizar este programa, siga estos pasos:

1. Ejecute el script BaseDatosProde.sql para generar la base de datos localmente. 
2. Ajuste los parámetros para acceder a la base de datos con sus credenciales en el archivo "ConnectionFactory.java", dentro del paquete "factory"
3. Compile el código fuente utilizando su herramienta de compilación preferida.
4. Ejecute el programa desde la línea de comandos o haciendo doble clic en el archivo JAR.
5. Los archivos con los resultados finales de los partidos y los pronóstico, deben encontrarse en la misma carpeta que el archivo compilado para su normal funcinamiento (en el repositorio se agregan un archivo "partidos.csv" con resultados y dos archivos "pronostico1.csv" y "pronostico2.csv" a modo de ejemplo).
6. Cuando se le solicite, ingrese el nombre del archivo CSV que contiene el fixture del campeonato de fútbol.
7. Cuando se le solicite, ingrese el nombre del archivo CSV que contiene los pronósticos de los resultados previstos por el usuario.
8. El programa calculará y mostrará el puntaje del usuario en función de la precisión de sus pronósticos.

## Formato de los archivos CSV

Los archivos CSV deben tener un formato específico para que el programa pueda leerlos correctamente.

### Archivo CSV del fixture

El archivo CSV del fixture debe contener una fila por cada partido del campeonato. Cada fila debe tener el siguiente formato:

<id>,<equipo A>,<equipo B>,<goles equipo A>,<goles equipo B> <Ronda>


Donde:

- `<id>` es la identificación del partido (numérica).
- `<equipo A>` es el nombre del equipo local, en formato "ARG", "ALE", "ING", etc.
- `<equipo B>` es el nombre del equipo visitante, en formato "ARG", "ALE", "ING", etc.
- `<goles equipo A>` es el número de goles marcados por el equipo local.
- `<goles equipo B>` es el número de goles marcados por el equipo visitante.
- `<ronda>` númeo de ronda del campeonato.

### Archivo CSV de pronósticos

El archivo CSV de pronósticos debe contener una fila por cada partido del campeonato. Cada fila debe tener el siguiente formato:

<Id>,<IdPartido>,<equipo>,<pronóstico>


Donde:

- `<Id>` identificación numérica del pronóstico.
- `<IdPartido>` identificación numérica del partido que pronostica.
- `<equipo>` nombre del equipo sobre el que se hace la predicción.
- `<resultado>` es el pronóstico del usuario para el resultado del partido. Debe ser una de las siguientes opciones: `G` si el usuario predice que ganará el equipo que especificó, `E` si el usuario predice que será un empate, o `P` si el usuario predice que ganará el equipo que especificó.

## Cálculo del puntaje

El puntaje del usuario se calcula comparando sus pronósticos con los resultados reales de los partidos. Por cada partido, si el pronóstico del usuario es correcto, se le otorga tres punto. Si su pronóstico es incorrecto, no se le otorgan puntos. Si pronostica un empate y acierta, se le asignará un punto. El puntaje total del usuario es la suma de los puntos obtenidos por cada partido.

