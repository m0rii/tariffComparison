package mori.task.interview.tariffComparison.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Getter
@EqualsAndHashCode
public abstract class Product implements Comparable<Product> {
    private final String name;
    private final double consumption;
    private final BigDecimal annualCost;

    // use constructor to set variable based on product model
    public Product(String name, double consumption) {
        this.name = name;
        this.consumption = consumption;
        this.annualCost = calculationModel(consumption);
    }

    //each product type has to declare how to calculate the annual cost based on tariff
    abstract BigDecimal calculationModel(double consumption);

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return "Tarrif name = " + name +
                ", consumption = " + consumption + " kWh/year" +
                ", annualCosts = " + formatter.format(annualCost) +
                '}';
    }

    // using compareTo to get acending order sort
    public int compareTo(Product o) {
        return this.getAnnualCost().compareTo(o.getAnnualCost());

    }
}
