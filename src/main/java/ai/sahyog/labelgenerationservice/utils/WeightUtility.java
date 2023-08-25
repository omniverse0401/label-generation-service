package ai.sahyog.labelgenerationservice.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class WeightUtility {
    public static BigDecimal convertToLb(double weight, String unit) {

        BigDecimal weightBD = new BigDecimal(String.valueOf(weight));
        BigDecimal ozToLb = new BigDecimal("16.0");
        BigDecimal kgToLb = new BigDecimal("0.45359237");
        WeightUomEnum uom = WeightUomEnum.fromValue(unit);
        if (uom.equals(WeightUomEnum.LB)) {
            return weightBD.setScale(2, RoundingMode.HALF_UP);
        }
        if (uom.equals(WeightUomEnum.OZ)) {
            return weightBD.divide(ozToLb, 2, RoundingMode.HALF_UP);
        }

        if (uom.equals(WeightUomEnum.KG)) {
            return weightBD.divide(kgToLb, 2, RoundingMode.HALF_UP);
        }
        return weightBD;
    }

    public static Double roundOffWeight(Double weight) {
        DecimalFormat format = new DecimalFormat("#.####");
        return Double.parseDouble(format.format(weight));
    }
}
