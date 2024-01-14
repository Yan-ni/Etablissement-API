package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.api.model.Role;
import com.api.model.Remarque;
import com.api.service.RemarqueService;
import com.api.service.UtilisateurService;

@RestController
@RequestMapping("/remarque")
public class RemarqueController {
  @Autowired
  RemarqueService remarqueService;

  @Autowired
  UtilisateurService utilisateurService;

  @GetMapping
  public ResponseEntity<?> getAllRemarque(@RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.F) && !utilisateurService.checkRole(userId, Role.RM))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(remarqueService.getAllRemarque());
  }

  @GetMapping("/{entityId}")
  public ResponseEntity<?> getRemarque(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.F) && !utilisateurService.checkRole(userId, Role.RM))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(remarqueService.getRemarque(entityId));
  }

  @PostMapping
  public ResponseEntity<?> addRemarque(@RequestBody Remarque remarque, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.F))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(remarqueService.addRemarque(remarque));
  }

  @PutMapping
  public ResponseEntity<?> editRemarque(@RequestBody Remarque remarque, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.F) && !utilisateurService.checkRole(userId, Role.RM))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(remarqueService.updateRemarque(remarque));
  }
}
