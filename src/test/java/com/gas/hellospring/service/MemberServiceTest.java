package com.gas.hellospring.service;

import com.gas.hellospring.domain.Member;
import com.gas.hellospring.repository.MemberRepository;
import com.gas.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService service;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        service = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long id = service.join(member);

        //then
        Member one = service.findOne(id).get();
        assertThat(member.getName()).isEqualTo(one.getName());
    }

    @Test
    public void joinDuplication(){
        Member member1 = new Member();
        member1.setName("spring");
        service.join(member1);

        Member member2 = new Member();
        member2.setName("spring");
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            service.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    @Test
    void validationMember() {
    }
}
