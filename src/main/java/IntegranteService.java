import java.util.Collection;

public interface IntegranteService {

    public void addIntegrante(Integrante integrante);
    public Collection<Integrante> getIntegrantes();
    public Integrante getIntegrantes(String id);
    public Integrante EditIntegrante(Integrante integrante) throws IntegranteExeption;
    public void DeleteIntegrante(String id);
    public boolean integranteExist(String id);

}
