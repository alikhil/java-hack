package com.hardcoders.havajack.utils;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtils {
    private TimeUtils(){}

    public static final long MINUTE_MILLISECONDS = 60 * 1000L;
    public static final long HOUR_MILLISECONDS = MINUTE_MILLISECONDS * 60;
    public static final long DAY_MILLISECONDS = HOUR_MILLISECONDS * 24;
    public static final long WEEK_MILLISECONDS = DAY_MILLISECONDS * 7;
    public static final long MONTH_MILLISECONDS = DAY_MILLISECONDS * 30;

    public static final int DAY_SECONDS = 3600 * 24;
    public static final int MONTH_SECONDS = DAY_SECONDS * 30;

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyyHH:mm");

}

