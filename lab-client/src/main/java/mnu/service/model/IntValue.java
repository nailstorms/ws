package mnu.service.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class IntValue {
    private int value;
}
