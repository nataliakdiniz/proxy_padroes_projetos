package tech.nataliadiniz;

import tech.nataliadiniz.proxy.ProxyUserService;
import tech.nataliadiniz.proxy.RealUserService;
import tech.nataliadiniz.proxy.UserService;

//No método main(), um objeto do tipo ProxyUserService é criado com as credenciais de administrador fornecidas.
// As operações de login e logout são chamadas no objeto UserService. O acesso é permitido apenas para o usuário
// com as credenciais de administrador, enquanto o acesso é negado para
public class Main {
    public static void main(String[] args) {
        UserService userService = new ProxyUserService("admin", "adminpass");

        userService.login("admin", "adminpass"); // Acesso permitido (admin)
        userService.login("john", "password"); // Acesso negado (usuário comum)
        userService.logout(); // Logout
    }
}
