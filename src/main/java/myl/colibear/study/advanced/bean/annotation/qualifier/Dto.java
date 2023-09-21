package myl.colibear.study.advanced.bean.annotation.qualifier;

import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;


@Data
public class Dto {
    private List<@Positive Integer> positiveInteger;

    public String get() {
        return positiveInteger.toString();
    }
}


