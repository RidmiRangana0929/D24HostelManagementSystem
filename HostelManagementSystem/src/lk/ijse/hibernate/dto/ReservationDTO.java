package lk.ijse.hibernate.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationDTO {
    private String res_id;
    private LocalDate date;
    private String student_id;
    private String room_type_id;
    private String status;

}
