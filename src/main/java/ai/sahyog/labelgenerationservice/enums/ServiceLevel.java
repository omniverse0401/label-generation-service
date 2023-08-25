package ai.sahyog.labelgenerationservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum ServiceLevel {
    GROUND("GROUND"),
    POSTAL("POSTAL");

    @Getter
    private final String value;

    ServiceLevel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ServiceLevel fromValue(String text) {
        for (ServiceLevel b : ServiceLevel.values()) {
            if (String.valueOf(b.value).equals(text.toUpperCase())) {
                return b;
            }
        }
        throw new IllegalArgumentException("Invalid argument for service level");
    }
}
