package constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by caofanCPU on 2017/9/20.
 */
public enum BookingStatus {

    UserBooking("已订阅"),
    UserCancel("取消订阅"),
    TimeoutCancel("超时取消订阅"),
    ;

    private String value;

    BookingStatus(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static BookingStatus fromValue(String text) {
        for (BookingStatus b : BookingStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
