package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRespository memberRepository;

    public MemberServiceImpl(MemberRespository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public  void join(Member member){
        memberRepository.save(member);
    };
    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    };

    //테스트용
    public MemberRespository getMemberRepository (){
        return  memberRepository;
    }
}
