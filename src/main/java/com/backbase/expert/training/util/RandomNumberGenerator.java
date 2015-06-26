package com.backbase.services.batman.games.util;

import org.apache.commons.lang.math.RandomUtils;

/**
 * User: bartv
 * Date: 12-07-14
 * Time: 16:56
 */
public class RandomNumberGenerator {

    public static int generateRandomNumber() {
        return RandomUtils.nextFloat() < 0.9 ? 2 : 4;
    }
}
