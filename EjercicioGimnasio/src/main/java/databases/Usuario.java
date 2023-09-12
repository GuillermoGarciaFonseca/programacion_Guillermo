package databases;

public class Usuario {
    private String nombre,apellido,contrasenia,nivelEjer;

    public Usuario(String nombreUsuario, String apellidoUsuario, String contraUsuario, String nivelEjerUsuario, int tipoPerfilUsuario) {
    }

    public Usuario(String nombre, String apellido, String contrasenia, String nivelEjer) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.nivelEjer = nivelEjer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNivelEjer() {
        return nivelEjer;
    }

    public void setNivelEjer(String nivelEjer) {
        this.nivelEjer = nivelEjer;
    }
}
