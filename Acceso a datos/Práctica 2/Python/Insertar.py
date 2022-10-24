import pymysql

try:
    conexion = pymysql.connect(host='192.168.9.130',
                               user='user',
                               password='test',
                               db='myDb')
    try:
        with conexion.cursor() as cursor:
            consulta = "INSERT INTO Practica2 VALUES (%s, %s, %s, %s, %s);"
            # Podemos llamar muchas veces a .execute con datos distintos
            cursor.execute(consulta, ("Miguel Angel", 23, "Sevilla", "Jose Antonio", "Margarita"))
            cursor.execute(consulta, ("Miguel", 32, "Madrid", "Samuel", "Maria"))
        conexion.commit()
    finally:
        conexion.close()
except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
    print("Ocurrió un error al conectar: ", e)
