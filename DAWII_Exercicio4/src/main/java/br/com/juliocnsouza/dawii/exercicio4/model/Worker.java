package br.com.juliocnsouza.dawii.exercicio4.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
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
    private String setor;
    private String funcao;
    private Double salario;

    public Worker( String nome , Date dataNascimento ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.idade = calculaIdade();
    }

    public Worker() {
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
        if ( dataNascimento != null ) {
            DateFormat df = DateFormat.getDateInstance( DateFormat.MEDIUM );
            return df.format( dataNascimento );
        }
        return "";
    }

    public void setDataNascimento( Date dataNascimento ) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        idade = calculaIdade();
        return idade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor( String setor ) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public String getSalarioText() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format( salario );
    }

    public void setSalario( Double salario ) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao( String funcao ) {
        this.funcao = funcao;
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
