package org.newapp.antofucker.othershits;

/**
 * Created by pedroantoninho on 12/11/15.
 */
public class Bootcamp {

    private static Bootcamp bootcampInstance = null;

    private int bootcampID = 0;

    public static Bootcamp getInstance() {

        if (bootcampInstance != null) {
            return bootcampInstance;
        } else {
            return new Bootcamp();
        }

    }

    private Bootcamp() {
    }

    public int getBootcampID() {
        return bootcampID;
    }
}
