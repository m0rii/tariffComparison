package mori.task.interview.tariffComparison.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
public abstract class Product implements Comparable<Product>  {
    private String name;
    private int consumption;
    private BigDecimal annualCost;

    public Product(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
        this.annualCost=calculationModel(consumption);
    }

    abstract BigDecimal calculationModel(int consumption) ;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(annualCost, product.annualCost);
    }


    @Override
    public int hashCode() {
        return annualCost != null ? annualCost.hashCode() : 0;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return "Tarrif name = " + name +
                ", consumption = " +  formatter.format(consumption) +
                ", annualCosts = " + formatter.format(annualCost) +
                '}';
    }

    public int compareTo(Product o) {
        return this.getAnnualCost().compareTo(o.getAnnualCost());

    }
}
