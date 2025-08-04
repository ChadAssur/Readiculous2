package za.ac.readiculous.service;

/* IService interface.java
Author: Brezano Liebenberg (230463886)
Date:31 July 2025
*/

public interface IService <T, ID>{
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
}
