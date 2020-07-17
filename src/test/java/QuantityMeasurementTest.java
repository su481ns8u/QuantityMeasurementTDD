import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Factories.LengthUnitFactory;
import com.quantityMeasurement.Factories.TemperatureUnitFactory;
import com.quantityMeasurement.Factories.VolumeUnitFactory;
import com.quantityMeasurement.Factories.WeightUnitFactory;
import com.quantityMeasurement.Services.QuantityOperations;
import org.junit.Assert;
import org.junit.Test;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.*;
import static com.quantityMeasurement.Utilities.Units.*;

public class QuantityMeasurementTest {
    QuantityOperations quantityOperations = new QuantityOperations();

    @Test
    public void givenSameUnitFeet_ReturnsTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet1 = new LengthUnitFactory(0.0, FEET);
        LengthUnitFactory feet2 = new LengthUnitFactory(0.0, FEET);
        Assert.assertTrue(quantityOperations.compare(feet1, feet2));
    }

    @Test
    public void givenNullValueWhileComparingUnits_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitFactory feet1 = new LengthUnitFactory(0.0, FEET);
        try {
            quantityOperations.compare(feet1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenSameReferenceOfUnit_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(0.0, FEET);
        Assert.assertEquals(feet, feet);
    }

    @Test
    public void givenTwoObjectsOfFeetWithSameType_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet1 = new LengthUnitFactory(0.0, FEET);
        LengthUnitFactory feet2 = new LengthUnitFactory(1.0, FEET);
        Assert.assertEquals(feet1.getClass(), feet2.getClass());
    }

    @Test
    public void givenSameUnitInch_ReturnsTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch1 = new LengthUnitFactory(0.0, INCH);
        LengthUnitFactory inch2 = new LengthUnitFactory(0.0, INCH);
        Assert.assertTrue(quantityOperations.compare(inch1, inch2));
    }

    @Test
    public void givenNullValueWhileComparingUnitInch_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitFactory inch1 = new LengthUnitFactory(0.0, INCH);
        try {
            quantityOperations.compare(inch1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenSameReferenceOfUnitInch_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(0.0, INCH);
        Assert.assertEquals(inch, inch);
    }

    @Test
    public void givenTwoObjectsOfInchWithSameType_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch1 = new LengthUnitFactory(0.0, INCH);
        LengthUnitFactory inch2 = new LengthUnitFactory(1.0, INCH);
        Assert.assertEquals(inch2.getClass(), inch1.getClass());
    }

    @Test
    public void givenTwoUnitObjects_WithSameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(0.0, FEET);
        LengthUnitFactory inch = new LengthUnitFactory(0.0, INCH);
        Assert.assertTrue(quantityOperations.compare(feet, inch));
    }

    @Test
    public void givenTwoUnitObjects_WithNon0SameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(1.0, FEET);
        LengthUnitFactory inch = new LengthUnitFactory(12.0, INCH);
        Assert.assertTrue(quantityOperations.compare(feet, inch));
    }

    @Test
    public void given3FeetAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(3.0, FEET);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(feet, yard));
    }

    @Test
    public void given1FeetAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(1.0, FEET);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertFalse(quantityOperations.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(1.0, INCH);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertFalse(quantityOperations.compare(inch, yard));
    }

    @Test
    public void given1yardAnd36inch_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(36.0, INCH);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(yard, inch));
    }

    @Test
    public void given36InchAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(36.0, INCH);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(inch, yard));
    }

    @Test
    public void given1YardAnd3Feet_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(3.0, FEET);
        LengthUnitFactory yard = new LengthUnitFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(yard, feet));
    }

    @Test
    public void given2InchAnd5Cm_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(5.0, INCH);
        LengthUnitFactory cm = new LengthUnitFactory(12.5, CM);
        Assert.assertTrue(quantityOperations.compare(inch, cm));
    }

    @Test
    public void givenNegativeValueForWhileSettingUnit_ShouldThrowException() {
        try {
            new LengthUnitFactory(-2.0, INCH);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(NEGATIVE_VALUE, e.type);
        }
    }

    @Test
    public void givenTwoObjectsOfInchWithDifferentType_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(0.0, INCH);
        WeightUnitFactory weight = new WeightUnitFactory(1.0, KG);
        Assert.assertNotEquals(weight.getClass(), inch.getClass());
    }

    @Test
    public void givenTwoUnitsOfSameTypeLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitFactory inch1 = new LengthUnitFactory(2.0, INCH);
        LengthUnitFactory inch2 = new LengthUnitFactory(2.0, INCH);
        double sumOfUnits = quantityOperations.addUnits(inch1, inch2);
        Assert.assertEquals(4.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesFeetAndInchLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(1.0, FEET);
        LengthUnitFactory inch = new LengthUnitFactory(2.0, INCH);
        double sumOfUnits = quantityOperations.addUnits(feet, inch);
        Assert.assertEquals(14.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesFeetAndFeetLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitFactory feet = new LengthUnitFactory(1.0, FEET);
        LengthUnitFactory inch = new LengthUnitFactory(1.0, FEET);
        double sumOfUnits = quantityOperations.addUnits(feet, inch);
        Assert.assertEquals(24.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesInchAndCmLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(2.0, INCH);
        LengthUnitFactory cm = new LengthUnitFactory(2.5, CM);
        double sumOfUnits = quantityOperations.addUnits(cm, inch);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoValuesOfDifferentTypes_WhileAdding_ShouldThrowException() throws QuantityMeasurementException {
        LengthUnitFactory inch = new LengthUnitFactory(2.0, INCH);
        LengthUnitFactory cm = new LengthUnitFactory(2.5, CM);
        double sumOfUnits = quantityOperations.addUnits(cm, inch);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenSameUnitLiter_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitFactory liter1 = new VolumeUnitFactory(0.0, LITRE);
        VolumeUnitFactory liter2 = new VolumeUnitFactory(0.0, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter1, liter2));
    }

    @Test
    public void givenDifferentUnitLiterAndGallon_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitFactory gallon = new VolumeUnitFactory(1.0, GALLON);
        VolumeUnitFactory liter = new VolumeUnitFactory(3.78, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter, gallon));
    }

    @Test
    public void givenDifferentUnitsLiterAndMilliLiter_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitFactory ml = new VolumeUnitFactory(1000.0, MILLI_LITER);
        VolumeUnitFactory liter = new VolumeUnitFactory(1.0, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter, ml));
    }

    @Test
    public void givenTwoVolumeUnitsLiterAndGallon_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        VolumeUnitFactory liter = new VolumeUnitFactory(3.78, LITRE);
        VolumeUnitFactory gallon = new VolumeUnitFactory(1.0, GALLON);
        double sumOfUnits = quantityOperations.addUnits(liter, gallon);
        Assert.assertEquals(7.56, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoVolumeUnitsLiterAndMilliLiter_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        VolumeUnitFactory liter = new VolumeUnitFactory(1, LITRE);
        VolumeUnitFactory ml = new VolumeUnitFactory(1000, MILLI_LITER);
        double sumOfUnits = quantityOperations.addUnits(liter, ml);
        Assert.assertEquals(2.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenSameUnitWeights_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitFactory kg1 = new WeightUnitFactory(0.0, KG);
        WeightUnitFactory kg2 = new WeightUnitFactory(0.0, KG);
        Assert.assertTrue(quantityOperations.compare(kg1, kg2));
    }

    @Test
    public void givenDifferentUnitsOfWeightsKGAndGrams_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitFactory kg = new WeightUnitFactory(1.0, KG);
        WeightUnitFactory gram = new WeightUnitFactory(1000.0, GRAM);
        Assert.assertTrue(quantityOperations.compare(kg, gram));
    }

    @Test
    public void givenDifferentUnitsOfWeightsKGAndTone_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitFactory tone = new WeightUnitFactory(1.0, TONS);
        WeightUnitFactory kg = new WeightUnitFactory(1000.0, KG);
        Assert.assertTrue(quantityOperations.compare(tone, kg));
    }

    @Test
    public void givenTwoWeightUnitsTonAndGrams_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        WeightUnitFactory ton = new WeightUnitFactory(1.0, TONS);
        WeightUnitFactory grams = new WeightUnitFactory(1000.0, GRAM);
        double sumOfUnits = quantityOperations.addUnits(ton, grams);
        Assert.assertEquals(1001.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoTemperaturesWithSameUnitAndValue_ShouldReturnTrue() throws QuantityMeasurementException {
        TemperatureUnitFactory cel1 = new TemperatureUnitFactory(0.0, CELSIUS);
        TemperatureUnitFactory cel2 = new TemperatureUnitFactory(0.0, CELSIUS);
        Assert.assertEquals(cel1, cel2);
    }

    @Test
    public void givenTwoTemperaturesWithDifferentUnitAndValue_ShouldReturnTrue() throws QuantityMeasurementException {
        TemperatureUnitFactory cel = new TemperatureUnitFactory(100.0, CELSIUS);
        TemperatureUnitFactory far = new TemperatureUnitFactory(212.0, FAHRENHEIT);
        Assert.assertTrue(quantityOperations.compare(cel, far));
    }

    @Test
    public void givenTwoTemperatureUnitsCelAndFar_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        TemperatureUnitFactory cel = new TemperatureUnitFactory(100, CELSIUS);
        TemperatureUnitFactory far = new TemperatureUnitFactory(212, FAHRENHEIT);
        double sumOfUnits = quantityOperations.addUnits(cel, far);
        Assert.assertEquals(200.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenWrongUnit_WhileSettingForTemp_ShouldThrowException() {
        try {
            new TemperatureUnitFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForLength_ShouldThrowException() {
        try {
            new LengthUnitFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForWeight_ShouldThrowException() {
        try {
            new WeightUnitFactory(1, LITRE);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForVolume_ShouldThrowException() {
        try {
            new VolumeUnitFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenUnitsOfDifferentTypes_WhileAdding_ThrowsException() {
        try {
            TemperatureUnitFactory temp = new TemperatureUnitFactory(20, CELSIUS);
            WeightUnitFactory weight = new WeightUnitFactory(5, KG);
            quantityOperations.addUnits(weight, temp);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNITS_MISMATCH, e.type);
        }
    }
}