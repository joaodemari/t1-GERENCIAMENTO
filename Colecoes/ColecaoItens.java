package Colecoes;

import java.util.ArrayList;
import bean.Item;

public class ColecaoItens {
    private ArrayList<Item> itens;

    public ColecaoItens() {
        itens = new ArrayList<Item>();
    }

    public boolean addItem(Item i) {
        return itens.add(i);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public Item buscarItemPorNome(String nome) {
        for (Item i : itens) {
            if (i.getNome().equals(nome)) {
                return i;
            }
        }
        return null;
    }
}
