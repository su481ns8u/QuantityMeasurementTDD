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
}
