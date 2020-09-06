package main.java.Kakao;

import java.util.*;

public class
CandidateKeys {
    public int solution(String[][] relation) {

        Table table = new Table(relation);
        int columnNum = table.getColumnNum();

        List<Key> allKeys = new ArrayList<>();
        for (int i = 1; i < 1 << columnNum; i++) {
            allKeys.add(new Key(i));
        }

        UniqueKeys uniqueKeys = new UniqueKeys(table, allKeys);

        return uniqueKeys.getKeys();
    }


}

class Key {
    private int columnIdxBit;
    private List<Integer> idxList = new ArrayList<>();

    public Key(int columnIdxBit) {
        this.columnIdxBit = columnIdxBit;
        int temp = columnIdxBit;
        int idx = 0;
        while (temp != 0) {
            if ((temp & 1) != 0) {
                idxList.add(idx);
            }
            temp = temp >> 1;
            idx++;
        }
    }

    public List<Integer> getIdxList() {
        return this.idxList;
    }
    public int getColumnIdxBit(){
        return columnIdxBit;
    }
}

class Table {
    String[][] relation;

    public Table(String[][] relation) {
        this.relation = relation;
    }

    public Tuple getTuple(Key key, int rowNum) {
        Tuple tuple = new Tuple();
        List<Integer> idxList = key.getIdxList();
        for (Integer integer : idxList) {
            tuple.addValue(relation[rowNum][integer]);
        }
        return tuple;
    }

    public int getRowNum() {
        return relation.length;
    }

    public int getColumnNum() {
        return relation[0].length;
    }
}

class Tuple {

    List<String> values = new ArrayList<String>();

    public boolean isEqual(Tuple target) {
        if (!(this.getValueNum() == target.getValueNum())) {
            return false;
        }

        for (int i = 0; i < values.size(); i++) {
            String value1 = getValue(i);
            String value2 = target.getValue(i);
            if (!value1.equals(value2)) {
                return false;
            }
        }


        return true;
    }

    public void addValue(String value) {
        this.values.add(value);
    }

    public int getValueNum() {
        return this.values.size();
    }

    public String getValue(int idx) {
        return values.get(idx);
    }
}


class UniqueKeys {

    private LinkedList<Key> uniqueKeys = new LinkedList<Key>();

    private List<Key> candidateKeys= new ArrayList<>();

    private Table table;

    public UniqueKeys(Table table, List<Key> keys) {

        // relation 으로 모든 키값 만들기
        this.table = table;
        for (Key key : keys) {
            if (isUnique(key)) {
                uniqueKeys.add(key);
            }
        }
        Collections.sort(uniqueKeys,new idxSizeAsc());

        while(uniqueKeys.size()!=0){
            Key key = uniqueKeys.get(0);
            candidateKeys.add(key);
            uniqueKeys.remove(0);
            for (Iterator<Key> it = uniqueKeys.iterator();it.hasNext();) {
                Key next = it.next();
                if((key.getColumnIdxBit()&next.getColumnIdxBit())==key.getColumnIdxBit()){
                    it.remove();
                }
            }
        }

    }

    public boolean isUnique(Key key) {
        for (int i = 0; i < table.getRowNum() - 1; i++) {
            for(int j=i+1;j<table.getRowNum();j++){
                Tuple firstTuple = table.getTuple(key, i);
                Tuple secondTuple = table.getTuple(key, j);
                if (firstTuple.isEqual(secondTuple)) {
                    return false;
                }
            }

        }
        return true;
    }

    public int getKeys() {
        return candidateKeys.size();
    }
}

class idxSizeAsc  implements Comparator<Key> {
    public int compare(Key a, Key b)
    {
        return Integer.compare(a.getIdxList().size(),b.getIdxList().size());
    }
}