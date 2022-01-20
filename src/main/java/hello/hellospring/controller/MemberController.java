package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    }
}
