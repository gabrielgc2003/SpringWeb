package com.example.projetin.SpringWeb.models;
import javax.persistence.*;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "administradores")
public class Administrador {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    
      @Column(name = "id")
      private int id;
     
            public int getId() {
            return id;
            }

            public void setId(int id) {
            this.id = id;
            }

      @Column(name = "nome", length = 100, nullable = false)
      private String nome;

            public String getNome() {
                  return nome;
            }

            public void setNome(String nome) {
                  this.nome = nome;
            }

      @Column(name = "email", length = 100, nullable = false)
      private String email;

            public String getEmail() {
                  return email;
            }

            public void setEmail(String email) {
                  this.email = email;
            }

      @Column(name = "senha", length = 255, nullable = false)
      private String senha;

            public String getSenha() {
                  return senha;
            }

            public void setSenha(String senha) {
                  this.senha = senha;
            }
      
      @Column(name = "observacao")
      @Type(type = "text")
      private String observacao;

            public String getObservacao() {
                  return observacao;
            }

            public void setObservacao(String observacao) {
                  this.observacao = observacao;
            }

}
