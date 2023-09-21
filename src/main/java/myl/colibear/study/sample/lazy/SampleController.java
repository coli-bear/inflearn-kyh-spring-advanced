package myl.colibear.study.sample.lazy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final ApplicationContext applicationContext;
//    @Lazy
//    private final SampleLazy sampleLazy;
//    private final SampleEager sampleEager;

    @GetMapping("/lazy")
    public String sampleLazy() {
        SampleLazy sampleLazy = (SampleLazy) this.applicationContext.getBean("sample_lazy");
        sampleLazy.get();
        return "sample lazy loading";
    }

    @GetMapping("eager")
    public String sampleEager() {
        SampleEager sampleEager = (SampleEager) this.applicationContext.getBean("sample_eager");
        sampleEager.get();
        return "sample eager loading";
    }
}
