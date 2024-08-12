package pys.core.rest.tool;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ToolService {

    public static OffsetDateTime stringDDMMYYYY2OffsetDateTime(String date) {
        Integer day = Integer.valueOf(date.substring(0, 2));
        Integer month = Integer.valueOf(date.substring(2, 4));
        Integer year = Integer.valueOf(date.substring(4, 8));
        return OffsetDateTime.of(year, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
    }

}
