package se.knightspot.emailvalidator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.knightspot.emailvalidator.service.EmailDomainValidator;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailDomainValidator validator;

    public EmailController(EmailDomainValidator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateEmail(@RequestParam String email) {
        boolean isValid = validator.isEmailDomainValid(email);
        return ResponseEntity.ok(isValid ? "Valid email domain" : "Invalid email domain");
    }
}
