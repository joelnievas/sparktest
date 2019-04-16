import static spark.Spark.*;


public class clas1104 {

    public static void main(String[] args) {

        port(8080);

        get("/hola", (req, res) -> "Hola Mundo");

        get("/hola/:nombre", (req, res) -> {
            return  "Hola " + req.params(":nombre");
        });
    }

}
