package com.testingnew.stack;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Contact implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id @GeneratedValue @NotNull
    private Long id ;

    @NotNull
    @Size
    private String Fname;

    @NotNull
    @Size
    private String Lname;

    public Contact() {
        super();
    }

    public Contact(@NotNull @Size String fname, @NotNull @Size String lname) {
        super();
        Fname = fname;
        Lname = lname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public Contact updateProperties(Contact contact){
        this.Lname = contact.Lname;
        this.Fname = contact.Fname;
        return this;
    }

    @Override
    public String toString() {
        return "Contact [Fname=" + Fname + ", Lname=" + Lname + "]";
    }

}
