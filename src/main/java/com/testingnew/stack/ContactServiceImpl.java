package com.testingnew.stack;


import org.javers.core.Javers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@Transactional
public class ContactServiceImpl {

    @Autowired
    private ContactRepository contactrepository ;

    //@Autowired
    //private Javers javers;


    public List<Contact> findAll() {
        return contactrepository.findAll();
    }
   /* public Contact save(Contact contact) {
        return contactrepository.saveAndFlush(contact);
    }*/
    public Contact findOne(Long id) {
        return contactrepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Contact update(Long id, Contact contact) {
        return contactrepository.save(contactrepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new)
                        .updateProperties(contact));
    }
}