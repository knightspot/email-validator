package se.knightspot.emailvalidator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.knightspot.emailvalidator.service.EmailDomainValidator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmailDomainValidatorTest {

    private final EmailDomainValidator validator = new EmailDomainValidator();

    @Test
    public void testValidEmailDomain() {
        assertTrue(validator.isEmailDomainValid("example@gmail.com"));
    }

    @Test
    public void testInvalidEmailDomain() {
        assertFalse(validator.isEmailDomainValid("example@invalid-domain"));
    }

    @Test
    public void testNullEmail() {
        assertFalse(validator.isEmailDomainValid(null));
    }

    @Test
    public void testEmailWithoutAtSymbol() {
        assertFalse(validator.isEmailDomainValid("example.com"));
    }
}
