package mori.task.interview.tariffComparison.model;

import java.math.BigDecimal;

public class PackagedTarrif extends Product {

    public PackagedTarrif(int consumption) {
        super("Packaged Tariff", consumption);
    }

    @Override
    public BigDecimal calculationModel(int consumption) {
        if (consumption <= 4000) {
            return BigDecimal.valueOf(800.0);
        } else {
            double additionalConsumptionCosts = consumption - 4000;
            return BigDecimal.valueOf(800 + additionalConsumptionCosts * 0.30);
        }
    }

}
