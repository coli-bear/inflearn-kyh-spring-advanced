package myl.colibear.study.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    public void saveOrder(String itemId) {
        // TODO 저장 로직

        if(itemId == null) {
            throw new IllegalArgumentException("NotNull!!!");
        }

        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생 !!");
        }

        this.sleep(1000);


    }

    private void sleep(int millis) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
