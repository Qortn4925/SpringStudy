package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private  final MemberRespository memberRespository ;
    private   final  DiscountPolicy discountPolicy;



    //    private final DiscountPolicy discountPolicy =new FixDiscountPolicy();
    // 할인 정책 변화로 인해 클래스 변경
//    private final DiscountPolicy discountPolicy =new RateDiscountPolicy();

    // 이렇게 하면 , 의존 관계는 추상화 까지만 의존하지만 실제 구현 객체가 없어 널 포인터 오류가 발생한다.

    // 롬복으로 인해 제거
@Autowired
    public OrderServiceImpl(MemberRespository memberRespository, DiscountPolicy discountPolicy) {
        this.memberRespository = memberRespository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, Integer itemPrice) {
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return  new Order(memberId,itemName,itemPrice,discountPrice);
    }

    public MemberRespository getMemberRespository() {
        return memberRespository;
    }

}
