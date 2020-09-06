package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        SymbolToIntMapper symbolToIntMapper = new SymbolToIntMapper();
        return symbolToIntMapper.getSymbol(num);

    }

//    private int getBigestDigiNum(int num){
//        String numInString=num+"";
//        int firstDigit = Integer.parseInt(numInString.charAt(0)+"");
//        int numberOfZero=numInString.length()-1;
//
//        return firstDigit*(int)(Math.pow(10,numberOfZero));
//    }
}

class SymbolToIntMapper {

    private static List<Symbol> symbolList = new ArrayList<Symbol>();
    static {
        symbolList.add(new Symbol("I",1));
        symbolList.add(new Symbol("IV",4));
        symbolList.add(new Symbol("V",5));
        symbolList.add(new Symbol("IX",9));
        symbolList.add(new Symbol("X",10));
        symbolList.add(new Symbol("XL",40));
        symbolList.add(new Symbol("L",50));
        symbolList.add(new Symbol("XC",90));
        symbolList.add(new Symbol("C",100));
        symbolList.add(new Symbol("CD",400));
        symbolList.add(new Symbol("D",500));
        symbolList.add(new Symbol("CM",900));
        symbolList.add(new Symbol("M",1000));
    }


    public String getSymbol(int num){

        StringBuilder result = new StringBuilder();
        for (int i = symbolList.size()-1; i >=0; i--) {

            while(num/symbolList.get(i).getValue()!=0){
                Symbol currentSymbol=symbolList.get(i);
                result.append(currentSymbol.getSymbol());
                num-=currentSymbol.getValue();

            }
        }
        return result.toString();
    }
}

class Symbol{
    String symbol;
    int value;

    public Symbol(String symbol,int value) {
        this.symbol = symbol;
        this.value=value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
}
