import pymysql

try:
    conexion = pymysql.connect(host='192.168.9.130',
                               user='user',
                               password='test',
                               db='myDb')
    try:
        with conexion.cursor() as cursor:

            consulta = "UPDATE Practica2 SET padre = %s WHERE nombre = %s;"
            nuevo_padre = "Diosito"
            nombre_editar = 'Luis'
            cursor.execute(consulta, (nuevo_padre, nombre_editar))

        # No olvidemos hacer commit cuando hacemos un cambio a la BD
        conexion.commit()
    finally:
        conexion.close()

except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
    print("Ocurrió un error al conectar: ", e)
