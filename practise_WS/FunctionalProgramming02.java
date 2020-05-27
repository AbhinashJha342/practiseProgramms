package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgramming02 {
	
	private static List<Integer> numList = Arrays.asList(10,9,5,2,3,7,6,1);
	private static List<String> crsList = Arrays.asList("Spring","AWS","Azure","Microservices");
	
	private static Integer getSumWithFuncInterface() {
		Predicate<Integer> evenPredicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				
				return (x%2==0);
			}
			
			
		};
		BinaryOperator<Integer> sumAccumulator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
			
		};
		return calculateFilteredSum(evenPredicate, sumAccumulator);
	}
	
	private static void getSumWithMthdBehvr() {
		System.out.println(calculateFilteredSum(x->x%2==0, (x,y)->x+y));
		System.out.println(calculateFilteredSum(x->x%2!=0, (x,y)->x+y));
	}

	/**
	 * @param predicate
	 * @param sumAccumulator
	 * @return the result based on the binaryOperator behavior passed and the predicate condition
	 */
	private static Integer calculateFilteredSum(Predicate<Integer> predicate, BinaryOperator<Integer> sumAccumulator) {
		return numList.stream()
		.filter(predicate)
		.reduce(0, sumAccumulator);
	}
	
	private static void crsListLength() {
		collectFilteredList(str->str.length()); //here we are passing the method behavior as an argument.
	}

	private static void collectFilteredList(Function<String, Integer> mapper) {
		crsList.stream()
		.map(mapper)
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	private static void testStream() {
		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
		stream.limit(2).map(x -> x + "2").forEach(System.out::println);
		System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> x+"").collect(Collectors.joining()));
	}
	
	public static void main(String[] args) {
		System.out.println(getSumWithFuncInterface());
		getSumWithMthdBehvr();
		crsListLength();
		Supplier<Boolean> supplier = () -> {
			boolean flag = true;
			for(Integer num : numList) {
				if(num%2!=0) {
					flag = false;
				}
			}
			return flag;
		};
		System.out.println("the list contains only even numbers: "+supplier.get());
		testStream();
	}

}
