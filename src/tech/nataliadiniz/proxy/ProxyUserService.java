package tech.nataliadiniz.proxy;
//ProxyUserService também implementa a interface UserService e atua como um proxy de segurança em torno do serviço real
// de usuário. Ela verifica se o usuário que está tentando fazer login é um administrador, comparando
// o nome de usuário e senha fornecidos com as credenciais de administrador definidas no proxy.
// Se as credenciais forem válidas, a chamada é encaminhada para o serviço real de usuário.
// Caso contrário, o acesso é negado.

public class ProxyUserService implements UserService {
    private RealUserService realUserService;
    private String adminUsername;
    private String adminPassword;

    public ProxyUserService(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    @Override
    public void login(String username, String password) {
        if (isAdmin(username, password)) {
            getRealUserService().login(username, password);
        } else {
            System.out.println("Acesso negado. Você não tem permissão para fazer login.");
        }
    }

    @Override
    public void logout() {
        getRealUserService().logout();
    }

    private RealUserService getRealUserService() {
        if (realUserService == null) {
            realUserService = new RealUserService();
        }
        return realUserService;
    }

    private boolean isAdmin(String username, String password) {
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
}
