package br.com.b2w.challengebackend.dto;

import br.com.b2w.challengebackend.dto.conversor.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by anderson on 03/11/16.
 */
public class Item implements Serializable {
    @JsonProperty("name")
    private String nome;
    @JsonProperty("code")
    private Long codigo;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("date")
    private LocalDateTime data;
    @JsonProperty("dimension")
    private Dimensao dimensao = new Dimensao();

    public Item() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Dimensao getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Item item = (Item) o;
            return !this.nome.equals(item.nome) ? false : (!this.codigo.equals(item.codigo) ? false : (!this.data.equals(item.data) ? false : this.dimensao.equals(item.dimensao)));
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.nome.hashCode();
        result = 31 * result + this.codigo.hashCode();
        result = 31 * result + this.data.hashCode();
        result = 31 * result + this.dimensao.hashCode();
        return result;
    }
}
