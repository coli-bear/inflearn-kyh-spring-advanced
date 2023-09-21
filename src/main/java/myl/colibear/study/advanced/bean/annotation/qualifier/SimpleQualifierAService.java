package myl.colibear.study.advanced.bean.annotation.qualifier;

import org.springframework.stereotype.Service;

@Service
@SimpleQualifier(type = Type.A)
public class SimpleQualifierAService implements SimpleQualifierService {
    @Override
    public String get() {
        String canonicalName = this.getClass().getCanonicalName();
        show(canonicalName);
        return canonicalName;
    }
}
