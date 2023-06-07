package lesson4.Homework.Tree;

import lesson4.Homework.Tree.Tree;

import java.util.ArrayList;
import java.util.logging.Level;

public class TreeService {
    Tree tree;
    ArrayList<String> array;

    public TreeService(Tree tree) {
        this.tree = tree;
        this.array = new ArrayList<String>();
    }


    public void print() {
        if (!array.isEmpty()) {
            array.clear();
        }
        int level = 0;
        array.add("    |" + (tree.getRoot()).toString() + "|  ") ;
        level = assemblyTree(tree.getRoot(), ++level);
        //return array.toString();
        for (int i = 0; i < array.size()-1; i++) {
            System.out.println(array.get(i));
        }
    }

    private Integer assemblyTree(Node curentNode, Integer level) {
        //Создаём уровень в массиве
        if ((array.size()-1) <= level) {
            array.add(level,"");
        }
        //Проверям наличие листов у узла
        if (curentNode.getLeft() == null && curentNode.getRight() == null) {
            return --level;
        }
        // Вносим листы в массив
        if (curentNode.getLeft() != null) {
            array.set(level, array.get(level) + " |" + curentNode.getLeft().getValue().toString()+"| ");
        } else {
            array.set(level, array.get(level) + "|**|");
        }
        if (curentNode.getRight() != null) {
            array.set(level, array.get(level) + " |" + curentNode.getRight().getValue().toString()+"| ");
        } else {
            array.set(level, array.get(level) + "|**|");
        }
        //Добавляем отступы во всём массиве
        addPadding();
        //Переходим ко следующему уровню
        if (curentNode.getLeft() != null) {
            assemblyTree(curentNode.getLeft(), ++level);
        }
        if (curentNode.getRight() != null) {
            assemblyTree(curentNode.getRight(), ++level);
        }

        return --level;
    }

    private Boolean addPadding(){
        for (int i = 0; i < array.size(); i++) {
            array.set(i, "  " + array.get(i));
        }
        return true;
    }
}
