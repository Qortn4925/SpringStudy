package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10퍼 할인")
    void vip_0(){
        // given
         Member member = new Member(1L,"MemberVip", Grade.VIP);
        // when
            int discount =discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 X")
    void vip_x(){
        // given
        Member member  = new Member(1l,"vipx",Grade.BASIC);

        //when
          int discount = discountPolicy.discount(member,10000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}