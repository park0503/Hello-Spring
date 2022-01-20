package hello.hellospring;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
    private final MemberRepository memberRepository;

//    private DataSource dataSource;
    //private EntityManager em;

    //@Autowired 생성자가 1개인 경우 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        //this.dataSource = dataSource;
        //this.em = em;
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


    //스프링 데이터 jpa 에서는 자동으로 빈에 등록을 해주기 때문에 위에 선언 및 대입만 해주고 해도 된다.
    //@Bean
    //public MemberRepository memberRepository() {
        //return new JpaMemberRepository(em);
    //}
}
