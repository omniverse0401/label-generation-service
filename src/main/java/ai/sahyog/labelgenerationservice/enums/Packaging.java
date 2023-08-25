package ai.sahyog.labelgenerationservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum Packaging {
    BOX("BOX"),
    BAG("BAG");

    @Getter
    private final String value;

    Packaging(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Packaging fromValue(String text) {
        for (Packaging b : Packaging.values()) {
            if (String.valueOf(b.value).equals(text.toUpperCase())) {
                return b;
            }
        }
        throw new IllegalArgumentException("Invalid argument for packaging");
    }
}
