package java8;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.ZoneId.systemDefault;

public class DefaultMethods {

    public interface TimeClient {
        // ...
        static ZoneId getZoneId(String zoneString) {
            try {
                return ZoneId.of(zoneString);
            } catch (DateTimeException e) {
                System.err.println("无效时区：" + zoneString +
                        "；使用默认时区。");
                return ZoneId.systemDefault();
            }
        }

        default ZonedDateTime getZonedDateTime(String zoneString) {
            return ZonedDateTime.of(LocalDateTime.now(), getZoneId(zoneString));
        }
    }

}
