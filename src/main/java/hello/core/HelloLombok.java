package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private  int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("이름");
        helloLombok.setAge(5);
        System.out.println("helloLombok = " + helloLombok.name + helloLombok.age);
        System.out.println("helloLombok = " + helloLombok);
    }
}
