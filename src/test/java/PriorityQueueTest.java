import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ConcurrentModificationException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
            return Stream.of(
                    Arguments.of(new int[]{5,4,3,2,1},new int[]{1,2,3,4,5}),
                    Arguments.of(new int[]{0,-4,9,-2,1},new int[]{-4,-2,0,1,9}),
                    Arguments.of(new int[]{2,-3,4,7,1},new int[]{-3,1,2,4,7}),
                    Arguments.of(new int[]{1,2,-3,-7,0},new int[]{-7,-3,0,1,2}),
                    Arguments.of(new int[]{5,-5,-3,3,0},new int[]{-5,-3,0,3,5}));
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        //TODO: random_array add to PriorityQueue;
        for(int i = 0 ; i < random_array.length ;i++){
            test.add(random_array[i]);
        }
        System.out.println(test);
        //TODO: get PriorityQ
        for(int i = 0 ; i < random_array.length ;i++){
            result[i] = test.poll();
        }
        assertArrayEquals(correct_array,result);
    }
    //TODO: 3 unique Exceptions;

    @Test
    public void whenExceptionThrown_thenOfferisNull(){
        Exception test = assertThrows(NullPointerException.class,()->{
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.offer(null);
        });
    }
    @Test
    public void whenExceptionThrown_thenInitialCapacityNotGreaterThanOne(){
        Exception test = assertThrows(IllegalArgumentException.class,()->{
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(0);
        });
    }
    @Test
    public void whenExceptionThrown_thenaddisNull(){
        Exception test = assertThrows(NullPointerException.class,()->{
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.add(null);
        });
    }

}