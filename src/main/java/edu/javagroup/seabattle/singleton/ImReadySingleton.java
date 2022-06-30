package edu.javagroup.seabattle.singleton;

/**
 * ImReadySingleton
 * у него должно быть поле представленное булевым значением
 * и это поле должно возвращаться методом imReady
 */
public class ImReadySingleton {
    private static ImReadySingleton instance;
    private final Boolean imReady;

    private ImReadySingleton(Boolean imReady) {
        this.imReady = imReady;
    }

    public static ImReadySingleton instance(Boolean imReady) {
        if (instance == null) {
            instance = new ImReadySingleton(false);
        }
        if (imReady != null) {
            instance = new ImReadySingleton(imReady);
        }
        return instance;
    }

    public Boolean imReady() {
        return imReady;
    }
}

