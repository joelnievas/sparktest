import java.util.Collection;
import java.util.HashMap;

public class IntegrantesServiceMapImpl implements IntegranteService {

    private HashMap<String, Integrante> integranteMap;

    public IntegrantesServiceMapImpl(){
        integranteMap = new HashMap<String, Integrante>();
    }

    @Override
    public void addIntegrante(Integrante integrante) {
        integranteMap.put(integrante.getId(), integrante);

    }

    @Override
    public Collection<Integrante> getIntegrantes() {
        return integranteMap.values();
    }

    @Override
    public Integrante getIntegrantes(String id) {
        return integranteMap.get(id);
    }

    @Override
    public Integrante EditIntegrante(Integrante integrante) throws IntegranteExeption {
        try{
            if(integrante.getId() == null){
                throw new IntegranteExeption("El id no puede ser nulo.");
            }
            Integrante integranteEditar = integranteMap.get(integrante.getId());

            //A partir de ahora modifico
            if(integrante.getNombre() != null) {
                integranteEditar.setNombre(integrante.getNombre());
            }
            if(integrante.getApelldo() != null){
                integranteEditar.setApelldo(integrante.getApelldo());
            }
            if(integrante.getCorreo() != null){
                integranteEditar.setCorreo(integrante.getCorreo());
            }
            return integranteEditar;


        }catch (Exception exception){
            throw new IntegranteExeption(exception.getMessage());

        }
    }

    @Override
    public void DeleteIntegrante(String id) {
        integranteMap.remove(id);

    }

    @Override
    public boolean integranteExist(String id) {
        return integranteMap.containsKey(id);
    }
}
