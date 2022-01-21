package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    //member 컨트롤러 이외에 컨트롤러에서 해당 service를 공용으로 이용할 수 있으므로
    //안좋은 방법. 또 이 서비스는 별 기능이 없으므로 여러개를 만들 필요도 없다.
    //private final MemberService memberService = new MemberService();

    //따라서 스프링 컨테이너에 등록을 한 뒤 그것을 사용해야한다.
    private final MemberService memberService;

    @Autowired //생성자에서 이거 쓰면 객체 생성 시점에 스프링에 등록 되어있는
    // member Service에 wired 해 줌 => 의존성 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
        //Aop를 이용해 proxy class가 주입되는지 확인하기 위한 출력문.
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
