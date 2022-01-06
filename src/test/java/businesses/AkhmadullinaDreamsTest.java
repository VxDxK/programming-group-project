package businesses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AkhmadullinaDreamsTest {
    @Test
    void constructorTest(){
        AkhmadullinaDreams akhmadullinaDreams = new AkhmadullinaDreams();
        assertEquals(akhmadullinaDreams.getType(), IndustryType.FASHION);
    }
}