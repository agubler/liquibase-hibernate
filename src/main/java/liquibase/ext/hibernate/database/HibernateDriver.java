package liquibase.ext.hibernate.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class HibernateDriver implements Driver {

    public Connection connect(String url, Properties info) throws SQLException {
	return new HibernateConnection(url);
    }

    public boolean acceptsURL(String url) throws SQLException {
	return ConfigType.forUrl(url) != null;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
	return new DriverPropertyInfo[0];
    }

    public int getMajorVersion() {
	return 0;
    }

    public int getMinorVersion() {
	return 0;
    }

    public boolean jdbcCompliant() {
	return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
	throw new SQLFeatureNotSupportedException();
    }
}
