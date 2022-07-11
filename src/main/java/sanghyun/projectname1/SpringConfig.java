package sanghyun.projectname1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sanghyun.projectname1.repository.JdbcMemberRepository;
import sanghyun.projectname1.repository.JdbcTemplateMemberRepository;
import sanghyun.projectname1.repository.MemberRepository;
import sanghyun.projectname1.repository.MemoryMemberRepository;
import sanghyun.projectname1.service.MemberService;

import javax.sql.DataSource;
//change
@Configuration
public class SpringConfig {


    @Autowired  DataSource dataSource;  //spring에서 제공해주는 data source  아래방식처럼 해도 ok
/*
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/
    @Bean    //@Bean 보고 spring에 올림
    public MemberService memberService(){// 자바 코드로 직접 MemberService instance를 컨테이너에 등록
        return new MemberService(memberRepository());   //ctrl p로 오류난 이유 check 가능
    }

    @Bean
    public MemberRepository memberRepository(){   //위의 메서드에서 사용시 호출된다.
       // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);  //이렇게만 해주면 db 갈아 끼는 것이 가능해진다!!
        //다형성을 활용한다 ( 구현체를 바꿔끼기 가능) 객체지향언어( 스프링) 의 장점!!
        //dependency injection으로 기존 코드를 유지하고 바꿀것만 갈아끼우면 된다!
        //( jdbc >> 반복적 코드 많다)

        return new JdbcTemplateMemberRepository(dataSource);// jdbc 코드로 jdbc에서 반복적인 코드를 줄인다.
    }










}
