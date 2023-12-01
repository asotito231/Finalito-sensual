package com.kaeser.platform.u202116113.inventory.interfaces;

import com.kaeser.platform.u202116113.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u202116113.inventory.domain.service.EquipmentCommandService;
import com.kaeser.platform.u202116113.inventory.domain.service.EquipmentQueryService;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.u202116113.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value="/api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipment Managment Endpoints")
public class EquipmentsController {
    private final EquipmentQueryService equipmentQueryService;
    private final EquipmentCommandService equipmentCommandService;

    public EquipmentsController(EquipmentQueryService equipmentQueryService, EquipmentCommandService equipmentCommandService) {
        this.equipmentQueryService = equipmentQueryService;
        this.equipmentCommandService = equipmentCommandService;
    }
    /**
     * @param resource
     * @return
     * @author Andrés Soto
     */
    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);
        if(equipmentId == 0) {
            return ResponseEntity.badRequest().build();
        }
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if(equipment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }
    /**
     * @param equipmentId
     * @return
     * @author Andrés Soto
     */
    @GetMapping("/{equipmentId}")
    public ResponseEntity<EquipmentResource> getEquipment(@PathVariable Long equipmentId) {
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if(equipment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return ResponseEntity.ok(equipmentResource);
    }
}
