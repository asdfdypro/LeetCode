package asdf.test;


import java.util.*;

/**
 * (重排飞机票)
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * <p>
 * Example 1:
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * <p>
 * Example 2:
 * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class Solution {

    public final static String BEGIN = "JFK";

    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        List<String> ticketList;
        for (String[] ticket : tickets) {
            ticketList = graph.get(ticket[0]);
            if (ticketList == null) {
                ticketList = new ArrayList<>();
                graph.put(ticket[0], ticketList);
            }
            ticketList.add(ticket[1]);
        }
        for (List<String> ticketL : graph.values()) {
            Collections.sort(ticketL);
        }

        visit(res, graph, BEGIN);
        return res;
    }

    private void visit(List<String> res, Map<String, List<String>> graph, String airport) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty())
            visit(res, graph, graph.get(airport).remove(0));
        res.add(0, airport);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}).toArray()));
        System.out.println(Arrays.toString(solution.findItinerary(new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}}).toArray()));
        System.out.println(Arrays.toString(solution.findItinerary(new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}}).toArray()));
    }
}

