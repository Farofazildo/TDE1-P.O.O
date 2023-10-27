package control;

import dao.Conexao;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        //Estabelecimento de conexão
        Conexao conexao = new Conexao();
        conexao.conectar();

        //Criação do Scanner
        Scanner scanner = new Scanner(System.in);


        //Menu
        int menu = 0;

        while (menu != 5) {
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Inserir Curso");
            System.out.println("2 - Inserir Aluno");
            System.out.println("3 - Mostrar curso de aluno");
            System.out.println("4 - Listar alunos de curso");
            System.out.println("5 - Sair");
            System.out.println("-----------------------------------");
            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                //Variáveis a serem inseridas no banco de dados
                String cod_curso;
                String nome_curso;
                int carga_horaria;

                //Pedido ao usuário
                System.out.println("Insira o código do curso: ");
                cod_curso = scanner.nextLine();
                System.out.println("Insira o nome do curso: ");
                nome_curso = scanner.nextLine();
                System.out.println("Insira a carga horária do curso: ");
                carga_horaria = scanner.nextInt();
                scanner.nextLine();

                //Inserção no banco de dados
                conexao.insertCurso(cod_curso, nome_curso, carga_horaria);
                System.out.println("Curso inserido com sucesso!");
            } else if (menu == 2) {
                //Variavéis a serem inseridas no banco de dados
                String matricula;
                String nome_aluno;
                String cod_curso;

                //Pedido ao usuário
                System.out.println("Insira a matrícula do aluno: ");
                matricula = scanner.nextLine();

                System.out.println("Insira o nome do aluno:");
                nome_aluno = scanner.nextLine();

                System.out.println("Insira o curso do aluno: ");
                cod_curso = scanner.nextLine();

                //Inserção no banco de dados
                conexao.insertAluno(matricula, nome_aluno, cod_curso);
                System.out.println("Aluno inserido com sucesso!");
            } else if (menu == 3) {
                //Aluno a ser consultado
                String matricula;

                System.out.println("Digite a matricula do aluno que você quer consultar o curso: ");
                matricula = scanner.nextLine();
                conexao.consultarCurso(matricula);
            } else if (menu == 4) {
                //Curso a ser pesquisado
                String curso;

                System.out.println("Digite o codigo do curso que você deseja listar os alunos: ");
                curso = scanner.nextLine();
                conexao.consultarAlunos(curso);
            } else if (menu == 5) {
                conexao.desconectar();
            }
        }

    }
}
