package hello.core;


import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {


//     bean 이름 중복 테스트 요옫
//    @Bean(name="memoryMemberRepository")
//    MemberRespository memberRespository (){
//        return  new MemoryMemberRepository();
//    }

}
