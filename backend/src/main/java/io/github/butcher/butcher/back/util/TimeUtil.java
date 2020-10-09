package io.github.butcher.butcher.back.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtil {

  private TimeUtil() {
    // Static utility class
  }

  public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
    return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
  }

  public static Instant localDateTimeToInstant(LocalDateTime localDateTime) {
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
  }
}
