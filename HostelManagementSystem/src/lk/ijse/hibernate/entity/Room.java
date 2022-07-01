package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room{

    @Id
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private
    List<Reservation> reservationList=new ArrayList<>();

    public Room(String room_type_id, String type, String key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }
}
