
package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n=== MENU CRUD ===");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    criarUsuario(sc);
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    atualizarUsuario(sc);
                    break;

                case 4:
                    deletarUsuario(sc);
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }

    // CREATE
    private static void criarUsuario(Scanner sc) {
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        Usuario u = new Usuario(nome, idade);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(u);

        tx.commit();
        session.close();

        System.out.println("Usuário criado com sucesso!");
    }

    // READ
    private static void listarUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Usuario> lista =
                session.createQuery("from Usuario", Usuario.class).list();

        session.close();

        System.out.println("\n--- LISTA DE USUÁRIOS ---");
        for (Usuario u : lista) {
            System.out.println("ID: " + u.getId() +
                               " | Nome: " + u.getNome() +
                               " | Idade: " + u.getIdade());
        }
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        }
    }

    // UPDATE
    private static void atualizarUsuario(Scanner sc) {

        System.out.print("Digite o ID do usuário que deseja atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Usuario u = session.get(Usuario.class, id);

        if (u == null) {
            System.out.println("Usuário não encontrado!");
            session.close();
            return;
        }

        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();
        System.out.print("Nova idade: ");
        int novaIdade = sc.nextInt();
        sc.nextLine();

        u.setNome(novoNome);
        u.setIdade(novaIdade);

        session.merge(u);
        tx.commit();
        session.close();

        System.out.println("Usuário atualizado com sucesso!");
    }

    // DELETE
    private static void deletarUsuario(Scanner sc) {

        System.out.print("Digite o ID do usuário que deseja deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Usuario u = session.get(Usuario.class, id);

        if (u == null) {
            System.out.println("Usuário não encontrado!");
            session.close();
            return;
        }

        session.remove(u);
        tx.commit();
        session.close();

        System.out.println("Usuário deletado com sucesso!");
    }
}
