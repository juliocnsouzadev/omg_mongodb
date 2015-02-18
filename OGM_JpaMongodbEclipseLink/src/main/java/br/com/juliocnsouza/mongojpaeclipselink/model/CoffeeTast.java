package br.com.juliocnsouza.mongojpaeclipselink.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Developer.java -> Job:
 * <p>
 * @since 13/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Embeddable
@NoSql( dataFormat = DataFormatType.MAPPED )
public class CoffeeTast implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    private Boolean strong;

    public CoffeeTast() {
        super();
    }

    public CoffeeTast( String nome , Boolean strong ) {

        this.nome = nome;
        this.strong = strong;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public Boolean getStrong() {
        return strong;
    }

    public void setStrong( Boolean strong ) {
        this.strong = strong;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode( this.nome );
        hash = 29 * hash + Objects.hashCode( this.strong );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final CoffeeTast other = ( CoffeeTast ) obj;
        if ( !Objects.equals( this.nome , other.nome ) ) {
            return false;
        }
        if ( !Objects.equals( this.strong , other.strong ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
