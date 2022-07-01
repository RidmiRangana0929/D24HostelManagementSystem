package lk.ijse.hibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student{
    @Id
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private Date dob;
    private String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private
    List<Reservation> reservationList=new ArrayList<>();

    public Student(String student_id, String name, String address, String contact_no, Date dob, String gender) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;
    }
}
