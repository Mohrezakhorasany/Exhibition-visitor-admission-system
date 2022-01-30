package hu.a_k.akademia.webfejlesztes.springboot.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
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
        record TestClass(@Palindrome  List<String> Words) {}
        final List<String> words = Arrays.asList("Anna", "civic", "kayak", "level", "madam", "mom", "noon", "racecar", "radar", "redder", "refer");
        final Set<ConstraintViolation<TestClass>> violations = validator.validate(new TestClass(words));
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    void shouldReturnViolation_whenCollectionContainsNotPalindromeWords() {
        record TestClass(@hu.a_k.akademia.webfejlesztes.springboot.validator.Palindrome List<String> words) {
        }
        final List<String> words = Arrays.asList("Anna", "civic", "kayak", "level", "madam", "mom", "noon", "racecar", "radar", "redder", "refer", "bus");
        final Set<ConstraintViolation<TestClass>> violations = validator.validate(new TestClass(words));
        Assertions.assertThat(violations).hasSize(1);
        final ConstraintViolation<TestClass> violation = violations.iterator().next();
        Assertions.assertThat(violation.getMessage()).isEqualTo("List of '%s' contained elements which are not palindrome".formatted(words));
    }
}