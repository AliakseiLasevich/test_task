package entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_CONTACT_DATA")
public class UserContactData {

    @Id
    @Column(name = "id_contact_data")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContactData;

    @Column(name = "phone")
    private String phone;

    @Column(name = "site")
    private String site;

    @Column(name = "email")
    private String email;

    @Column(name = "messenger")
    private String messenger;

    public UserContactData() {
    }

    public int getIdContactData() {
        return idContactData;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    @Override
    public String toString() {
        return "UserContactData{" +
                "idContactData=" + idContactData +
                ", phone='" + phone + '\'' +
                ", site='" + site + '\'' +
                ", email='" + email + '\'' +
                ", messenger='" + messenger + '\'' +
                '}';
    }
}
