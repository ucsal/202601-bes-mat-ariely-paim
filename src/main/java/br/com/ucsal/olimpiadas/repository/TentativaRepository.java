package br.com.ucsal.olimpiadas.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ucsal.olimpiadas.model.Tentativa;

public class TentativaRepository {
    private List<Tentativa> lista = new ArrayList<>();
    private long proximoId = 1;

    public Tentativa salvar(Tentativa tentativa) {
        if (tentativa.getId() == 0) {
            tentativa.setId(proximoId++);
        }
        lista.add(tentativa);
        return tentativa;
    }

    public List<Tentativa> listarTodos() {
        return lista;
    }
}
