package factorymethod.main;

import java.util.Properties;
import factorymethod.impl.MySQLDBAdapter;
import factorymethod.impl.OracleDBAdapter;
import factorymethod.util.PropertiesUtil;

public class DBFactory {

	private static final String DB_FACTORY_PROPERTY_URL = "resources/DBFactory.properties";
	private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

	public static IDBAdapter getDBadapter(DBType dbType) {
		switch (dbType) {
		case MySQL:
			return new MySQLDBAdapter();
		case Oracle:
			return null;
		default:
			throw new IllegalArgumentException("No soportado");
		}
	}

	public static IDBAdapter getDefaultDBAdapter() {
		try {
			Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
			String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
			System.out.println("DefaultDBClass ==> " + defaultDBClass);

			return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}