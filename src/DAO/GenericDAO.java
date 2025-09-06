package DAO;

import java.util.List;

public interface GenericDAO {

    public List<Object> listaTodos();

    public Object buscarPorId(int id);

    public Boolean cadastrar(Object object);

    public Boolean alterar(Object object);

    public void excluir(int id);
}
