package com.ifmo.lesson15;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Реализация потока ввода, которая генерирует случайные данные
 * указанной длины.
 */
public class RandomInputStream extends InputStream {
    private final Random random;
    private final long length;
    private long lCurPos;

    public RandomInputStream(Random random, long length) {
        this.random = random;
        this.length = length;
        lCurPos = 0;
    }

    @Override
    public int read() throws IOException {
        // TODO implement
        lCurPos++;
        return (lCurPos < length) ? random.nextInt(256) : -1;
    }
}
