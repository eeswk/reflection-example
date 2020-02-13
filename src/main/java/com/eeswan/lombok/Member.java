package com.eeswan.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * lombok 기본사용
 * 빌드시 자동으로 코드가 들어감
 *
 */
@Setter @Getter @EqualsAndHashCode
public class Member {

    private String name;
    private int age;

    public boolean isSameAge(Member member) {
        return this.age == member.age;
    }
}
