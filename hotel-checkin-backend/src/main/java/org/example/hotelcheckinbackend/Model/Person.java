package org.example.hotelcheckinbackend.Model;

    import jakarta.persistence.*;
    import java.util.Objects;

    @Entity
    public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String documento;
        private String telefone;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        // toString method
        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", documento='" + documento + '\'' +
                    ", telefone='" + telefone + '\'' +
                    '}';
        }

        // equals and hashCode methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id) &&
                    Objects.equals(nome, person.nome) &&
                    Objects.equals(documento, person.documento) &&
                    Objects.equals(telefone, person.telefone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nome, documento, telefone);
        }
    }