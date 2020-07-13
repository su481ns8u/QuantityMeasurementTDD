import com.quantityMeasurement.Unit;
import com.quantityMeasurement.UnitComparator;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {
    UnitComparator unitComparator = new UnitComparator();

    @Test
    public void givenSameUnitFeet_ReturnsTrue() {
        Unit feet1 = new Unit(0);
        Unit feet2 = new Unit(0);
        Assert.assertTrue(this.unitComparator.compare(feet1,feet2));
    }
}
