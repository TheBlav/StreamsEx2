import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatchStream {

    public static void main(String[] args) {
        //data array
        SoccerMatch[] matches = {
                new SoccerMatch("Poland", "Ireland", 4, 3),
                new SoccerMatch("Germany", "France", 3, 5),
                new SoccerMatch("Portugal", "Spain", 3, 2),
                new SoccerMatch("Netherlands", "Poland", 6, 4),
                new SoccerMatch("Germany", "Belgium", 2, 3)
        };
        System.out.println("All matches: ");
        String teamname = "Poland";
        //below creates list from stream data and in the meantime prints all matches.
        List<SoccerMatch> AllMatchesAndSpecifiedTeamMatches = getSoccerMatches(matches, teamname);
        //below creates set of all teams that took part in matches (unique names)
        HashSet<String> allNames = (HashSet<String>) getAllNames(matches);
        //below creates sum of all goal scored into Integer value.
        Integer sum = createSumOfGoals(matches);

        //print of all data for user
        printAllData(AllMatchesAndSpecifiedTeamMatches, allNames, sum, teamname);




    }

    private static void printAllData(List<SoccerMatch> allMatches, HashSet<String> allNames, Integer sum, String teamName) {
        System.out.println("\n Specific data:");
        System.out.println("All matches of Team: " + teamName +  "\n" + allMatches);
        System.out.println("Unique teams that took part in matches: " + allNames.size());
        System.out.println("All unique teams that took part in matches: \n" + allNames);
        System.out.println("Sum of all goals scored: " + sum);

    }

    private static Integer createSumOfGoals(SoccerMatch[] matches) {
        return Stream.of(matches)
                .flatMapToInt(soccerMatch -> IntStream.of
                        (soccerMatch.getHomeTeamScore()+soccerMatch.getGuestTeamScore()))
                .sum();
    }

    private static Set<String> getAllNames(SoccerMatch[] matches) {

        String[] guestNames = Stream.of(matches).map(SoccerMatch::getGuestTeamName).toArray(String[]::new);
        String[] homeNames = Stream.of(matches).map(SoccerMatch::getHomeTeamName).toArray(String[]::new);
        Set<String> collect = Stream.of(guestNames, homeNames)
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
        return collect;
    }

    private static List<SoccerMatch> getSoccerMatches(SoccerMatch[] matches, String teamname) {
        List<SoccerMatch> allMAtches = Stream.of(matches)
                .peek(System.out::println)
                .filter(s -> s.getHomeTeamName().equals(teamname) || s.getGuestTeamName().equals(teamname))
                .collect(Collectors.toList());
        return allMAtches;
    }


    private static int getScores(SoccerMatch match) {
        return match.getHomeTeamScore() + match.getGuestTeamScore();
    }
}
