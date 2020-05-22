package com.testingnew.stack;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ContactAspect {

    @Autowired
    private ContactServiceImpl service;

        @Autowired
        private Javers javers;

    //@Value("${javers.author}")
    private String author_test="hamada";






    @Pointcut(value = "execution(* com.testingnew.stack.ContactServiceImpl.update(..)) && args(id,contact,..)")
    public void updateContactCut(Long id, Contact contact){}


    @Around("updateContactCut(id,contact)")
    public Object AuditAspect(ProceedingJoinPoint proceedingJoinPoint, Long id, Contact contact) throws Throwable {

        Contact toPersist = service.findOne(id);
        javers.commit(author_test, toPersist);

        Contact persisted = (Contact) proceedingJoinPoint.proceed();
        javers.commit(author_test, persisted);

        String changes = javers.findChanges( QueryBuilder.byInstance(persisted).build()).toString();
        System.out.println("\n \n *************************** \n\n"+changes+"\n \n *************************** \n\n");

        //redisDispatch.dispatch();

        return persisted;
    }
}
