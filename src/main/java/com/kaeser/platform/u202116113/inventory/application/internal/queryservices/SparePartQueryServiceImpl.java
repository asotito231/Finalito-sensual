package com.kaeser.platform.u202116113.inventory.application.internal.queryservices;

import com.kaeser.platform.u202116113.inventory.domain.model.entities.SparePart;
import com.kaeser.platform.u202116113.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u202116113.inventory.domain.service.SparePartQueryService;
import com.kaeser.platform.u202116113.inventory.infrastructure.persistence.jpa.repositories.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SparePartQueryServiceImpl implements SparePartQueryService {
    private final SparePartRepository sparePartRepository;

    public SparePartQueryServiceImpl(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    @Override
    public Optional<SparePart> handle(GetSparePartByIdQuery query) {
        return sparePartRepository.findById(query.sparePartId());
    }
}
