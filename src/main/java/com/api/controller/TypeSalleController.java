package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.api.model.Role;
import com.api.model.TypeSalle;
import com.api.service.TypeSalleService;
import com.api.service.UtilisateurService;

@RestController
@RequestMapping("/typeSalle")
public class TypeSalleController {
  @Autowired
  TypeSalleService typeSalleService;

  @Autowired
  UtilisateurService utilisateurService;

  @GetMapping
  public ResponseEntity<?> getAllTypeSalle(@RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.A))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(typeSalleService.getAllTypeSalle());
  }

  @GetMapping("/{entityId}")
  public ResponseEntity<?> getTypeSalle(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.A))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(typeSalleService.getTypeSalle(entityId));
  }

  @PostMapping
  public ResponseEntity<?> addTypeSalle(@RequestBody TypeSalle typeSalle, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.A))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(typeSalleService.addTypeSalle(typeSalle));
  }

  @PutMapping
  public ResponseEntity<?> putMethodName(@RequestBody TypeSalle ts, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.A))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(typeSalleService.updateTypeSalle(ts));
  }

  @DeleteMapping("/{entityId}")
  public ResponseEntity<String> deleteTypeSalle(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.A))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    typeSalleService.deleteTypeSalle(entityId);
    return ResponseEntity.ok("OK");
  }
}
