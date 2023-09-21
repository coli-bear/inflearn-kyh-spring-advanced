package myl.colibear.study.advanced.bean.annotation.qualifier;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Service
@Validated
public class SimpleQualifierProcessor {
    private Optional<SimpleQualifierService> simpleQualifierService;

    public SimpleQualifierProcessor(@SimpleQualifier(type = Type.A) Optional<SimpleQualifierService> simpleQualifierService) {
        this.simpleQualifierService = simpleQualifierService;
    }

    public String action() {
        return this.simpleQualifierService.get().get();
    }

    public String action2(@Valid Dto dto) {
        return dto.get();
    }

}
