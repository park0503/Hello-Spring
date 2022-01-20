package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name); // 특정 칼럼으로 찾는거기 때문에 공통에 안들어감. 따라서 이렇게 직접 만들어 줘야 함.
    //JPQL: select m from Member m where m.name = ? 로 번역 됨
    //findByNameAnd... findByNameOr... 이런 식으로 쓰임
}
