package com.gas.hellospring.controller;

import com.gas.hellospring.domain.Member;
import com.gas.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService memberService) {
        this.service = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        service.join(member).toString();
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> memberList = service.findMembers();
        model.addAttribute("memberList",memberList);
        return "members/memberList";
    }

}
