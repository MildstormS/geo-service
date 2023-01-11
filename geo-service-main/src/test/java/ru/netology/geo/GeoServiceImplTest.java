package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;
class GeoServiceImplTest {
    @Test
    void byIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location(("Moscow"), Country.RUSSIA, null, 0);
        Location actual = geoService.byIp("172. ");
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
    }

    @Test
    void test_Location_byCoordinates() {

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            GeoServiceImpl exception = new GeoServiceImpl();
            exception.byCoordinates(1, 1);
        });

        Assertions.assertEquals("Not implemented", thrown.getMessage());
    }

}