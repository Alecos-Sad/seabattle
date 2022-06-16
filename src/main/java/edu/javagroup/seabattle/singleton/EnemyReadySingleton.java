package edu.javagroup.seabattle.singleton;

/**
 * EnemyReadySingleton
 * у него должно быть поле представленное булевым значением
 * и это поле должно возвращаться методом enemyReady
 */
public class EnemyReadySingleton {
    private static EnemyReadySingleton instance;
    private final Boolean enemyReady;

    public EnemyReadySingleton(Boolean enemyReady) {
        this.enemyReady = enemyReady;
    }

    public static EnemyReadySingleton instance(Boolean enemyReady){
        EnemyReadySingleton singleton = instance;
        if (singleton == null) {
            instance = new EnemyReadySingleton(false);
        }
        if (enemyReady != null) {
            instance = new EnemyReadySingleton(enemyReady);
        }
        return instance;
    }
    public Boolean imReady() {
        return enemyReady;
    }
}
