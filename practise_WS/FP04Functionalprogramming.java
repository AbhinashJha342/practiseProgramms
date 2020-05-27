package functionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class DemoCourse {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public DemoCourse(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class FP04Functionalprogramming {

	public static void main(String[] args) {
		List<DemoCourse> courses = Arrays.asList(new DemoCourse("Spring", "Framework", 98, 20000),
				new DemoCourse("Spring Boot", "Framework", 95, 18000), new DemoCourse("API", "Microservices", 97, 22000),
				new DemoCourse("Microservices", "Microservices", 96, 25000),
				new DemoCourse("FullStack", "FullStack", 91, 14000), new DemoCourse("AWS", "Cloud", 92, 21000),
				new DemoCourse("Azure", "Cloud", 99, 21000), new DemoCourse("Docker", "Cloud", 92, 20000),
				new DemoCourse("Kubernetes", "Cloud", 91, 20000));
		
		//allMatch to see if the values have score greater than 90
		boolean isReviewScorePredicate = courses.stream().allMatch(course -> course.getReviewScore()>75);
		boolean isReviewScoreDistinctionPredicate = courses.stream().noneMatch(course -> course.getReviewScore()>90);
		boolean isReviewScoreAnyMatchPredicate = courses.stream().anyMatch(course -> course.getReviewScore()>95);
		boolean isStrengthFullPredicate = courses.stream().anyMatch(course -> course.getNoOfStudents()>20000);
		boolean isStrengthBelowReqPredicate = courses.stream().anyMatch(course -> course.getNoOfStudents()>20000);
		Predicate<DemoCourse> predicatelessThan90 = course->course.getReviewScore()<90;
		Predicate<DemoCourse> predicategreaterThan95 = course->course.getReviewScore()>95;
		//Function<Integer, Integer> sum = ()
		
		System.out.println(isReviewScorePredicate);
		System.out.println(isReviewScoreDistinctionPredicate);
		System.out.println(isReviewScoreAnyMatchPredicate);
		
		System.out.println(isStrengthFullPredicate);
		System.out.println(isStrengthBelowReqPredicate);
		
		Comparator<DemoCourse> comparingCourseByStrength = 
				Comparator.comparing(DemoCourse::getNoOfStudents).
					reversed();
		Comparator<DemoCourse> comparingCourseByMarks = 
				Comparator.comparing(DemoCourse::getReviewScore).
					reversed();
		Comparator<DemoCourse> compareWithoutConflicts = 
				Comparator.comparing(DemoCourse::getNoOfStudents).
					thenComparing(DemoCourse::getReviewScore); 
		//this can help to resolve conflicts of one of the conditions have the same value
		
		//sort the courses based on some criteria
		System.out.println(courses.stream().sorted(comparingCourseByStrength).collect(Collectors.toList()));
		System.out.println(courses.stream().sorted(comparingCourseByMarks).collect(Collectors.toList()));
		System.out.println(courses.stream().sorted(compareWithoutConflicts).collect(Collectors.toList()));
		System.out.println(courses.stream().limit(3).collect(Collectors.toList()));
		System.out.println(courses.stream().skip(3).collect(Collectors.toList()));
		
		//System.out.println(courses.stream().);
		System.out.println(courses.stream().max(comparingCourseByStrength)); // max returns the last element after the predicate is run.
		//Optional[FullStack:14000:91]
		//Optional is when the value can be any value or no value
		
		System.out.println(courses.stream().filter(predicatelessThan90).min(comparingCourseByMarks));
		//Optional.empty
		System.out.println(courses.stream().filter(predicatelessThan90)
				.min(comparingCourseByMarks)
				.orElseGet(()-> new DemoCourse("MS Word", "misc", 87, 14000)));
		//orElse and other methods are used to return a default value.
		
		System.out.println(courses.stream().sorted(comparingCourseByStrength).findFirst());
		System.out.println(courses.stream().filter(predicategreaterThan95).findAny());
		
		//getting only the total number of students present in defined courses
		System.out.println(courses.stream()
				.filter(predicategreaterThan95)
				.mapToInt(DemoCourse::getNoOfStudents)
				.reduce(0, Integer::sum)
				);
		
		//getting average of no of students
		System.out.println(courses.stream()
				.filter(predicategreaterThan95)
				.mapToInt(DemoCourse::getNoOfStudents)
				.average()
				);
		
		//no of courses qualified for criteria
		System.out.println(courses.stream()
				.filter(predicategreaterThan95)
				.mapToInt(DemoCourse::getNoOfStudents)
				.count()
				);
		
		//course with highest noOFstudent
		System.out.println(courses.stream()
				.sorted(comparingCourseByStrength)
				.findFirst()
				.map(course -> course.getName())
				);
		
		//course name with highest marks
		System.out.println(courses.stream()
				.sorted(comparingCourseByStrength)
				.findFirst()
				.map(course -> course.getName()+" "+course.getReviewScore())
				);
		
		//grouping the courses
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(DemoCourse::getCategory))
				);
		//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
		//FullStack=[FullStack:14000:91], 
		//Microservices=[API:22000:97, Microservices:25000:96], 
		//Framework=[Spring:20000:98, Spring Boot:18000:95]}
		
		//grouping 1. by course type, 2.by noOfStudents
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(DemoCourse::getCategory, 
						Collectors.groupingBy(DemoCourse::getNoOfStudents))));
		//{Cloud={20000=[Docker:20000:92, Kubernetes:20000:91], 21000=[AWS:21000:92, Azure:21000:99]},
		//FullStack={14000=[FullStack:14000:91]}, 
		//Microservices={22000=[API:22000:97], 25000=[Microservices:25000:96]}, 
		//Framework={18000=[Spring Boot:18000:95], 20000=[Spring:20000:98]}}
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(DemoCourse::getCategory,
						Collectors.counting()))
				);
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(DemoCourse::getCategory, 
						Collectors.mapping(DemoCourse::getName, Collectors.toList())))
				);
		//{Cloud=[AWS, Azure, Docker, Kubernetes], 
		//FullStack=[FullStack], 
		//Microservices=[API, Microservices], 
		//Framework=[Spring, Spring Boot]}
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(DemoCourse::getCategory, 
						Collectors.maxBy(comparingCourseByStrength)))
				);
	}
	
}
