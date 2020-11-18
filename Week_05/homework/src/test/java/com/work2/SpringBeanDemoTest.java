package com.work2;

import org.junit.Test;
import org.junit.Assert;

public class SpringBeanDemoTest {
    @Test
    public void testBeanLoad() {
        assertStudent(SpringBeanDemo.loadFromAnnotation());
        assertStudent(SpringBeanDemo.loadFromProperties());
        assertStudent(SpringBeanDemo.loadFromXML());
    }

    private void assertStudent(Student student) {
        Assert.assertEquals(student.getId(), 110);
        Assert.assertEquals(student.getName(), "cc");
    }
}
