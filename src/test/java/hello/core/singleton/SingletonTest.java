package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContaioner() {
        AppConfig appConfig = new AppConfig();
        //1.조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 출력결과 서로 참조값이 다른것을 확인할 수 있음. 하지만 , 어떤 특정 값을 기록할게 아니라 ,다를 필요가 없는데 메모리가 낭비되는거지
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService = " + memberService);

        // ms != ms2
        assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance = " + instance);
        System.out.println("instance2 = " + instance2);
        Assertions.assertThat(instance).isSameAs(instance2);

        //same   == , 객체 참조를 비교
        // equal  = ,
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//        AppConfig appConfig = new AppConfig();
        //1.조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //2. 조회 : 호출할 때마다 객체를 생성

        // 출력결과 서로 참조값이 다른것을 확인할 수 있음. 하지만 , 어떤 특정 값을 기록할게 아니라 ,다를 필요가 없는데 메모리가 낭비되는거지
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService = " + memberService);

        // ms != ms2
        assertThat(memberService).isSameAs(memberService2);
    }
}
