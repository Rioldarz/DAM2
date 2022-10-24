import pymysql

try:
    conexion = pymysql.connect(host='192.168.9.130',
                               user='user',
                               password='test',
                               db='myDb')
    print("Conexión correcta")
except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
    print("Ocurrió un error al conectar: ", e)
