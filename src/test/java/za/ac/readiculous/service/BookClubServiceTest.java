package za.ac.readiculous.service;

/* BookClubService class.java
Author: Brezano Liebenberg (230463886)
Date:1 August 2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.factory.BookClubFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookClubServiceTest {

    @Autowired
    private BookClubService service;
    private BookClub bookClub = BookClubFactory.createBookClub(2001L, "Fantasy Readers", "Suckers for love.",
             LocalDateTime.now());;

    @Test
    void a_create() {
        BookClub created = service.create(bookClub);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        BookClub read = service.read(bookClub.getClubId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        BookClub newBookClub = new BookClub.Builder().copy(bookClub)
                .setClubName("Brave Bookworms")
                .build();
        BookClub updated = service.update(newBookClub);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());
    }
}