public class Integrante implements Comparable<Integrante>{

    private String id;
    private String nombre;
    private String apelldo;
    private String correo;

    public enum Criterio{
        NOMBRE,
        APELLIDO,
        CORREO;
    }

    public static Criterio criterio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldo() {
        return apelldo;
    }

    public void setApelldo(String apelldo) {
        this.apelldo = apelldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }




    @Override
    public int compareTo(Integrante o) {

        switch (criterio){
            case NOMBRE:{
                return this.nombre.compareTo(o.nombre);
            }
            case APELLIDO: {
                return this.apelldo.compareTo(o.apelldo);
            }
            case CORREO: {
                return this.correo.compareTo(o.correo);
            }

        }
        return 0;

    }
}
