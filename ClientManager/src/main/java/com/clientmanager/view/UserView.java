package com.clientmanager.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import com.clientmanager.database.DbService;
import com.clientmanager.model.Client;

public class UserView {

    public static final Scanner sc = new Scanner(System.in);

    public void loginScreen() {

        System.out.println("------ Tela de Login ------");
        System.out.println("Insira o nome de usuario ou email cadastrado:");
        String username = sc.nextLine();

        System.out.println("Insira a senha:");
        String password = sc.nextLine();

        boolean found = DbService.loginValidation(username, password);

        if (found) {
            
        } else {
            System.out.println("Usuario ou Senha incorreto!");
        }
    }

    public void mainScreen() {
        System.out.println("------ ClientManager ------");
        System.out.println("1) Listar clientes");
        System.out.println("2) Adicionar cliente");
        System.out.println("3) Remover cliente");
        System.out.println("4) Alterar cliente");
        System.out.println("5) Log de ações");
        System.out.println("6) Fechar programa");

        System.out.println("Escolha uma opção:");
        int response = Integer.parseInt(sc.nextLine());

        switch (response) {
        case 1: // Listar clientes cadastrados.
            List<Client> clients = DbService.clientList();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.printf("%-3s %-27s %-40s %-16s %-12s %-5s%n",
                    "ID", "Nome", "Email", "Telefone", "Nascimento", "Sexo");

            System.out.println("------------------------------------------------------------------------------------------------------------------------");

            for (Client c : clients) {
                String phoneFormatado = c.phone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");

                System.out.printf("%-3d %-27s %-40s %-16s %-12s %-5s%n",
                        c.id,
                        c.name,
                        c.email,
                        phoneFormatado,
                        c.birth_date.format(formatter),
                        c.gender
                );
            }
            break;

        case 2: // Adicionar novo cliente.
            System.out.println("------ Adicionar Cliente ------");
            System.out.println("Nome:");
            String name = sc.nextLine();

            System.out.println("Email:");
            String email = sc.nextLine();

            System.out.println("Telefone:");
            String phone = sc.nextLine();

            System.out.println("Data de Nascimento (aaaa-mm-dd):");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String birth_date = sc.nextLine();
            LocalDate birth = LocalDate.parse(birth_date, formatter1);

            System.out.println("Sexo (M - Masculino, F - Feminino, O - Outro, P - Prefiro não informar):");
            String gender = sc.nextLine();

            boolean successAddClient = DbService.addClient(name, email, phone, birth, gender);

            if (successAddClient) {
                System.out.println("Cliente adicionado a lista com sucesso!");
            } else {
                System.out.println("Não foi possivel adicionar o cliente, por favor valide as informações e tente novamente!");
            }

            break;

        case 3:
            // Remover cliente
            break;

        case 4:
            // Alterar cliente
            break;

        case 5:
            // Log de ações
            break;
        
        case 6:
            System.out.println("Encerrando...");
            System.exit(0);
            break;

        default:
            // caso nenhum case seja atendido
}
    }
}