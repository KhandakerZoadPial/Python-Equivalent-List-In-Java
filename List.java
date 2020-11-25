package PialsPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



public class List extends Individual {
    private ArrayList list;
    private boolean can_be_sorted_in_case_of_integer = true;
    private boolean can_be_sorted_in_case_of_double = true;
    private boolean can_be_sorted_in_case_of_string = true;

    public List() {
        list = new ArrayList();
    }

    //......Adding Functionality........
    public void add(Object obj) {
        Individual i = new Individual(obj);
        list.add(i);

        if (i.data instanceof Integer) {
            can_be_sorted_in_case_of_string = false;
            can_be_sorted_in_case_of_double = false;
        } else if (i.data instanceof String) {
            can_be_sorted_in_case_of_integer = false;
            can_be_sorted_in_case_of_double = false;

        } else if (i.data instanceof Double) {
            can_be_sorted_in_case_of_string = false;
            can_be_sorted_in_case_of_integer = false;

        } else if (i.data instanceof Boolean) {
            can_be_sorted_in_case_of_integer = false;
            can_be_sorted_in_case_of_double = false;
            can_be_sorted_in_case_of_string = false;
        }


    }

    public void add_at(int index, Object data) {
        Individual i = new Individual(data);
        this.list.set(index, i);
    }

    public void add_first(int i, Object d) {
        this.add_at(i, d);
    }

    //.......Adding Functionality Ends.....


    public boolean is_empty() {
        return list.isEmpty();
    }

    //.......Removing Functionality...........
    public void remove_at(int index) {

        if (size() > 0) {
            list.remove(index);
        }
    }

    public void remove_last() {
        this.remove_at(this.size() - 1);
    }

    public void remove_first() {
        list.remove(0);
    }
    //.......Removing Functionality Ends...............


    //.......Accessing Functionality Ends...............
    public <T> T get(int index) {
        Individual i = (Individual) list.get(index);
        if (i.data instanceof Integer) {
            return (T) (Integer) (int) i.data;
        } else if (i.data instanceof String) {
            return (T) (String) i.data;
        } else if (i.data instanceof Double) {
            return (T) (Double) (double) i.data;
        } else if (i.data instanceof Boolean) {
            return (T) (Boolean) (boolean) i.data;
        } else if (i.data instanceof Array) {
            return (T) (Array) i.data;
        } else if (i.data instanceof ArrayList) {
            return (T) (ArrayList) i.data;
        } else
            return null;
    }

    public void show() {
        int s = this.size();
        System.out.print("[");
        for (int i = 0; i < s - 1; i++) {
            System.out.print(this.get(i) + ", ");
        }
        if (s != 0) {
            System.out.print(this.get(s - 1) + "");
        }
        System.out.println("]");
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        this.list.clear();
    }


    public ArrayList sort() {
        if (can_be_sorted_in_case_of_double) {
            ArrayList<Double> l = new ArrayList<Double>();
            int s = this.size();
            for (int i = 0; i < s; i++) {
                l.add((double) this.get(i));
            }
            Collections.sort(l);
            return l;
        } else if (can_be_sorted_in_case_of_integer) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            int s = this.size();
            for (int i = 0; i < s; i++) {
                l.add(this.get(i));
            }
            Collections.sort(l);
            return l;
        } else if (can_be_sorted_in_case_of_string) {
            ArrayList<String> l = new ArrayList<String>();
            int s = this.size();
            for (int i = 0; i < s; i++) {
                l.add(this.get(i));
            }
            Collections.sort(l);
            return l;
        }
        return null;

    }
    //......Accessing Functionality Ends...........

    //......Adding two lists Functionality Starts...........
    public void merge(List f2) {
         int s = f2.size();
         for(int i=0; i<s; i++) {
             this.add(f2.get(i));
         }
    }


}


class Individual {
    protected Object data;

    Individual() {

    }

    Individual(Object obj) {
        if(obj instanceof Integer) {
            int i = (Integer) obj;
            this.data = i;
        }
        else if( obj instanceof String){
            String s = (String) obj;
            this.data = s;
        }
        else if( obj instanceof Double){
            double d = (Double) obj;
            this.data = d;
        }
        else if( obj instanceof Boolean){
            boolean b = (Boolean) obj;
            this.data = b;
        }
        else if( obj instanceof ArrayList){
            ArrayList arr = (ArrayList) obj;
            this.data = (ArrayList) obj;
        }
        else if( obj instanceof Array){
            Array arr = (Array) obj;
            this.data = arr;
        }

    }
}
