package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRespository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRespository member = ac.getBean("memberRepository", MemberRespository.class);
        MemberRespository memberRepository = memberService.getMemberRepository();
        MemberRespository memberRespository = orderService.getMemberRespository();

        System.out.println("memberRespository -> 멤버 서비스 = " + memberRespository);
        System.out.println("memberRepository = -> 오더서비스  " + memberRepository);
        System.out.println("member = " + member);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRespository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());

    }
}
