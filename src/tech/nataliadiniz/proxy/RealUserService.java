package  tech.nataliadiniz.proxy;

public class RealUserService implements UserService { // implementa a interface UserService e representa o serviço real
    // de usuário, responsável por lidar com as operações de login e logout.
    @Override
    public void login(String username, String password) {
        System.out.println("Usuário " + username + " logado com sucesso.");
    }

    @Override
    public void logout() {
        System.out.println("Usuário deslogado.");
    }
}
