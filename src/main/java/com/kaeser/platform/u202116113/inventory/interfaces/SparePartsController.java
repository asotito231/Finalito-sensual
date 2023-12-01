package com.kaeser.platform.u202116113.inventory.interfaces;

import com.kaeser.platform.u202116113.inventory.domain.model.queries.GetSparePartByIdQuery;
import com.kaeser.platform.u202116113.inventory.domain.service.SparePartCommandService;
import com.kaeser.platform.u202116113.inventory.domain.service.SparePartQueryService;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.CreateSparePartResource;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.SparePartResource;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.transform.CreateSparePartCommandFromResourceAssembler;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.transform.SparePartResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/equipment/{equipmentId}/spare-parts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Spare Parts", description = "Spare parts Management Endpoints")
public class SparePartsController {
    private final SparePartCommandService sparePartCommandService;
    private final SparePartQueryService sparePartQueryService;

    public SparePartsController(SparePartCommandService sparePartCommandService, SparePartQueryService sparePartQueryService) {
        this.sparePartCommandService = sparePartCommandService;
        this.sparePartQueryService = sparePartQueryService;
    }
    /**
     * @param resource
     * @return
     * @author Andrés Soto
     */
    @PostMapping
    public ResponseEntity<SparePartResource> createSparePart(@RequestBody CreateSparePartResource resource, @PathVariable Long equipmentId) {
        var createSparePartCommand = CreateSparePartCommandFromResourceAssembler.toCommandFromResource(resource);
        var sparePartId = sparePartCommandService.handle(createSparePartCommand, equipmentId);
        if(sparePartId == 0) {
            return ResponseEntity.badRequest().build();
        }
        var getSparePartByIdQuery = new GetSparePartByIdQuery(sparePartId);
        var sparePart = sparePartQueryService.handle(getSparePartByIdQuery);
        if(sparePart.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sparePartResource = SparePartResourceFromEntityAssembler.toResourceFromEntity(sparePart.get());
        return new ResponseEntity<>(sparePartResource, HttpStatus.CREATED);
    }

}
