package functionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalProgramming01 {

	private static List<Integer> numList = Arrays.asList(10,9,5,2,3,7,6,1);
	private static List<String> crsList = Arrays.asList("Spring","AWS","Azure","Microservices","Spring Boot","API");
	private static List<String> crsList2 = Arrays.asList("Docker","Java","Drupal","Kubernetes","PCF","API");
	private static Comparator<String> reverseCompare = Comparator.comparing(String::length).reversed();
	
	private static double getSquareSum() {
	  return numList.stream()
		.map(x->x*x)  // map will first map each individual values to another value
		.reduce(0, (x,y) -> x+y); // reduce further reduces all the values in list to a single value.
	  //but takes only 2 at a time. so to get the sum, we first send 0 and the number itself. //x->0 and y->num
	}
	
	private static int getOddSum() {
		return numList.stream()
		.filter(x->x%2!=0)
		.reduce(0, Integer::sum);
	}
	
	private static void compareListItems() {
		crsList.stream()
		.sorted(Comparator.comparing(str->str.length()))
		.forEach(System.out::println);
	}
	
	private static void evenNumList() {
		numList.stream()
		.filter(x->x%2==0)  //returns Stream<T>
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	private static void crsListLength() {
		crsList.stream()
		.map(str->str.length())  //returns Stream<T>
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	//other ways of using Streams
	private static void createStreamUsingOthrWys() {
		System.out.println("--------------------------------::createStreamUsingOthrWys()::-----------");
		System.out.println(
				IntStream.iterate(2, e->e+2)
				.limit(10)
				.peek(System.out::println)
				.sum());
	}
	
	private static void calculateCourseLength() {
		crsList.stream()
				.map(str->str.replaceAll(" ", ""))
				.mapToInt(str->str.length())
				.forEach(System.out::println);
	}
	
	private static void printCrsInReverseOrder() {
		crsList.stream()
		.sorted(reverseCompare)
		.forEach(System.out::println);;
	}
	
	private static void createStringJoiningCrs() {
		System.out.println(crsList.stream()
				.collect(Collectors.joining(",")));
		
		//System.out.println(crsList.stream()
		//		.flatMap(crs-> Stream.of(crs+","))
		//		.reduce("", (a,b)->a+b));
		//result-> Spring,AWS,Azure,Microservices,Spring Boot,
		System.out.println(crsList.stream()
				.flatMap(crs->Stream.of(crs.split(""))) 
				.collect(Collectors.toList())
				);
		//[S, p, r, i, n, g, A, W, S, A, z, u, r, e, M, i, c, r, o, s, e, r, v, i, c, e, s, S, p, r, i, n, g,  , B, o, o, t]
		
		//get courses with same number of characters using 2 list
		System.out.println("--------------------------------");
		System.out.println(crsList.stream()
				.flatMap(crs-> crsList2.stream()
				.filter(crs2->crs.length()==crs2.length())
				.map(crs2->Arrays.asList(crs,crs2)))
				.filter(crs->!crs.get(0).equals(crs.get(1)))
				.collect(Collectors.toList()));
		//get courses with same number of characters using 1 list
		System.out.println("--------------------------------");
		System.out.println(
				crsList.stream()
				.collect(Collectors.groupingBy(String::length))
				);
		//get courses of length==3
				System.out.println(
						crsList.stream()
						.filter(crs->crs.length()==3)
						.collect(Collectors.toList())
						);
	}
	
	public static void main(String[] args) {
		System.out.println(getSquareSum());
		System.out.println(getOddSum());
		compareListItems();
		System.out.println();
		evenNumList();
		System.out.println();
		crsListLength();
		System.out.println();
		createStreamUsingOthrWys();
		System.out.println();
		calculateCourseLength();
		System.out.println();
		printCrsInReverseOrder();
		System.out.println();
		createStringJoiningCrs();
		Runnable runnable = () -> {
			IntStream.range(1, 10).forEach(
					i->System.out.println(Thread.currentThread().getId()+":"+i)
					);
		};
		
		String url= "abd=kjuy&def=lkjy&jht=ujih";
		for(String urlPart: url.split("&")) {
			System.out.println(urlPart);
		}
	}
}
