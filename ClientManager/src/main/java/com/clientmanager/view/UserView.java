package com.clientmanager.view;

import java.util.Scanner;
import com.clientmanager.database.DbService;

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

        System.out.println("6) Escolha uma opção:");
        int response = Integer.parseInt(sc.nextLine());

        switch (response) {
        case 1:
            // Listar clientes
            break;

        case 2:
            // Adicionar cliente
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
            // Sair do pograma
            break;

        default:
            // caso nenhum case seja atendido
}
    }
}