package com.testingnew.stack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StackApplicationTests {
    @Autowired
    ContactServiceImpl contactServiceImpl ;

    @Test
    void contextLoads() {
        Contact contact = new Contact("tom","hunx");
        //contactServiceImpl.save(contact);
        contact.setLname("cruise");
        contactServiceImpl.update(Long.valueOf(24), contact);
    }

}
