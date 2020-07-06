package com.dasun.desingpattern;

/**
 * The DBManager - Singleton pattern
 */
public class DBManager {

    private static volatile DBManager dbManager;

    private DBManager() {
        if (dbManager != null) {
            throw new RuntimeException("please use get db manager method");
        }
    }

    public DBManager getDbManager() {
        if (dbManager == null) {
            synchronized (DBManager.class) {
                if (dbManager == null) {
                    dbManager = new DBManager();
                }
            }
        }
        return dbManager;
    }


}
