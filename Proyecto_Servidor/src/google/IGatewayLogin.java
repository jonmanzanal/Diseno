package google;

import data.Usuario;

public interface IGatewayLogin {
public boolean login(String emai,String contrasena);
public Usuario registrarUsuario(String email);
}