package br.com.juliocnsouza.mongojpaexemple.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 * Developer.java -> Job:
 * <p>
 * @since 13/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Entity
@Table( name = "developers" )
public class Developer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid" ,
                       strategy = "uuid2" )
    private String id;

    @Column( nullable = false )
    private String nome;

    @Temporal( javax.persistence.TemporalType.DATE )
    @Column( nullable = false )
    private Date dataNascimento;

    @Column( nullable = false )
    private String skills;

    public Developer() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento( Date dataNascimento ) {
        this.dataNascimento = dataNascimento;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills( String skills ) {
        this.skills = skills;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null
                  ? id.hashCode()
                  : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Developer ) ) {
            return false;
        }
        Developer other = ( Developer ) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals(
                other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " skills: " + skills;
    }

}
