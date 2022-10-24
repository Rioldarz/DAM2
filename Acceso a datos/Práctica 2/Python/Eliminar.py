import pymysql

try:
    conexion = pymysql.connect(host='192.168.9.130',
                               user='user',
                               password='test',
                               db='myDb')
    try:
        with conexion.cursor() as cursor:

            consulta = "DELETE FROM Practica2 WHERE nombre like %s;"
            nombre = 'Miguel Angel'
            cursor.execute(consulta, (nombre))

        # No olvidemos hacer commit cuando hacemos un cambio a la BD
        conexion.commit()
    finally:
        conexion.close()

except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
    print("Ocurrió un error al conectar: ", e)
