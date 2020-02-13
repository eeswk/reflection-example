package com.eeswan.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @EqualsAndHashCode
public class Member {

    private String name;
    private int age;

    public boolean isSameAge(Member member) {
        return this.age == member.age;
    }
}
