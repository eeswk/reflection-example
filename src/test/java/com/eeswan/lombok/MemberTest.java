package com.eeswan.lombok;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void gettersetter() {
        Member member = new Member();
        member.setName("lee");

        Assert.assertEquals(member.getName(), "lee");
    }

}