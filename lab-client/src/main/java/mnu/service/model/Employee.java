package mnu.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private Date birthday;
    private int salary;
}
