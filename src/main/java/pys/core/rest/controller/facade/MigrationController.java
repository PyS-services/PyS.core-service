package pys.core.rest.controller.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pys.core.rest.service.facade.MigrationService;

@RestController
@RequestMapping({"/migration", "/api/core/migration"})
public class MigrationController {

    private final MigrationService service;

    public MigrationController(MigrationService service) {
        this.service = service;
    }

    @GetMapping("/migrate")
    public ResponseEntity<Void> migrate() {
        service.migrate();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/migrateOne/{alias}")
    public ResponseEntity<Void> migrateOne(@PathVariable String alias) {
        service.migrateOne(alias);
        return ResponseEntity.ok().build();
    }

}
