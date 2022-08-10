package org.example;

import javax.persistence.*;

@Entity
@Table(name="Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(nullable=false)
    private int sun;
    private String valute;

    public Transactions() {
    }

    public Transactions(int sun, String valute) {
        this.sun = sun;
        this.valute = valute;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public String getValute() {
        return valute;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", sun=" + sun +
                ", valute='" + valute + '\'' +
                '}';
    }
}
