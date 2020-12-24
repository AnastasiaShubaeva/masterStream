package academy.elqoo.java8.stream;

import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream().map(Math::sqrt).mapToInt(Double::intValue).boxed().collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
        return user.stream().mapToInt(i->i.getAge()).boxed().collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().mapToInt(i->i.getAge()).boxed().distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int) users.stream().filter(i -> i.getAge()>25).count();
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream().mapToInt(i->i).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream().mapToInt(i->i).skip(toSkip).boxed().collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream().map(i-> i.replaceAll(" (.*)", "")).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream().map(i->i.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users){
        return users.stream().map(i->i.getName()).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().mapToInt(i->i.getAge()).average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream().mapToInt(i->i.getAge()).max().getAsInt();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().mapToInt(i->i.getAge()).min().getAsInt();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream().mapToInt(i->i.getAge()).anyMatch(i-> i==age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream().mapToInt(i->i.getAge()).noneMatch(i-> i==age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream().filter(i-> i.getName()==name).findFirst();
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        return IntStream.rangeClosed(2, 50).filter(x -> isPrime(x)).boxed().limit(10).collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        Random random = new Random();
        IntStream intStream = random.ints();
        return intStream.boxed().limit(10).collect(Collectors.toList());
    }

    public static User findOldest(List<User> users){
        return users.stream().filter(i->i.getAge()==getMaxAge(users)).findFirst().get();
    }

    public static int sumAge(List<User> users){
        return users.stream().mapToInt(i->i.getAge()).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream().mapToInt(i->i.getAge()).summaryStatistics();
    }

}
