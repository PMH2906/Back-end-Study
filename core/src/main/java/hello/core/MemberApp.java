package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 * 문제점
 * 다른 DD저장소(현재는 MemoryMemberRepository)로 변경할 때 OCP 원칙을 잘 준수할까요? -> 위반. 클라이언트에서 코드 변경 됨
 * DIP를 잘 지키고 있을까요? -> 위반. 의존관계가 인터페이스(추상화) 뿐만 아니라 구현(구체화)까지 모두 의존하는 문제점이 있음
 * **/
public class MemberApp {
    // 인스턴스 참조 구조
    // 클라이언트 -> 회원 서비스(MemberServiceImpl) -> 메모리회원저장소(MemoryMemberRepository)
    public static void main(String[] args) {

        // MemberService(interface) 타입의 필드에 구현 클래스를 할당. -> 인터페이스와 구현 클래스 동시 의존
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
