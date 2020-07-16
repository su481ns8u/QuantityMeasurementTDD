import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Factories.LengthUnitCreatorFactory;
import com.quantityMeasurement.Factories.TemperatureUnitCreatorFactory;
import com.quantityMeasurement.Factories.VolumeUnitCreatorFactory;
import com.quantityMeasurement.Factories.WeightUnitCreatorFactory;
import com.quantityMeasurement.Services.QuantityOperations;
import org.junit.Assert;
import org.junit.Test;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.*;
import static com.quantityMeasurement.Utilities.Units.*;

public class QuantityMeasurementTest {
    QuantityOperations quantityOperations = new QuantityOperations();

    @Test
    public void givenSameUnitFeet_ReturnsTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet1 = new LengthUnitCreatorFactory(0.0, FEET);
        LengthUnitCreatorFactory feet2 = new LengthUnitCreatorFactory(0.0, FEET);
        Assert.assertTrue(quantityOperations.compare(feet1, feet2));
    }

    @Test
    public void givenNullValueWhileComparingUnits_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet1 = new LengthUnitCreatorFactory(0.0, FEET);
        try {
            quantityOperations.compare(feet1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenSameReferenceOfUnit_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(0.0, FEET);
        Assert.assertEquals(feet, feet);
    }

    @Test
    public void givenTwoObjectsOfFeetWithSameType_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet1 = new LengthUnitCreatorFactory(0.0, FEET);
        LengthUnitCreatorFactory feet2 = new LengthUnitCreatorFactory(1.0, FEET);
        Assert.assertEquals(feet1.getClass(), feet2.getClass());
    }

    @Test
    public void givenSameUnitInch_ReturnsTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch1 = new LengthUnitCreatorFactory(0.0, INCH);
        LengthUnitCreatorFactory inch2 = new LengthUnitCreatorFactory(0.0, INCH);
        Assert.assertTrue(quantityOperations.compare(inch1, inch2));
    }

    @Test
    public void givenNullValueWhileComparingUnitInch_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch1 = new LengthUnitCreatorFactory(0.0, INCH);
        try {
            quantityOperations.compare(inch1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenSameReferenceOfUnitInch_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(0.0, INCH);
        Assert.assertEquals(inch, inch);
    }

    @Test
    public void givenTwoObjectsOfInchWithSameType_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch1 = new LengthUnitCreatorFactory(0.0, INCH);
        LengthUnitCreatorFactory inch2 = new LengthUnitCreatorFactory(1.0, INCH);
        Assert.assertEquals(inch2.getClass(), inch1.getClass());
    }

    @Test
    public void givenTwoUnitObjects_WithSameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(0.0, FEET);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(0.0, INCH);
        Assert.assertTrue(quantityOperations.compare(feet, inch));
    }

    @Test
    public void givenTwoUnitObjects_WithNon0SameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(12.0, INCH);
        Assert.assertTrue(quantityOperations.compare(feet, inch));
    }

    @Test
    public void given3FeetAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(feet, yard));
    }

    @Test
    public void given1FeetAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(quantityOperations.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(1.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(quantityOperations.compare(inch, yard));
    }

    @Test
    public void given1yardAnd36inch_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(yard, inch));
    }

    @Test
    public void given36InchAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(inch, yard));
    }

    @Test
    public void given1YardAnd3Feet_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(quantityOperations.compare(yard, feet));
    }

    @Test
    public void given2InchAnd5Cm_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(5.0, INCH);
        LengthUnitCreatorFactory cm = new LengthUnitCreatorFactory(12.5, CM);
        Assert.assertTrue(quantityOperations.compare(inch, cm));
    }

    @Test
    public void givenNegativeValueForWhileSettingUnit_ShouldThrowException() {
        try {
            new LengthUnitCreatorFactory(-2.0, INCH);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(NEGATIVE_VALUE, e.type);
        }
    }

    @Test
    public void givenOnlyOneArgument_ShouldThrowException() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(2.0, INCH);
        try {
            Assert.assertTrue(quantityOperations.compare(inch));
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenMoreThanTwoArguments_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        LengthUnitCreatorFactory cm = new LengthUnitCreatorFactory(90.0, CM);
        Assert.assertTrue(quantityOperations.compare(feet, yard, inch, cm));
    }

    @Test
    public void givenTwoObjectsOfInchWithDifferentType_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(0.0, INCH);
        WeightUnitCreatorFactory weight = new WeightUnitCreatorFactory(1.0, KG);
        Assert.assertNotEquals(weight.getClass(), inch.getClass());
    }

    @Test
    public void givenTwoUnitsOfSameTypeLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch1 = new LengthUnitCreatorFactory(2.0, INCH);
        LengthUnitCreatorFactory inch2 = new LengthUnitCreatorFactory(2.0, INCH);
        double sumOfUnits = quantityOperations.addUnits(inch1, inch2);
        Assert.assertEquals(4.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesFeetAndInchLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(2.0, INCH);
        double sumOfUnits = quantityOperations.addUnits(feet, inch);
        Assert.assertEquals(14.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesFeetAndFeetLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(1.0, FEET);
        double sumOfUnits = quantityOperations.addUnits(feet, inch);
        Assert.assertEquals(24.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoUnitsOfDifferentTypesInchAndCmLength_ShouldBeAddedTogether() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(2.0, INCH);
        LengthUnitCreatorFactory cm = new LengthUnitCreatorFactory(2.5, CM);
        double sumOfUnits = quantityOperations.addUnits(cm, inch);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoValuesOfDifferentTypes_WhileAdding_ShouldThrowException() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(2.0, INCH);
        LengthUnitCreatorFactory cm = new LengthUnitCreatorFactory(2.5, CM);
        double sumOfUnits = quantityOperations.addUnits(cm, inch);
        Assert.assertEquals(3.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenSameUnitLiter_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory liter1 = new VolumeUnitCreatorFactory(0.0, LITRE);
        VolumeUnitCreatorFactory liter2 = new VolumeUnitCreatorFactory(0.0, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter1, liter2));
    }

    @Test
    public void givenDifferentUnitLiterAndGallon_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory gallon = new VolumeUnitCreatorFactory(1.0, GALLON);
        VolumeUnitCreatorFactory liter = new VolumeUnitCreatorFactory(3.78, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter, gallon));
    }

    @Test
    public void givenDifferentUnitsLiterAndMilliLiter_ReturnsTrue() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory ml = new VolumeUnitCreatorFactory(1000.0, MILLI_LITER);
        VolumeUnitCreatorFactory liter = new VolumeUnitCreatorFactory(1.0, LITRE);
        Assert.assertTrue(quantityOperations.compare(liter, ml));
    }

    @Test
    public void givenTwoVolumeUnitsLiterAndGallon_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory liter = new VolumeUnitCreatorFactory(3.78, LITRE);
        VolumeUnitCreatorFactory gallon = new VolumeUnitCreatorFactory(1.0, GALLON);
        double sumOfUnits = quantityOperations.addUnits(liter, gallon);
        Assert.assertEquals(7.56, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoVolumeUnitsLiterAndMilliLiter_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory liter = new VolumeUnitCreatorFactory(1, LITRE);
        VolumeUnitCreatorFactory ml = new VolumeUnitCreatorFactory(1000, MILLI_LITER);
        double sumOfUnits = quantityOperations.addUnits(liter, ml);
        Assert.assertEquals(2.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenSameUnitWeights_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitCreatorFactory kg1 = new WeightUnitCreatorFactory(0.0, KG);
        WeightUnitCreatorFactory kg2 = new WeightUnitCreatorFactory(0.0, KG);
        Assert.assertTrue(quantityOperations.compare(kg1, kg2));
    }

    @Test
    public void givenDifferentUnitsOfWeightsKGAndGrams_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitCreatorFactory kg = new WeightUnitCreatorFactory(1.0, KG);
        WeightUnitCreatorFactory gram = new WeightUnitCreatorFactory(1000.0, GRAM);
        Assert.assertTrue(quantityOperations.compare(kg, gram));
    }

    @Test
    public void givenDifferentUnitsOfWeightsKGAndTone_ReturnsTrue() throws QuantityMeasurementException {
        WeightUnitCreatorFactory tone = new WeightUnitCreatorFactory(1.0, TONS);
        WeightUnitCreatorFactory kg = new WeightUnitCreatorFactory(1000.0, KG);
        Assert.assertTrue(quantityOperations.compare(tone, kg));
    }

    @Test
    public void givenTwoWeightUnitsTonAndGrams_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        WeightUnitCreatorFactory ton = new WeightUnitCreatorFactory(1.0, TONS);
        WeightUnitCreatorFactory grams = new WeightUnitCreatorFactory(1000.0, GRAM);
        double sumOfUnits = quantityOperations.addUnits(ton, grams);
        Assert.assertEquals(1001.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenTwoTemperaturesWithSameUnitAndValue_ShouldReturnTrue() throws QuantityMeasurementException {
        TemperatureUnitCreatorFactory cel1 = new TemperatureUnitCreatorFactory(0.0, CELSIUS);
        TemperatureUnitCreatorFactory cel2 = new TemperatureUnitCreatorFactory(0.0, CELSIUS);
        Assert.assertEquals(cel1, cel2);
    }

    @Test
    public void givenTwoTemperaturesWithDifferentUnitAndValue_ShouldReturnTrue() throws QuantityMeasurementException {
        TemperatureUnitCreatorFactory cel = new TemperatureUnitCreatorFactory(100.0, CELSIUS);
        TemperatureUnitCreatorFactory far = new TemperatureUnitCreatorFactory(212.0, FAHRENHEIT);
        far.convert(CELSIUS);
        Assert.assertEquals(cel, far);
    }

    @Test
    public void givenTwoTemperatureUnitsCelAndFar_WhenAddedTogether_ReturnsAddition() throws QuantityMeasurementException {
        TemperatureUnitCreatorFactory cel = new TemperatureUnitCreatorFactory(100, CELSIUS);
        TemperatureUnitCreatorFactory far = new TemperatureUnitCreatorFactory(212, FAHRENHEIT);
        far.convert(CELSIUS);
        double sumOfUnits = quantityOperations.addUnits(cel, far);
        Assert.assertEquals(200.0, sumOfUnits, 0.0);
    }

    @Test
    public void givenWrongUnit_WhileSettingForTemp_ShouldThrowException() {
        try {
            new TemperatureUnitCreatorFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForLength_ShouldThrowException() {
        try {
            new LengthUnitCreatorFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForWeight_ShouldThrowException() {
        try {
            new WeightUnitCreatorFactory(1, LITRE);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnit_WhileSettingForVolume_ShouldThrowException() {
        try {
            new VolumeUnitCreatorFactory(1, KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenUnitsOfDifferentTypes_WhileAdding_ThrowsException() {
        try {
            TemperatureUnitCreatorFactory temp = new TemperatureUnitCreatorFactory(20, CELSIUS);
            WeightUnitCreatorFactory weight = new WeightUnitCreatorFactory(5, KG);
            quantityOperations.addUnits(weight, temp);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNITS_MISMATCH, e.type);
        }
    }

    @Test
    public void givenYardLength_ShouldReturnInInch() throws QuantityMeasurementException {
        LengthUnitCreatorFactory len = new LengthUnitCreatorFactory(1.0, YARD);
        len.convert(INCH);
        Assert.assertEquals(36, len.getValue(), 0.0);
    }

    @Test
    public void givenLiterVolume_ShouldReturnGallon() throws QuantityMeasurementException {
        VolumeUnitCreatorFactory vol = new VolumeUnitCreatorFactory(1.0, LITRE);
        vol.convert(GALLON);
        Assert.assertEquals(0.2645502645502646, vol.getValue(), 0.0);
    }

    @Test
    public void givenTonsWeight_ShouldReturnKG() throws QuantityMeasurementException {
        WeightUnitCreatorFactory weight = new WeightUnitCreatorFactory(1.0, TONS);
        weight.convert(KG);
        Assert.assertEquals(1000.0, weight.getValue(), 0.0);
    }

    @Test
    public void givenWrongUnitInLength_WhileConverting_ShouldThrowException() {
        try {
            LengthUnitCreatorFactory len = new LengthUnitCreatorFactory(2.3, CM);
            len.convert(FAHRENHEIT);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnitInWeight_WhileConverting_ShouldThrowException() {
        try {
            WeightUnitCreatorFactory weight = new WeightUnitCreatorFactory(5.3, KG);
            weight.convert(LITRE);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnitInVolume_WhileConverting_ShouldThrowException() {
        try {
            VolumeUnitCreatorFactory volume = new VolumeUnitCreatorFactory(5.3, LITRE);
            volume.convert(KG);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }

    @Test
    public void givenWrongUnitInTemperature_WhileConverting_ShouldThrowException() {
        try {
            TemperatureUnitCreatorFactory temp = new TemperatureUnitCreatorFactory(100, CELSIUS);
            temp.convert(LITRE);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(UNIT_NOT_ACCEPTED, e.type);
        }
    }
}