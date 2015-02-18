package br.com.juliocnsouza.mongojpaeclipselink.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Developer.java -> Job:
 * <p>
 * @since 13/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Entity
@NoSql( dataFormat = DataFormatType.MAPPED )
public class Developer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Field( name = "_id" )
    private String id;

    @Basic
    private String nome;

    @Temporal( javax.persistence.TemporalType.DATE )
    private Date dataNascimento;

    @ElementCollection
    @Field( name = "skills" )
    private Set<String> skills;

    @Embedded
    private CoffeeTast coffeeTast;

    @ManyToOne( fetch = FetchType.EAGER )
    private Project project;

    @ManyToMany( fetch = FetchType.LAZY ,
                 cascade = CascadeType.ALL )
    private Set<Project> projects;

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

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills( Set<String> skills ) {
        this.skills = skills;
    }

    public CoffeeTast getCoffeeTast() {
        return coffeeTast;
    }

    public void setCoffeeTast( CoffeeTast coffeeTast ) {
        this.coffeeTast = coffeeTast;
    }

    public Project getProject() {
        return project;
    }

    public void setProject( Project project ) {
        this.project = project;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects( Set<Project> projects ) {
        this.projects = projects;
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
