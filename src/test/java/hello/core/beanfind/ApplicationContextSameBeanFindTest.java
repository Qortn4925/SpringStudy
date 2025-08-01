package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복오류 발생")
    void findBeanByTypeDuplicate(){

        // 인스턴스로 조회하게 된다면, 두 개라서 선택을 하지 못해 오류 발생
//        MemberRespository bean = ac.getBean(MemberRespository.class);
        assertThrows(NoUniqueBeanDefinitionException.class,()-> ac.getBean(MemberRespository.class));

    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 , 빈 이름을 지정하면 된다.")
    void findBeanByName(){
        MemberRespository bean = ac.getBean("memberRespository1", MemberRespository.class);
        Assertions.assertThat(bean).isInstanceOf(MemberRespository.class);

    }
    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRespository> beansOfType = ac.getBeansOfType(MemberRespository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key+\"\" = " + key + "value= " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static  class SameBeanConfig{

        @Bean
        public MemberRespository memberRespository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRespository memberRespository2(){
            return new MemoryMemberRepository();
        }
    }
}
