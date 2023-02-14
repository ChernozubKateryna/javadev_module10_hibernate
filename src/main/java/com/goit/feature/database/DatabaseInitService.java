package com.goit.feature.database;

import com.goit.feature.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void initDb() {
        String connectionUrl = new Prefs().getPref(Prefs.DB_JDBC_CONNECTION_URL).toString();

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        flyway.migrate();
    }
}