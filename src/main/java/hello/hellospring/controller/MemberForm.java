package hello.hellospring.controller;

public class MemberForm
{
    private String name;

    public String getName() {
        return name;
    }

    //spring이 setName을 통해 private한 변수 name에 값을 넣어준다.
    public void setName(String name) {
        this.name = name;
    }
}
