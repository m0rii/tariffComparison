package mori.task.interview.tariffComparison.model;

import java.math.BigDecimal;

public class BasicElectricityTariff extends Product {

    public BasicElectricityTariff(double consumption) {
        super("Basic Electricity Tariff", consumption);
    }

    @Override
    public BigDecimal calculationModel(double consumption) {
        double baseCostMonthly = 5.0;
        double baseCostsYearly = baseCostMonthly * 12.0;
        consumption = Math.max(consumption, 0); // check consumption value: return 0 when consumption less equal than 0
        double consumptionCosts = consumption * 0.22;
        return BigDecimal.valueOf(baseCostsYearly + consumptionCosts);
    }

}
