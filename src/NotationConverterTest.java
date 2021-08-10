import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class NotationConverterTest {
    @Test
    public void toArabicNeg() {
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic("1");
        });
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic("VI1");
        });
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic("A");
        });
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic(" ");
        });
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic("XMM");
        });
        Assert.assertThrows(InvalidValueException.class, () -> {
            new NotationConverter().toArabic("MXM");
        });
    }

    @Test
    public void toArabicPos() {
        Assert.assertEquals(new NotationConverter().toArabic(""), 0);
        Assert.assertEquals(new NotationConverter().toArabic("I"), 1);
        Assert.assertEquals(new NotationConverter().toArabic("III"), 3);
        Assert.assertEquals(new NotationConverter().toArabic("XII"), 12);
        Assert.assertEquals(new NotationConverter().toArabic("IX"), 9);
        Assert.assertEquals(new NotationConverter().toArabic("LIX"), 59);
        Assert.assertEquals(new NotationConverter().toArabic("MCMXC"), 1990);
        Assert.assertEquals(new NotationConverter().toArabic("IIX"), 10);
        Assert.assertEquals(new NotationConverter().toArabic("IXIV"), 13);
        Assert.assertEquals(new NotationConverter().toArabic("IXLIV"), 43);
    }
}