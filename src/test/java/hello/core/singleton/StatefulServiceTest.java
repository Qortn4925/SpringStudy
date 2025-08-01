package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A : a가 10000 주문
        statefulService1.order("userA",10000);
        // Thread B : B가 20000 주문
        statefulService1.order("userB", 20000);

        // ThreadA: 사용자 a가 주문 금액을 조회   >> 10000 이어야 하는데 2번째에 같은 객체를 조회하기에 필드값이같아서 20000 호출
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static  class TestConfig{

        @Bean
        public StatefulService statefulService(){
        return new StatefulService();
        }
    }

}