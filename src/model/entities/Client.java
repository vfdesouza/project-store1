package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    Integer id;
    private String name, cpf, email, address;
    private Date birthDate;

    public Client(Integer id, String name, String cpf, String email, String address, Date birthDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(), client.getName()) && Objects.equals(getCpf(), client.getCpf()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getAddress(), client.getAddress()) && Objects.equals(getBirthDate(), client.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getEmail(), getAddress(), getBirthDate());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
