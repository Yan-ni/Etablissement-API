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
import com.api.model.Cours;
import com.api.service.CoursService;
import com.api.service.UtilisateurService;

@RestController
@RequestMapping("/cours")
public class CoursController {
  @Autowired
  CoursService coursService;

  @Autowired
  UtilisateurService utilisateurService;

  @GetMapping
  public ResponseEntity<?> getAllCours(@RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(coursService.getAllCours());
  }

  @GetMapping("/{entityId}")
  public ResponseEntity<?> getCours(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(coursService.getCours(entityId));
  }

  @PostMapping
  public ResponseEntity<?> addCours(@RequestBody Cours cours, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(coursService.addCours(cours));
  }

  @PutMapping
  public ResponseEntity<?> editCours(@RequestBody Cours cours, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    return ResponseEntity.ok(coursService.updateCours(cours));
  }

  @DeleteMapping("/{entityId}")
  public ResponseEntity<String> deleteCours(@PathVariable String entityId, @RequestParam String userId) {
    if (!utilisateurService.checkRole(userId, Role.RG))
      return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);

    coursService.deleteCours(entityId);
    return ResponseEntity.ok("OK");
  }
}
