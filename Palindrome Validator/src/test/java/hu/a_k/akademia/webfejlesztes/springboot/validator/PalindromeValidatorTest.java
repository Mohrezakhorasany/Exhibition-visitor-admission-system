package hu.a_k.akademia.webfejlesztes.springboot.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class PalindromeValidatorTest {

    private static Validator validator;

    @BeforeAll
    static void beforeAll() {
        try (final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
    }

    @Test
    void isAllWordsPalindrome() {
        final List<String> words = Arrays.asList("Anna", "civic", "kayak", "level", "madam", "mom", "noon", "racecar", "radar", "redder", "refer","bus");
        final Palindrome palindrome = new Palindrome(words);
        final Set<ConstraintViolation<Palindrome>> violations = validator.validate(palindrome);
        Assertions.assertThat(violations).hasSize(1);
        final ConstraintViolation<Palindrome> violation = violations.iterator().next();
        Assertions.assertThat(violation.getMessage()).isEqualTo("List of '%s' contained elements which are not palindrome");
    }

    @RequiredArgsConstructor
    private static final class Palindrome {
        @hu.a_k.akademia.webfejlesztes.springboot.validator.Palindrome
        private final List<String> words;
    }
}