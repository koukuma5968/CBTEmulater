package emulater.util;

import java.time.format.DateTimeFormatter;

public class Constant {

    public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH時mm分ss秒");

    public static DateTimeFormatter DAY_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    public static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

}
