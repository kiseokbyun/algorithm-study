package algorithmStudy.programmers.representedByN;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class RepresentedByN {
    public int solution(int N, int number) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        ArrayList<Integer> list6 = new ArrayList<Integer>();
        ArrayList<Integer> list7 = new ArrayList<Integer>();
        ArrayList<Integer> list8 = new ArrayList<Integer>();
        
        // 1
        list1.add(N);
        list2.add(Integer.parseInt(Integer.toString(N) + list1.get(0).toString()));
        list3.add(Integer.parseInt(Integer.toString(N) + list2.get(0).toString()));
        list4.add(Integer.parseInt(Integer.toString(N) + list3.get(0).toString()));
        list5.add(Integer.parseInt(Integer.toString(N) + list4.get(0).toString()));
        list6.add(Integer.parseInt(Integer.toString(N) + list5.get(0).toString()));
        list7.add(Integer.parseInt(Integer.toString(N) + list6.get(0).toString()));
        list8.add(Integer.parseInt(Integer.toString(N) + list7.get(0).toString()));
        if (N == number) {
            return 1;
        }
        
        // 2
        nextStep(list2, list1, list1);
        if (list2.contains(number)) {
            return 2;
        }
        
        // 3
        nextStep(list3, list2, list1);
        if (list3.contains(number)) {
            return 3;
        }
        
        // 4
        nextStep(list4, list3, list1);
        nextStep(list4, list2, list2);
        if (list4.contains(number)) {
            return 4;
        }
        
        // 5
        nextStep(list5, list4, list1);
        nextStep(list5, list3, list2);
        if (list5.contains(number)) {
            return 5;
        }
        
        // 6
        nextStep(list6, list5, list1);
        nextStep(list6, list4, list2);
        nextStep(list6, list3, list3);
        if (list6.contains(number)) {
            return 6;
        }
        
        // 7
        nextStep(list7, list6, list1);
        nextStep(list7, list5, list2);
        nextStep(list7, list4, list3);
        if (list7.contains(number)) {
            return 7;
        }
        
        // 8
        nextStep(list8, list7, list1);
        nextStep(list8, list6, list2);
        nextStep(list8, list5, list3);
        nextStep(list8, list4, list4);
        if (list8.contains(number)) {
            return 8;
        }
        
        return -1;
    }
    
    void print(ArrayList<Integer> list) {
        list.sort((Integer a, Integer b) -> {
            return a > b ? 1 : -1;
        });
        System.out.println(list);
    }
    
    public void nextStep(ArrayList<Integer> list, ArrayList<Integer> preList, ArrayList<Integer> preList2) {
        for (Integer num : preList) {
            for (Integer num2 : preList2) {
                insertList(list, num+num2);
                insertList(list, num*num2);
                
                insertList(list, num-num2);
                insertList(list, num2-num);
                
                if (num2 != 0) {
                    insertList(list, num/num2);
                }
                if (num != 0) {
                    insertList(list, num2/num);
                }
            }
        }
    }
    
    public void insertList(ArrayList<Integer> list, int item) {
        if (item >= 1 && item <=32000 && !list.contains(item)) {
            list.add(item);
        }
    }
    
    @Test
    public void test1() {
        int N = 5;
        int number = 12345;
        int result = solution(N, number);
        
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    public void test2() {
        int N = 2;
        int number = 11;
        int result = solution(N, number);
    
        assertThat(result).isEqualTo(3);
    }
}
