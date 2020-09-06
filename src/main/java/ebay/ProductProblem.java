package main.java.ebay;




import java.util.*;

public class ProductProblem {
    public long solution(int n, int[][] product) {

//        ArrayList<Product> products = new ArrayList<>();
//        for (int i = 0; i < product.length; i++) {
//            products.add(new Product(product[i][0],product[i][1], product[i][2]));
//        }

        PriorityQueue<Product> remainingProducts = new PriorityQueue<>(new totalSaleDesc());
        int totalRevenue=0;

        // n일동안 일반 판매대에서 판 수익
        for (int i = 0; i < product.length; i++) {
            Product product1 = new Product(product[i][0],product[i][1], product[i][2]);
            totalRevenue+=product1.sellFor(n);
            if(!product1.isSoldOut()){
                remainingProducts.add(product1);
            }
        }

        // 재고가 남은 물건들중 가장 하루 판매 수익을 많이 낼수 있는 것들 순서로 하루씩 판다.(행사판매대에서 판 수익 계산)
        while(n>0 && !remainingProducts.isEmpty()){
            Product nextProduct = remainingProducts.poll();
            totalRevenue+=nextProduct.sellFor(1);
            if(!nextProduct.isSoldOut()){
                remainingProducts.add(nextProduct);
            }
            n--;
        }

        return totalRevenue;

    }


}

class Product{
    private int stacks;
    private int price;
    private int maxSaleUnitPerDay;


    public Product(int stacks, int price, int maxSaleUnitPerDay) {
        this.stacks = stacks;
        this.price = price;
        this.maxSaleUnitPerDay = maxSaleUnitPerDay;

    }

    public int sellFor(int days){
        int totalAvailableUnits = Math.min(stacks, days * maxSaleUnitPerDay);
        decreaseStockBy(totalAvailableUnits);
        return totalAvailableUnits*price;
    }

    public int getAvailableUnitPerDay(){
        return Math.min(maxSaleUnitPerDay,stacks);
    }

    public int totalSalePerDay(){
        return price*getAvailableUnitPerDay();
    }

    public void decreaseStockBy(int num){
        this.stacks-=num;
    }

    public boolean isSoldOut(){
        if(this.stacks==0){
            return true;
        }
        return false;
    }
}

class totalSaleDesc implements Comparator<Product> {
    public int compare(Product a, Product b)
    {
        return Integer.compare(a.totalSalePerDay(),b.totalSalePerDay())*-1;
    }
}


