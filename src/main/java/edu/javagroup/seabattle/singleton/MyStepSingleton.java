package edu.javagroup.seabattle.singleton;

/**
 * MyStepSingleton
 * у него должно быть поле представленное булевым значением
 * и это поле должно возвращаться методом myStep
 */
public class MyStepSingleton {
    private static MyStepSingleton instance;
    private final Boolean myStep;

    private MyStepSingleton(Boolean myStep) {
        this.myStep = myStep;
    }

    public static MyStepSingleton instance(Boolean myStep) {
       if (instance == null) {
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
