package za.ac.readiculous.factory;

/* BookClubFactory Test.java
Author: Brezano Liebenberg (230463886)
Date:30 July 2025
*/

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.readiculous.domain.BookClub;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class BookClubFactoryTest {
    public static BookClub club1 = BookClubFactory.createBookClub( 2001L, "Fantasy Readers", "Suckers for love."
            , LocalDateTime.now());

    @Test
    @Order(1)
    public void testCreateBookClub() {
        assertNotNull(club1);
        System.out.println(club1.toString());
    }

    @Test
    @Order(2)
    public void CreateBookClubToFail() {
        fail();

        assertNotNull(club1);
        System.out.println(club1.toString());
    }
  
}