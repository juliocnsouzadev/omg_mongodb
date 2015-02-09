package br.com.juliocnsouza.dawii.exercicio4.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Worker.java -> Job:
 * <p>
 * @since 09/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
public class Worker implements Serializable {

    private String nome;
    private Date dataNascimento;
    private int idade;

    public Worker( String nome , Date dataNascimento ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = calculaIdade();
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

    public String getDataNascimentoText() {
        DateFormat df = DateFormat.getDateInstance();
        return df.format( dataNascimento );
    }

    public void setDataNascimento( Date dataNascimento ) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        idade = calculaIdade();
        return idade;
    }

    private int calculaIdade() {
        if ( dataNascimento == null ) {
            return 0;
        }
        long ano = 1000 * 60 * 60 * 24 * 365;
        Calendar cal = Calendar.getInstance();
        int anoI = cal.get( Calendar.YEAR );
        cal.setTime( dataNascimento );
        int anoF = cal.get( Calendar.YEAR );
        return anoI - anoF;
    }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateInstance();
        return nome + " de " + idade + " anos de idade, nascido em " + df.format( dataNascimento );
    }

}
