package mori.task.interview.tariffComparison.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.springframework.test.util.AssertionErrors.assertEquals;

class ProductTest {

    BasicElectricityTariff basicElectricityTariffOne = new BasicElectricityTariff(3500);
    BasicElectricityTariff basicElectricityTariffTwo = new BasicElectricityTariff(4500);
    BasicElectricityTariff basicElectricityTariffThree = new BasicElectricityTariff(6000);
    BasicElectricityTariff basicElectricityTariffFour = new BasicElectricityTariff(0);

    PackagedTarrif packagedTarrifOne = new PackagedTarrif(4500);
    PackagedTarrif packagedTarrifTwo = new PackagedTarrif(3000);
    PackagedTarrif packagedTarrifThree = new PackagedTarrif(6000);
    PackagedTarrif packagedTarrifFour = new PackagedTarrif(0);


    @Test
    public void BasicElectricityTariffTest() {
        assertEquals("test BasicElectricityTariff annual cost with expected result", basicElectricityTariffOne.getAnnualCost(), BigDecimal.valueOf(830.0));
        assertEquals("test BasicElectricityTariff annual cost with expected result", basicElectricityTariffTwo.getAnnualCost(), BigDecimal.valueOf(1050.0));
        assertEquals("test BasicElectricityTariff annual cost with expected result", basicElectricityTariffThree.getAnnualCost(), BigDecimal.valueOf(1380.0));
        assertEquals("test BasicElectricityTariff annual cost with expected result", basicElectricityTariffFour.getAnnualCost(), BigDecimal.valueOf(60.0));
    }

    @Test
    public void PackagedTarrifTest() {
        assertEquals("test PackagedTarrif annual cost with expected result", packagedTarrifOne.getAnnualCost(), BigDecimal.valueOf(950.0));
        assertEquals("test PackagedTarrif annual cost with expected result", packagedTarrifTwo.getAnnualCost(), BigDecimal.valueOf(800.0));
        assertEquals("test PackagedTarrif annual cost with expected result", packagedTarrifThree.getAnnualCost(), BigDecimal.valueOf(1400.0));
        assertEquals("test PackagedTarrif annual cost with expected result", packagedTarrifFour.getAnnualCost(), BigDecimal.valueOf(800.0));
    }

}