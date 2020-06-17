package com.dasun.desingpattern;

import java.sql.Connection;

public class Application {

    public static void main(String[] args) {
        long start;
        long end;

        DBManager dbManager = DBManager.getDbManager();
        //System.out.println(dbManager);
        start = System.currentTimeMillis();
        Connection connection = dbManager.getConnection();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        DBManager dbManager1 = DBManager.getDbManager();
        start = System.currentTimeMillis();
        Connection connection1 = dbManager1.getConnection();
        end = System.currentTimeMillis();
        System.out.println(end - start);

        //System.out.println(dbManager1);

    }
}
