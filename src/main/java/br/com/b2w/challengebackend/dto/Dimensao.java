package br.com.b2w.challengebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by anderson on 03/11/16.
 */
public class Dimensao implements Serializable {
    @JsonProperty("weight")
    private Double peso;
    @JsonProperty("height")
    private Double altura;
    @JsonProperty("width")
    private Double largura;
    @JsonProperty("length")
    private Double comprimento;

    public Dimensao() {
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return this.altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return this.largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Dimensao dimensao = (Dimensao) o;
            if (this.peso != null) {
                if (!this.peso.equals(dimensao.peso)) {
                    return false;
                }
            } else if (dimensao.peso != null) {
                return false;
            }

            label46:
            {
                if (this.altura != null) {
                    if (this.altura.equals(dimensao.altura)) {
                        break label46;
                    }
                } else if (dimensao.altura == null) {
                    break label46;
                }

                return false;
            }

            if (this.largura != null) {
                if (this.largura.equals(dimensao.largura)) {
                    return this.comprimento != null ? this.comprimento.equals(dimensao.comprimento) : dimensao.comprimento == null;
                }
            } else if (dimensao.largura == null) {
                return this.comprimento != null ? this.comprimento.equals(dimensao.comprimento) : dimensao.comprimento == null;
            }

            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.peso != null ? this.peso.hashCode() : 0;
        result = 31 * result + (this.altura != null ? this.altura.hashCode() : 0);
        result = 31 * result + (this.largura != null ? this.largura.hashCode() : 0);
        result = 31 * result + (this.comprimento != null ? this.comprimento.hashCode() : 0);
        return result;
    }
}