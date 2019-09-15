package com.hardcoders.havajack.utils;

import java.util.Random;
import java.util.UUID;

public class CommonUtils {

    private static Random random = new Random();

    public static String normalizePhone(String phone) {
        phone = phone.replaceAll("\\D+", "");
        return phone.length() > 10 ? phone.substring(phone.length() - 10) : phone;
    }

    public static int generateVerificationCode() {
        return 100000 + random.nextInt(900000);
    }

    public static int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
