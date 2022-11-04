package mori.task.interview.tariffComparison.model;

import java.math.BigDecimal;

public class BasicElectricityTariff extends Product {

    public BasicElectricityTariff(int consumption){
        super("Basic Electricity Tariff",consumption);
    }

    /**
     * Calculation: base costs per year 60€ + consumption costs 22 cent/kWh. Examples below:
     * Consumption = 3500 kWh/year => Annual costs = 830 €/year (5€ * 12 months = 60 €
     * base costs + 3500 kWh/year * 22 cent/kWh = 770 € consumption costs)
     * Consumption = 4500 kWh/year => Annual costs = 1050 €/year (5€ * 12 months = 60 €
     * base costs + 4500 kWh/year * 22 cent/kWh = 990 € consumption costs)
     * Consumption = 6000 kWh/year => Annual costs = 1380 €/year (5€ * 12 months = 60 €
     * base costs + 6000 kWh/year * 22 cent/kWh = 1320 € consumption costs)
     */
    @Override
    public BigDecimal calculationModel(int consumption) {
        double baseCostMonthly= 5;
        double baseCostsYearly = baseCostMonthly * 12;
        consumption = Math.max(consumption, 0);
        double consumptionCosts = consumption * 0.22;
        return BigDecimal.valueOf(baseCostsYearly + consumptionCosts);
    }

}
