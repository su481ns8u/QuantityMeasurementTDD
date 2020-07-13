import com.quantityMeasurement.QuantityMeasurementException;
import com.quantityMeasurement.UnitComparator;
import com.quantityMeasurement.UnitCreatorFactory;
import org.junit.Assert;
import org.junit.Test;

import static com.quantityMeasurement.QuantityMeasurementException.ExceptionType.*;
import static com.quantityMeasurement.Unit.*;

public class QuantityMeasurementTest {
    UnitComparator unitComparator = new UnitComparator();

    @Test
    public void givenSameUnitFeet_ReturnsTrue() throws QuantityMeasurementException {
        UnitCreatorFactory feet1 = new UnitCreatorFactory(0.0, FEET);
        UnitCreatorFactory feet2 = new UnitCreatorFactory(0.0, FEET);
        Assert.assertTrue(unitComparator.compare(feet1, feet2));
    }

    @Test
    public void givenNullValueWhileComparingUnits_ShouldReturnFalse() {
        UnitCreatorFactory feet1 = new UnitCreatorFactory(0.0, FEET);
        try {
            unitComparator.compare(feet1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(NO_UNIT_FOUND, e.type);
        }
    }

    @Test
    public void givenSameReferanceOfUnit_ShouldReturnTrue() {
        UnitCreatorFactory feet = new UnitCreatorFactory(0.0, FEET);
        Assert.assertEquals(feet, feet);
    }

    @Test
    public void givenTwoObjectsOfFeetWithSameType_ShouldReturnTrue() {
        UnitCreatorFactory feet1 = new UnitCreatorFactory(0.0, FEET);
        UnitCreatorFactory feet2 = new UnitCreatorFactory(1.0, FEET);
        Assert.assertEquals(feet1.getClass(), feet2.getClass());
    }

    @Test
    public void givenSameUnitInch_ReturnsTrue() throws QuantityMeasurementException {
        UnitCreatorFactory inch1 = new UnitCreatorFactory(0.0, INCH);
        UnitCreatorFactory inch2 = new UnitCreatorFactory(0.0, INCH);
        Assert.assertTrue(unitComparator.compare(inch1, inch2));
    }

    @Test
    public void givenNullValueWhileComparingUnitInch_ShouldReturnFalse() {
        UnitCreatorFactory inch1 = new UnitCreatorFactory(0.0, INCH);
        try {
            unitComparator.compare(inch1, null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(NO_UNIT_FOUND, e.type);
        }
    }

    @Test
    public void givenSameReferanceOfUnitInch_ShouldReturnTrue() {
        UnitCreatorFactory inch = new UnitCreatorFactory(0.0, INCH);
        Assert.assertEquals(inch, inch);
    }

    @Test
    public void givenTwoObjectsOfInchWithSameType_ShouldReturnTrue() {
        UnitCreatorFactory inch1 = new UnitCreatorFactory(0.0, INCH);
        UnitCreatorFactory inch2 = new UnitCreatorFactory(1.0, INCH);
        Assert.assertEquals(inch2.getClass(), inch1.getClass());
    }

    @Test
    public void givenTwoUnitObjects_WithSameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        UnitCreatorFactory feet = new UnitCreatorFactory(0.0, FEET);
        UnitCreatorFactory inch = new UnitCreatorFactory(0.0, INCH);
        Assert.assertTrue(unitComparator.compare(feet, inch));
    }

    @Test
    public void givenTwoUnitObjects_WithNon0SameLengthButDifferentUnits_ShouldReturnTrue() throws QuantityMeasurementException {
        UnitCreatorFactory feet = new UnitCreatorFactory(1.0, FEET);
        UnitCreatorFactory inch = new UnitCreatorFactory(12.0, INCH);
        Assert.assertTrue(unitComparator.compare(feet, inch));
    }

    @Test
    public void given3FeetAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        UnitCreatorFactory feet = new UnitCreatorFactory(3.0, FEET);
        UnitCreatorFactory yard = new UnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(feet, yard));
    }

    @Test
    public void given1FeetAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        UnitCreatorFactory feet = new UnitCreatorFactory(1.0, FEET);
        UnitCreatorFactory yard = new UnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(unitComparator.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_IfNotEqualsReturnFalse() throws QuantityMeasurementException {
        UnitCreatorFactory inch = new UnitCreatorFactory(1.0, INCH);
        UnitCreatorFactory yard = new UnitCreatorFactory(1.0, YARD);
        Assert.assertFalse(unitComparator.compare(inch, yard));
    }

    @Test
    public void given1yardAnd36inch_IfEqualsReturnTrue() throws QuantityMeasurementException {
        UnitCreatorFactory inch = new UnitCreatorFactory(36.0, INCH);
        UnitCreatorFactory yard = new UnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(yard, inch));
    }

    @Test
    public void given36InchAnd1Yard_IfEqualsReturnTrue() throws QuantityMeasurementException {
        UnitCreatorFactory inch = new UnitCreatorFactory(36.0, INCH);
        UnitCreatorFactory yard = new UnitCreatorFactory(1.0, YARD);
        Assert.assertTrue(unitComparator.compare(inch, yard));
    }
}
