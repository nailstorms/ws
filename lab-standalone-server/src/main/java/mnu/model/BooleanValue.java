package mnu.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class BooleanValue {
    private boolean value;
}
