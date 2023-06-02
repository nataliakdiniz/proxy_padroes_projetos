package tech.nataliadiniz.proxy;

public interface UserService {
    void login(String username, String password);
    void logout(); // Define a interface comum para o objeto real e o proxy.
}
