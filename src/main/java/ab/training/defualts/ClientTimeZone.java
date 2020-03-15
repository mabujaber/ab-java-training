package ab.training.defualts;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface ClientTimeZone {

    static ZoneId of(String zoneId){
        try{
            return ZoneId.of(zoneId);
        }catch(Exception e){
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneId){
        return ZonedDateTime.now(of(zoneId));
    }
}
