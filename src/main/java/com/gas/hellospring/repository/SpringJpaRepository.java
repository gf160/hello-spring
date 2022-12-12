package com.gas.hellospring.repository;

import com.gas.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    public Optional<Member> findByName(String name);

}
