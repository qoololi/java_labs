package ru.qoololi.OwnerService;

import ru.qoololi.dtos.OwnerDto;
import ru.qoololi.models.Owner;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> findAllOwners();
    OwnerDto saveOwner(Owner owner);
    OwnerDto findOwner(long id);
    OwnerDto updateOwner(Owner owner);
    void deleteOwner(long id);
}
