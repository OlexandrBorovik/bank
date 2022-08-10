package org.example;

import javax.persistence.*;

@Entity
@Table(name="Exchangerates")
public class Exchangerates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(nullable=false)
    private int uah;
    private int usd;
    private int euro;

    public Exchangerates() {
    }

    public Exchangerates(int uah, int usd, int euro) {
        this.uah = uah;
        this.usd = usd;
        this.euro = euro;
    }

    public int getUah() {
        return uah;
    }

    public void setUah(int uah) {
        this.uah = uah;
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Exchangerates{" +
                "id=" + id +
                ", uah=" + uah +
                ", usd=" + usd +
                ", euro=" + euro +
                '}';
    }
}
