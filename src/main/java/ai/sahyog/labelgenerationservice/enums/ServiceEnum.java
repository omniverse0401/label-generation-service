package ai.sahyog.labelgenerationservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public enum ServiceEnum {
    @JsonProperty("FP_E")
    FP_E("FP_E") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("ACI_E")
    ACI_E("ACI_E") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("ACI_W")
    ACI_W("ACI_W") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_LaserShip")
    GXC_LASERSHIP("GXC_LaserShip") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_OnTrac")
    GXC_ON_TRAC("GXC_OnTrac") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_Synctruck")
    GXC_SYNCTRUCK("GXC_Synctruck") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_GLS")
    GXC_GLS("GXC_GLS") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_Returnmates")
    GXC_RETURNMATES("GXC_Returnmates") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_BetterTrucks")
    GXC_BETTER_TRUCKS("GXC_BetterTrucks") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("FP_W")
    FP_W("FP_W") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_E")
    GXC_E("GXC_E") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_W")
    GXC_W("GXC_W") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_U")
    GXC_U("GXC_U") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_UDS")
    GXC_UDS("GXC_UDS") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_LSO")
    GXC_LSO("GXC_LSO") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_CDL")
    GXC_CDL("GXC_CDL") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("PB_ONT")
    PB_ONT("PB_ONT") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("PB_EWR")
    PB_EWR("PB_EWR") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("PB_IND")
    PB_IND("PB_IND") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("PB_CMH")
    PB_CMH("PB_CMH") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("00026PB_ONT")
    TORRID_PB_ONT("00026PB_ONT") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("00026PB_EWR")
    TORRID_PB_EWR("00026PB_EWR") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("00026PB_IND")
    TORRID_PB_IND("00026PB_IND") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("00026PB_CMH")
    TORRID_PB_CMH("00026PB_CMH") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_AEX")
    GXC_AEX("GXC_AEX") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_Axlehire")
    GXC_AXLEHIRE("GXC_Axlehire") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_Optima")
    GXC_OPTIMA("GXC_Optima") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_Tforce")
    GXC_TFORCE("GXC_Tforce") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("GXC_Hackbarth")
    GXC_HACKBARTH("GXC_Hackbarth") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    },
    @JsonProperty("DHLGrd")
    DHL_GRD("DHLGrd") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("DHLGrdPlus")
    DHL_GRD_PLUS("DHLGrdPlus") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("DHLExp")
    DHL_EXP("DHLExp") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("DHLExpPlus")
    DHL_EXP_PLUS("DHLExpPlus") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_DHLExpMax")
    GXC_DHL_EXP_MAX("GXC_DHLExpMax") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_DHLExpMaxPlus")
    GXC_DHL_EXP_MAX_PLUS("GXC_DHLExpMaxPlus") {
        @Override
        public boolean isUniversalCarrier() {
            return false;
        }
    },
    @JsonProperty("GXC_Veyer")
    GXC_VEYER("GXC_Veyer") {
        @Override
        public boolean isUniversalCarrier() {
            return true;
        }
    };

    @Getter
    private final String value;

    ServiceEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEnum fromValue(String text) {
        for (ServiceEnum b : ServiceEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Invalid argument for service code");
    }

    public abstract boolean isUniversalCarrier();

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
