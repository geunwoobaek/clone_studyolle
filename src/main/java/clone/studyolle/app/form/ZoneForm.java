package clone.studyolle.app.form;

import clone.studyolle.app.domain.Zone;
import lombok.Data;

@Data
public class ZoneForm {
    String zoneName;
    public String getCityName() {
        return zoneName.substring(0, zoneName.indexOf("("));
    }
    public String getProvinceName() {
        return zoneName.substring(zoneName.indexOf("/") + 1);
    }
    public String getLocalNameOfCity() {
        return zoneName.substring(zoneName.indexOf("(") + 1, zoneName.indexOf(")"));
    }
    public Zone getZone() {
        return Zone.builder().city(this.getCityName())
                .localNameOfCity(this.getLocalNameOfCity())
                .province(this.getProvinceName()).build();
    }
}
