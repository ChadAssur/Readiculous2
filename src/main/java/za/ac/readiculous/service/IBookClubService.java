package za.ac.readiculous.service;

/* IMessageService interface.java
Author: Brezano Liebenberg (230463886)
Date:31 July 2025
*/

import za.ac.readiculous.domain.BookClub;

import java.util.List;

public interface IBookClubService extends IService<BookClub, Long>{
    List<BookClub> getAll();

}
