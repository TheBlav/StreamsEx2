import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchStream {

    public static void main(String[] args) {
        SoccerMatch[] matches = {
                new SoccerMatch("Poland", "Ireland", 4, 3),
                new SoccerMatch("Germany", "France", 3, 5),
                new SoccerMatch("Portugal", "Spain", 3, 2),
                new SoccerMatch("Netherlands", "Poland", 6, 4),
                new SoccerMatch("Germany", "Belgium", 2, 3)
        };
        String teamname = "Poland";
        List<SoccerMatch> allMatches = getSoccerMatches(matches, teamname);
        HashSet<String> allNames = (HashSet<String>) getAllNames(matches);

        System.out.println(allMatches.toString());
        System.out.println(allNames.size());
        System.out.println("\n" + allNames);


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


}
