package constants;

/**
 * Created by caofanCPU on 2017/11/1.
 */
public enum WarehouseScaleType {

    City("城市仓"),
    Center("中心仓"),
    ;

    private String value;

    WarehouseScaleType(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static WarehouseScaleType fromName(String text) {
        for (WarehouseScaleType b : WarehouseScaleType.values()) {
            if (b.toString().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
