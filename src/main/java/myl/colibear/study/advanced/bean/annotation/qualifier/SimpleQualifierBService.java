package myl.colibear.study.advanced.bean.annotation.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SimpleQualifier(type = Type.B)
public class SimpleQualifierBService implements SimpleQualifierService {
    @Override
    public String get() {
        String canonicalName = this.getClass().getCanonicalName();
        show(canonicalName);
        return canonicalName;
    }
}
