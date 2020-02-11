package entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_SKILLS")
public class PersonSkills {

    @Id
    @Column(name = "id_skills")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSkills;

    @Column(name = "person_skills")
    private String personSkills;

    public PersonSkills() {
    }

    public int getIdSkills() {
        return idSkills;
    }

    public String getPersonSkills() {
        return personSkills;
    }

    public void setPersonSkills(String personSkills) {
        this.personSkills = personSkills;
    }

    @Override
    public String toString() {
        return "PersonSkills{" +
                "idSkills=" + idSkills +
                ", personSkills='" + personSkills + '\'' +
                '}';
    }
}
