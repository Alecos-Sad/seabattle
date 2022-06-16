package edu.javagroup.seabattle.singleton;

public class MyStepSingleton {
    private static volatile MyStepSingleton instance;
    private final Boolean myStep;

    private MyStepSingleton(Boolean imReady) {
        this.myStep = imReady;
    }

    public static MyStepSingleton instance(Boolean myStep) {
        MyStepSingleton singleton = instance;
        if (singleton == null) {
            instance = new MyStepSingleton(false);
        }
        if (myStep != null) {
            instance = new MyStepSingleton(myStep);
        }
        return instance;
    }

    public Boolean myStep() {
        return myStep;
    }
}
