package com.kaeser.platform.u202116113.inventory.domain.service;

import com.kaeser.platform.u202116113.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u202116113.inventory.domain.model.queries.GetSparePartByIdQuery;

import java.util.Optional;

public interface SparePartQueryService {
    Optional<SparePart> handle(GetSparePartByIdQuery query);
}
