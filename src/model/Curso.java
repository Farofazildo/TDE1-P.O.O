package model;

import java.util.HashSet;
import java.util.Set;

public class Curso {
    private String cod_curso;
    private String nome_curso;
    private int carga_horaria;

    private Set<Aluno> listaAlunos = new HashSet<>();


    public String getCodigo() {
        return cod_curso;
    }

    public void setCodigo(String codigo) {
        this.cod_curso = codigo;
    }

    public String getNome() {
        return nome_curso;
    }

    public void setNome(String nome) {
        this.nome_curso = nome;
    }

    public int getCargaHoraria() {
        return carga_horaria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.carga_horaria = cargaHoraria;
    }

    public Set<Aluno> getAlunos() {
        return listaAlunos;
    }

    public void InserirAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
    }
}