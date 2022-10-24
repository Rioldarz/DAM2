import pymysql


def consultarWhere(nombre):
    try:
        conexion = pymysql.connect(host='192.168.9.130',
                                   user='user',
                                   password='test',
                                   db='myDb')
        try:
            with conexion.cursor() as cursor:

                consulta = "SELECT nombre, edad, ciudad, padre, madre FROM Practica2 WHERE nombre like %s;"
                cursor.execute(consulta, nombre)

                # Con fetchall traemos todas las filas
                usuarios = cursor.fetchall()

                # Recorrer e imprimir
                for usuario in usuarios:
                    print(usuario)
        finally:
            conexion.close()

    except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
        print("Ocurrió un error al conectar: ", e)


def consultarTodos():
    try:
        conexion = pymysql.connect(host='192.168.9.130',
                                   user='user',
                                   password='test',
                                   db='myDb')
        try:
            with conexion.cursor() as cursor:
                # En este caso no necesitamos limpiar ningún dato
                cursor.execute("SELECT nombre, edad, ciudad, padre, madre FROM Practica2;")

                # Con fetchall traemos todas las filas
                usuarios = cursor.fetchall()

                # Recorrer e imprimir
                for usuario in usuarios:
                    print(usuario)
        finally:
            conexion.close()

    except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
        print("Ocurrió un error al conectar: ", e)


def edita(nombre, edad, ciudad, padre, madre):
    try:
        conexion = pymysql.connect(host='192.168.9.130',
                                   user='user',
                                   password='test',
                                   db='myDb')
        try:
            if (edad > 0):
                with conexion.cursor() as cursor:
                    consulta = "UPDATE Practica2 SET edad = %s WHERE nombre = %s;"
                    nueva_edad = edad
                    nombre_editar = nombre
                    cursor.execute(consulta, (nueva_edad, nombre_editar))

            if (ciudad != ""):
                with conexion.cursor() as cursor:
                    consulta = "UPDATE Practica2 SET ciudad = %s WHERE nombre = %s;"
                    nueva_ciudad = ciudad
                    nombre_editar = nombre
                    cursor.execute(consulta, (nueva_ciudad, nombre_editar))

            if (padre != ""):
                with conexion.cursor() as cursor:
                    consulta = "UPDATE Practica2 SET padre = %s WHERE nombre = %s;"
                    nuevo_padre = padre
                    nombre_editar = nombre
                    cursor.execute(consulta, (nuevo_padre, nombre_editar))

            if (madre != ""):
                with conexion.cursor() as cursor:
                    consulta = "UPDATE Practica2 SET madre = %s WHERE nombre = %s;"
                    nueva_madre = madre
                    nombre_editar = nombre
                    cursor.execute(consulta, (nueva_madre, nombre_editar))

            # No olvidemos hacer commit cuando hacemos un cambio a la BD
            conexion.commit()
        finally:
            conexion.close()

    except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
        print("Ocurrió un error al conectar: ", e)


def eliminar(nombre):
    try:
        conexion = pymysql.connect(host='192.168.9.130',
                                   user='user',
                                   password='test',
                                   db='myDb')
        try:
            with conexion.cursor() as cursor:

                consulta = "DELETE FROM Practica2 WHERE nombre like %s;"
                nombre = nombre
                cursor.execute(consulta, (nombre))

            # No olvidemos hacer commit cuando hacemos un cambio a la BD
            conexion.commit()
        finally:
            conexion.close()

    except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
        print("Ocurrió un error al conectar: ", e)


def insertar(nombre, edad, ciudad, padre, madre):
    try:
        conexion = pymysql.connect(host='192.168.9.130',
                                   user='user',
                                   password='test',
                                   db='myDb')
        try:
            with conexion.cursor() as cursor:
                consulta = "INSERT INTO Practica2 VALUES (%s, %s, %s, %s, %s);"
                # Podemos llamar muchas veces a .execute con datos distintos
                cursor.execute(consulta, (nombre, edad, ciudad, padre, madre))

            conexion.commit()
        finally:
            conexion.close()
    except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
        print("Ocurrió un error al conectar: ", e)


consultarWhere('Luis')
print("")
consultarTodos()
print("")
edita("Luis", 0, "Sevilla", "Diosito", "La Virgen")
print("")
consultarTodos()
print("")
eliminar("Miguel")
print("")
consultarTodos()
print("")
insertar("Jose Miguel", 32, "Sevilla", "Jesus Cristo", "Maria Magdalena")
print("")
consultarTodos()
print("")