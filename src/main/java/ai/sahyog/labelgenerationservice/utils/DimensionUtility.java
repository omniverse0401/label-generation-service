package ai.sahyog.labelgenerationservice.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DimensionUtility {
    private static final String CM_TO_IN = "0.393701";

    public static BigDecimal convertToIn(double length, String uom) {

        BigDecimal lengthDb = new BigDecimal(String.valueOf(length)).setScale(2, RoundingMode.HALF_UP);


        BigDecimal cmToIn = new BigDecimal(CM_TO_IN);
        DimensionUomEnum unitOfMeasure = DimensionUomEnum.fromValue(uom);
        if (null != unitOfMeasure && unitOfMeasure.equals(DimensionUomEnum.CM)) {
            BigDecimal multiply = lengthDb.multiply(cmToIn, MathContext.DECIMAL64);
            multiply = multiply.setScale(2, RoundingMode.HALF_UP);
            return multiply;
        }

        return lengthDb;
    }

}
