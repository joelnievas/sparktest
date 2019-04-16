import com.google.gson.Gson;

import static spark.Spark.*;

public class SparkRestEjemplo {
    public static void main(String[] args) {

        final IntegrantesServiceMapImpl integrantesService = new IntegrantesServiceMapImpl();

        post("/integrante",(request, response) -> {
            response.type("application/json");
            Integrante integrante = new Gson().fromJson(request.body(), Integrante.class);
            integrantesService.addIntegrante(integrante);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/integrante",(request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(
                    integrantesService.getIntegrantes())));
        });


        get("/integrante/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(
                    integrantesService.getIntegrantes(request.params(":id")))));
        });

        put("/integrante", (request, response) -> {
            response.type("application/json");
            Integrante integrante = new Gson().fromJson(request.body(), Integrante.class);
            Integrante integranteEditado = integrantesService.EditIntegrante(integrante);
            if(integranteEditado != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(integranteEditado)));
            }
            else{
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,"Error al editar el integrante."));
            }

        });

        delete("/integrante/:id" , (request, response) -> {
            response.type("application/json");
            integrantesService.DeleteIntegrante(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "Integrante Borrado"));
        });

        options("/integrante/:id", (request, response) -> {
            response.type("appication/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (integrantesService.integranteExist(request
                    .params(":id")) ? "El integrante existe." : "El integrante no existe.")));
        });
    }
}
