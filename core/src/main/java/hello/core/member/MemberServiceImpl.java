package hello.core.member;

/**
 * 문제점
 * 다른 DD저장소(현재는 MemoryMemberRepository)로 변경할 때 OCP 원칙을 잘 준수할까요? -> 위반. 클라이언트에서 코드 변경 됨
 * DIP를 잘 지키고 있을까요? -> 위반. 의존관계가 인터페이스(추상화) 뿐만 아니라 구현(구체화)까지 모두 의존하는 문제점이 있음
 * **/
public class MemberServiceImpl implements MemberService{

    // interface인 MemberRepository 객체를 선언했으나, 구현객체 없이는 Null Point Exception 발생. -> 실제 구현체인 MemoryMemberRepository를 할당.
    // MemberRepository(interface) 타입의 필드에 구현 클래스를 할당. -> 인터페이스와 구현 클래스 동시 의존
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
