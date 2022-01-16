package businesses;

import org.junit.jupiter.api.Test;
import util.Pair;

import static org.junit.jupiter.api.Assertions.*;

class AkhmadullinaDreamsTest {
    @Test
    void constructorTest(){
        AkhmadullinaDreams akhmadullinaDreams = new AkhmadullinaDreams(0, 0);
        assertEquals(akhmadullinaDreams.getTypes().size(), 1);
        assertEquals(akhmadullinaDreams.getTypes().get(0), new Pair<>(IndustryType.FASHION, 1));
    }
}