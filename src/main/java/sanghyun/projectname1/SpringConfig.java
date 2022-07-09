package sanghyun.projectname1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sanghyun.projectname1.repository.MemberRepository;
import sanghyun.projectname1.repository.MemoryMemberRepository;
import sanghyun.projectname1.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean    //@Bean 보고 spring에 올림
    public MemberService memberService(){// 자바 코드로 직접 MemberService instance를 컨테이너에 등록
        return new MemberService(memberRepository());   //ctrl p로 오류난 이유 check 가능
    }

    @Bean
    public MemberRepository memberRepository(){   //위의 메서드에서 사용시 호출된다.
        return new MemoryMemberRepository();
    }










}
