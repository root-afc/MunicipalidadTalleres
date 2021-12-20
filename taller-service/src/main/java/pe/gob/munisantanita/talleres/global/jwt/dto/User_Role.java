package pe.gob.munisantanita.talleres.global.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_role")
@Entity
public class User_Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer user_role_id;
    private Integer userId;
    private Integer roleId;
}
