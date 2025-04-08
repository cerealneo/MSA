package kr.co.mimmin.dto;


import kr.co.mimmin.document.User1Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private int age;
    private String addr;

    public User1Document toDocument(){
        return User1Document.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }

}