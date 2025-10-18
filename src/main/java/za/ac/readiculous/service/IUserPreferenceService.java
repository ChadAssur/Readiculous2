package za.ac.readiculous.service;

import za.ac.readiculous.domain.UserPreference;
import java.util.List;

public interface IUserPreferenceService {

    UserPreference create(UserPreference preference);

    UserPreference read(Long id);

    UserPreference update(UserPreference preference);

    boolean delete(Long id);

    List<UserPreference> getAll();

    List<UserPreference> getByUserId(Integer userId);
}
