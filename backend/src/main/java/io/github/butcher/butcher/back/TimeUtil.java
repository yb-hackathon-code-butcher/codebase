package io.github.butcher.butcher.back;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtil {

  private TimeUtil() {
    // Static utility class
  }

  public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
    return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
  }
}
