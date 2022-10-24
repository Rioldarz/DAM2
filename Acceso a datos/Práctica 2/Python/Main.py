import pymysql


def menu():
    print("¿Qué desea hacer?:")
    print("\t1. Dar de alta a usuario")
    print("\t2. Modificar usuario")
    print("\t3. Eliminar usuario")
    print("\t4. Muestra usuarios")
    print("\t5. Buscar usuario")
    print("\t9. Salir")


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


while True:
    menu()
    opc = int(input("Opción: "))

    if opc == 1:
        nombre = input("¿Qué nombre desea dar de alta?: ")
        edad = int(input(f"¿Qué edad desea darle a {nombre}?: "))
        ciudad = input(f"¿De qué ciudad es {nombre}?: ")
        padre = input(f"¿Quién es el padre de {nombre}?: ")
        madre = input(f"¿Quién es la madre de {nombre}?: ")

        insertar(nombre, edad, ciudad, padre, madre)

    elif opc == 2:
        nombre = input("¿A quién desea modificar?: ")
        edad = 0
        ciudad = ""
        padre = ""
        madre = ""

        var = input("¿Desea cambiarle la edad? (S/N): ")
        if var == 's' or var == 'S':
            edad = int(input("¿Qué edad desea ponerle? (>0): "))

        var = input("¿Desea cambiarle la ciudad? (S/N): ")
        if var == 's' or var == 'S':
            ciudad = input("¿Qué ciudad desea ponerle? (!=""): ")

        var = input("¿Desea cambiarle el padre? (S/N): ")
        if var == 's' or var == 'S':
            padre = input("¿Qué padre desea ponerle? (!=""): ")

        var = input("¿Desea cambiarle la madre? (S/N): ")
        if var == 's' or var == 'S':
            madre = input("¿Qué madre desea ponerle? (!=""): ")

        edita(nombre, edad, ciudad, padre, madre)

    elif opc == 3:
        nombre = input("¿A quién desea eliminar?: ")

        eliminar(nombre)

    elif opc == 4:
        consultarTodos()

    elif opc == 5:
        nombre = input("¿A quién desea buscar?: ")
        consultarWhere(nombre)

    elif opc == 9:
        break

    print("")
