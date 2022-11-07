package mori.task.interview.tariffComparison;

import mori.task.interview.tariffComparison.model.BasicElectricityTariff;
import mori.task.interview.tariffComparison.model.PackagedTarrif;
import mori.task.interview.tariffComparison.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class TariffComparisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TariffComparisonApplication.class, args);

        List<Product> productList = new ArrayList<>();
        productList.add(new BasicElectricityTariff(6000));
        productList.add(new BasicElectricityTariff(3500));
        productList.add(new BasicElectricityTariff(4500));
        productList.add(new PackagedTarrif(4500));
        productList.add(new PackagedTarrif(3500));
        productList.add(new PackagedTarrif(6000));
        Collections.sort(productList);
        productList.forEach(System.out::println);

        /*
         * Calculation: base costs per year 60€ + consumption costs 22 cent/kWh. Examples below:
         * Consumption = 3500 kWh/year => Annual costs = 830 €/year (5€ * 12 months = 60 €
         * base costs + 3500 kWh/year * 22 cent/kWh = 770 € consumption costs)
         * Consumption = 4500 kWh/year => Annual costs = 1050 €/year (5€ * 12 months = 60 €
         * base costs + 4500 kWh/year * 22 cent/kWh = 990 € consumption costs)
         * Consumption = 6000 kWh/year => Annual costs = 1380 €/year (5€ * 12 months = 60 €
         * base costs + 6000 kWh/year * 22 cent/kWh = 1320 € consumption costs)
         */
    }

}
