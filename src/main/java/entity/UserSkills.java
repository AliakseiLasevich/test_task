package entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_SKILLS")
public class UserSkills {

    @Id
    @Column(name = "id_skills")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSkills;

    @Column(name = "user_skills")
    private String userSkills;

    public UserSkills() {
    }

    public int getIdSkills() {
        return idSkills;
    }

    public String getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(String userSkills) {
        this.userSkills = userSkills;
    }


    @Override
    public String toString() {
        return "UserSkills{" +
                "idSkills=" + idSkills +
                ", userSkills='" + userSkills + '\'' +
                '}';
    }
}
