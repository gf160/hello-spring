package com.gas.hellospring.repository;

import com.gas.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /* 하나의 테스트가 끝날떄마다 실행됨(객체 초기화) */
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        System.out.println("save test");

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result= " + (result == member));
        Assertions.assertEquals(member, result);

        assertThat(member).isEqualTo(result);

        System.out.println("save() test ok");
    }

    @Test
    public void getName(){
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member);

        System.out.println("getName() test ok");


    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

        System.out.println("findAll() test ok");
    }

}
