package com.example;

import java.util.Random;

public class Jokes {
    private static final String[] JOKESARRAY =
            {"Born free, taxed to death.",
            "A day without sunshine is like, night.",
            "I say no to alcohol, it just doesn’t listen.",
            "If you can’t convince them, confuse them.",
            "For Sale: Parachute. Only used once, never opened."};

    /**
     * Tells a random joke.
     */
    public static String getRandomJoke() {
        Random random = new Random();
        return JOKESARRAY[random.nextInt(JOKESARRAY.length)];
    }
}
