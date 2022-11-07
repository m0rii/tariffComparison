package mori.task.interview.tariffComparison.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

class ProductTest {

    BasicElectricityTariff basicElectricityTariffOne = new BasicElectricityTariff(3500);
    BasicElectricityTariff basicElectricityTariffTwo = new BasicElectricityTariff(4500);
    BasicElectricityTariff basicElectricityTariffThree = new BasicElectricityTariff(6000);
    BasicElectricityTariff basicElectricityTariffFour = new BasicElectricityTariff(0);
    PackagedTarrif packagedTarrifOne = new PackagedTarrif(4500);
    PackagedTarrif packagedTarrifTwo = new PackagedTarrif(3500);
    PackagedTarrif packagedTarrifThree = new PackagedTarrif(6000);
    PackagedTarrif packagedTarrifFour = new PackagedTarrif(0);


    @Test
    public void basicElectricityTariffTest() {
        assertEquals("Annual cost 3500 with BasicElectricityTariff should be 830", basicElectricityTariffOne.getAnnualCost(), BigDecimal.valueOf(830.0));
        assertEquals("Annual cost 4500 with BasicElectricityTariff should be 1050", basicElectricityTariffTwo.getAnnualCost(), BigDecimal.valueOf(1050.0));
        assertEquals("Annual cost 6500 with BasicElectricityTariff should be 1380", basicElectricityTariffThree.getAnnualCost(), BigDecimal.valueOf(1380.0));
        assertEquals("Annual cost 0 with BasicElectricityTariff should be 60", basicElectricityTariffFour.getAnnualCost(), BigDecimal.valueOf(60.0));
    }

    @Test
    public void packagedTarrifTest() {
        assertEquals("Annual cost 4500 with PackagedTarrif should be 950", packagedTarrifOne.getAnnualCost(), BigDecimal.valueOf(950.0));
        assertEquals("Annual cost 3500 with PackagedTarrif should be 800", packagedTarrifTwo.getAnnualCost(), BigDecimal.valueOf(800.0));
        assertEquals("Annual cost 6000 with PackagedTarrif should be 1400", packagedTarrifThree.getAnnualCost(), BigDecimal.valueOf(1400.0));
        assertEquals("Annual cost 0 with PackagedTarrif should be 800", packagedTarrifFour.getAnnualCost(), BigDecimal.valueOf(800.0));
    }

    @Test
    public void listProductTest() {
        List<Product> productList = new ArrayList<>(Arrays.asList(basicElectricityTariffFour, basicElectricityTariffOne, basicElectricityTariffTwo, basicElectricityTariffThree,
                packagedTarrifThree, packagedTarrifFour, packagedTarrifTwo, packagedTarrifOne));
        List<Product> sortedProductList = new ArrayList<>(productList);
        Collections.sort(sortedProductList);
        assertEquals("4 packagedtarrif + 4 basictarrif should be 8", 8, productList.size());
        assertNotEquals("sorted and not sorted list should not be equal", productList, sortedProductList);
/*        productList.forEach(System.out::println);
        System.out.println("=================================");
        sortedProductList.forEach(System.out::println);*/
    }

}