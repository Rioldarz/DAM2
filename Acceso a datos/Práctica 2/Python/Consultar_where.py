import pymysql
try:
    conexion = pymysql.connect(host='192.168.9.130',
                               user='user',
                               password='test',
                               db='myDb')
    try:
        with conexion.cursor() as cursor:

            consulta = "SELECT nombre, edad, ciudad, padre, madre FROM Practica2 WHERE nombre like %s;"
            cursor.execute(consulta, 'Luis')

            # Con fetchall traemos todas las filas
            usuarios = cursor.fetchall()

            # Recorrer e imprimir
            for usuario in usuarios:
                print(usuario)
    finally:
        conexion.close()

except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
    print("Ocurrió un error al conectar: ", e)
