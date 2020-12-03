package cc.cottom.proxy.bean;

import cc.cottom.proxy.constant.DBType;

public class DBContextHolder {
    private static final ThreadLocal<DBType> localDBType = new ThreadLocal<>();

    public static DBType getDBType() {
        return localDBType.get();
    }

    public static void setMaster() {
        localDBType.set(DBType.MASTER);
    }

    public static void setSlave() {
        localDBType.set(DBType.SLAVE);
    }

}
