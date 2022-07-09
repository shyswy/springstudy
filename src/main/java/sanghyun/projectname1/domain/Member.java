package sanghyun.projectname1.domain;

public class Member {  //h2 database 에 member db 생성
    private Long id;  // 식별자  id는 시스템이 임의로 할당한다.
    private String name; //name 값

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
