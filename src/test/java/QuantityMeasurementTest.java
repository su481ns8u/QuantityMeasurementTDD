import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Services.UnitComparator;
import com.quantityMeasurement.Utilities.LengthUnitCreatorFactory;
import org.junit.Assert;
import org.junit.Test;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.INVALID_ARGUMENTS;
import static com.quantityMeasurement.Utilities.Unit.*;

public class QuantityMeasurementTest {
    UnitComparator unitComparator = new UnitComparator();

    @Test
    public void givenSameUnitFeet_ReturnsTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet1 = new LengthUnitCreatorFactory(0.0, FEET);
        LengthUnitCreatorFactory feet2 = new LengthUnitCreatorFactory(0.0, FEET);
        Assert.assertTrue(unitComparator.compare(feet1, feet2));
    }

    @Test
    public void givenNullValueWhileComparingUnits_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet1 = new LengthUnitCreatorFactory(0.0, FEET);
        try {
            unitComparator.compare(feet1, null);
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
        Assert.assertTrue(unitComparator.compare(inch1, inch2));
    }

    @Test
    public void givenNullValueWhileComparingUnitInch_ShouldReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch1 = new LengthUnitCreatorFactory(0.0, INCH);
        try {
            unitComparator.compare(inch1, null);
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
        Assert.assertTrue(unitComparator.compare(feet, inch));
    }

    @Test
    public void givenTwoUnitObjects_WithNon0SameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(12.0, INCH);
        Assert.assertTrue(unitComparator.compare(feet, inch));
    }

    @Test
    public void given3FeetAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(feet, yard));
    }

    @Test
    public void given1FeetAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(1.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(unitComparator.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(1.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(unitComparator.compare(inch, yard));
    }

    @Test
    public void given1yardAnd36inch_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(yard, inch));
    }

    @Test
    public void given36InchAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(inch, yard));
    }

    @Test
    public void given1YardAnd3Feet_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(yard, feet));
    }

    @Test
    public void given2InchAnd5Cm_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(2.0, INCH);
        LengthUnitCreatorFactory cm = new LengthUnitCreatorFactory(5.0, CM);
        Assert.assertTrue(unitComparator.compare(inch, cm));
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
            Assert.assertTrue(unitComparator.compare(inch));
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(INVALID_ARGUMENTS, e.type);
        }
    }

    @Test
    public void givenMoreThanTwoArguments_IfEqualsReturnTrue() throws QuantityMeasurementException {
        LengthUnitCreatorFactory feet = new LengthUnitCreatorFactory(3.0, FEET);
        LengthUnitCreatorFactory yard = new LengthUnitCreatorFactory(1.0, YARD);
        LengthUnitCreatorFactory inch = new LengthUnitCreatorFactory(36.0, INCH);
        Assert.assertTrue(unitComparator.compare(feet, yard, inch));
    }
}