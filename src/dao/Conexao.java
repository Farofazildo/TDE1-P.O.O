package dao;

import java.sql.*;


public class Conexao {
    Connection connection = null;
    String url = "jdbc:postgresql://localhost:5432/escola";
    String user = "postgres";
    String password = "postgres";

    //Estabelecer conexão
    public void conectar() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Encerrar conexão
    public void desconectar() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            connection.close();
            System.out.println("Conexão encerrada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Inserir curso
    public void insertCurso(String cod_curso, String nome_curso, int carga_horaria) {

        try {
            String insertSql = "INSERT INTO curso (cod_curso,nome_curso,carga_horaria) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, cod_curso);
            preparedStatement.setString(2, nome_curso);
            preparedStatement.setInt(3, carga_horaria);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Inserir Aluno
    public void insertAluno(String matricula, String nome_aluno, String cod_curso) {
        try {
            String insertSql = "INSERT INTO aluno (matricula, nome_aluno, cod_curso) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, nome_aluno);
            preparedStatement.setString(3, cod_curso);
            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Consultar curso de determinado aluno
    public void consultarCurso(String matricula) {
        try {
            String selectSql = "SELECT nome_curso FROM curso WHERE cod_curso =(SELECT cod_curso FROM aluno WHERE matricula = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setString(1, matricula);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String curso = rs.getString("nome_curso");
                System.out.println("Curso: " + curso);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Mostrar a lista de alunos de um determinado curso
    public void consultarAlunos(String cod_curso) {
        try {
            String selectSql = "SELECT nome_aluno FROM aluno WHERE cod_curso= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setString(1, cod_curso);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome_aluno");
                System.out.println("Aluno: " + nome);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}