package za.ac.readiculous.service;

import za.ac.readiculous.domain.Badge;

import java.util.List;

public interface IBadgeService extends IService<BadgeService, Long>{
    List<Badge> getAll();

}
