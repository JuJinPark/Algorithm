package main.java.ebay;



import java.util.*;

public class ServiceDeskProblem {

    public int solution (int N,int[][] simulation_dat){

        Map<Integer,List<Customer>> customersPerArrivalTime = new HashMap();

        ServiceCenter serviceCenter = new ServiceCenter(N);
        for (int i = 0; i < simulation_dat.length; i++) {
            int arrivalTime=simulation_dat[i][0];
            int consultingTime=simulation_dat[i][1];
            List<Customer> list = customersPerArrivalTime.get(arrivalTime);
            if(list==null){
               List newList= new ArrayList<Customer>();
                newList.add(new Customer(arrivalTime,consultingTime));
                customersPerArrivalTime.put(arrivalTime,newList);
            }else{
                list.add(new Customer(arrivalTime,consultingTime));
                customersPerArrivalTime.put(arrivalTime,list);
            }
        }
        int currentTime= 0;

        while(true){
            List<Customer> customers = new ArrayList<>();
            if(customersPerArrivalTime.containsKey(currentTime)){
                customers = customersPerArrivalTime.get(currentTime);
                customersPerArrivalTime.remove(currentTime);
            }
            serviceCenter.serve(customers,currentTime);
            currentTime++;
            if(customersPerArrivalTime.isEmpty()&&serviceCenter.isDoneServingWaitingCustomers()){
                break;
            }

        }

        return serviceCenter.getTotalWaitingTime();


    }
}

class ServiceCenter {
    int MAX_SERVICE_DESK;
    PriorityQueue<Customer> consultingCustomers=new PriorityQueue<Customer>(new CustomerConsultingEndTimeASC());
    PriorityQueue<Customer> waitingCustomers=new PriorityQueue<Customer>(new CustomerArrivalTimeASC());
    int totalWaitingTime=0;
//    Time currentTime;

    public boolean isDoneServingWaitingCustomers(){
        if (waitingCustomers.size()==0){
            return true;
        }
        return false;
    }
    public ServiceCenter(int MAX_SERVICE_DESK) {
        this.MAX_SERVICE_DESK = MAX_SERVICE_DESK;
    }


    public void serve(List<Customer> customers,int currentTime){
        for (Customer customer : customers) {
            waitingCustomers.add(customer);
        }
        serveConsultingCustomers(currentTime);
        serveWaitingCustomers(currentTime);
    }

    private boolean isServiceable(){
        if(consultingCustomers.size()<MAX_SERVICE_DESK){
            return true;
        }
        return false;
    }

    private void serveConsultingCustomers(int currentTime){
        while(!consultingCustomers.isEmpty()){
            Customer customer = consultingCustomers.peek();
            if(customer.isDone(currentTime)){
                consultingCustomers.poll();
            }else{
                break;
            }
        }
    }

    private void serveWaitingCustomers(int currentTime){

        while(!waitingCustomers.isEmpty()){
            Customer customer = waitingCustomers.peek();
            if(isServiceable()){
                waitingCustomers.poll();
                startConsulting(customer,currentTime);
            }else{
                break;
            }
        }
    }

    private void startConsulting(Customer customer,int currentTime){
        customer.consult(currentTime);
        totalWaitingTime+=customer.getConsultStartTime()-customer.getArrivalTime();
        consultingCustomers.add(customer);
    }

    public int getTotalWaitingTime() {
        return totalWaitingTime;
    }
}

class Customer {
    int consultStartTime;
    int arrivalTime;
    int consultingTime;
    int consultEndTime;

    public Customer(int arrivalTime,int consultingTime) {
        this.arrivalTime=arrivalTime;
        this.consultingTime = consultingTime;
    }

    public void consult(int consultStartTime){
        this.consultStartTime = consultStartTime;
        this.consultEndTime=consultStartTime+consultingTime;
    }


    public int getConsultEndTime() {
        return consultEndTime;
    }

    public int getConsultStartTime() {
        return consultStartTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getConsultingTime() {
        return consultingTime;
    }

    public boolean isDone(int currentTime) {
        if(currentTime==this.consultEndTime){
            return true;
        }
        return false;
    }
}

class CustomerConsultingEndTimeASC implements Comparator<Customer> {
    public int compare(Customer a, Customer b)
    {
        return Integer.compare(a.getConsultEndTime(),b.getConsultEndTime());
    }
}

class CustomerArrivalTimeASC implements Comparator<Customer> {
    public int compare(Customer a, Customer b)
    {
        return Integer.compare(a.getArrivalTime(),b.getArrivalTime());
    }
}
