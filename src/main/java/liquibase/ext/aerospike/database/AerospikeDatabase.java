package liquibase.ext.aerospike.database;

import com.aerospike.jdbc.AerospikeDriver;
import liquibase.CatalogAndSchema;
import liquibase.GlobalConfiguration;
import liquibase.configuration.ConfiguredValue;
import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

import java.util.HashSet;
import java.util.Set;

public class AerospikeDatabase extends AbstractJdbcDatabase {

    public static final String PRODUCT_NAME = "Aerospike";
    public static final String SHORT_PRODUCT_NAME = "aerospike";
    public static final Integer DEFAULT_PORT = 3300;

    @Override
    protected String getDefaultDatabaseProductName() {
        return PRODUCT_NAME;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection databaseConnection) throws DatabaseException {
        return true;

        //TODO: Need to figure out a way to make sure we are talking to Aerospike.
    }

    @Override
    public String getDefaultDriver(String url) {
        if (url.startsWith("jdbc:aerospike")) {
            return "com.aerospike.jdbc.AerospikeDriver";
        }

        return null;
    }

    @Override
    public String getShortName() {
        return SHORT_PRODUCT_NAME;
    }

    @Override
    public Integer getDefaultPort() {
        return DEFAULT_PORT;
    }

    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }
}
