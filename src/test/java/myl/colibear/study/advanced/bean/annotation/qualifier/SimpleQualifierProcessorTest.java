package myl.colibear.study.advanced.bean.annotation.qualifier;

import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.constraintvalidators.bv.number.sign.PositiveValidatorForInteger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SimpleQualifierProcessorTest {

    @Autowired
    private SimpleQualifierProcessor simpleQualifierProcessor;

    @Test
    void test() {
        String action = this.simpleQualifierProcessor.action();
        assertThat(action).isEqualTo(SimpleQualifierAService.class.getCanonicalName());
    }

    @Test
    void test2() {
        Dto dto = new Dto();
        dto.setPositiveInteger(List.of(-10));
        PositiveValidatorForInteger validator = new PositiveValidatorForInteger();
        dto.getPositiveInteger().forEach(i -> {
            boolean valid = validator.isValid(i, null);
            System.out.println("valid = " + valid);
        });
        assertThrows(ConstraintViolationException.class, () -> this.simpleQualifierProcessor.action2(dto));
    }
}