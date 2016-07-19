package asdf.test;

import java.util.*;

/**
 * (最小高度树)
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 */
public class Solution4 {
    //每次删除叶子节点剩余的为所求节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i,new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> keyList=new ArrayList<>();
        while(graph.keySet().size()>2){
            for(Integer key: graph.keySet()) {
                if (graph.get(key).size() == 1) {//必须异步删除
                    keyList.add(key);
                }
            }
            //异步删除
            for(Integer key:keyList) {
                for (Integer v:graph.get(key)){
                    graph.get(v).remove(key);
                }
                graph.remove(key);
            }

            keyList.clear();
        }
        for (Integer key:graph.keySet()){
            res.add(key);
        }

        return res;
    }




    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(Arrays.toString(
                solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}).toArray()));
        System.out.println(Arrays.toString(
                solution.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}).toArray()));
        System.out.println(Arrays.toString(
                solution.findMinHeightTrees(420, new int[][]{{0,1},{1,2},{0,3},{0,4},{3,5},{4,6},{0,7},{4,8},{1,9},{6,10},{3,11},{0,12},{5,13},{8,14},{5,15},{7,16},{4,17},{0,18},{15,19},{8,20},{11,21},{16,22},{0,23},{13,24},{12,25},{3,26},{21,27},{1,28},{17,29},{3,30},{29,31},{15,32},{1,33},{0,34},{34,35},{19,36},{23,37},{4,38},{15,39},{16,40},{35,41},{27,42},{40,43},{35,44},{3,45},{30,46},{33,47},{16,48},{36,49},{42,50},{31,51},{25,52},{6,53},{52,54},{33,55},{17,56},{45,57},{19,58},{9,59},{37,60},{42,61},{36,62},{28,63},{1,64},{1,65},{60,66},{26,67},{23,68},{45,69},{27,70},{2,71},{7,72},{63,73},{37,74},{15,75},{36,76},{12,77},{48,78},{71,79},{53,80},{23,81},{5,82},{15,83},{33,84},{61,85},{9,86},{54,87},{1,88},{77,89},{76,90},{8,91},{27,92},{71,93},{87,94},{71,95},{66,96},{90,97},{25,98},{41,99},{31,100},{31,101},{30,102},{19,103},{46,104},{51,105},{42,106},{66,107},{97,108},{107,109},{106,110},{46,111},{5,112},{58,113},{40,114},{106,115},{103,116},{116,117},{22,118},{57,119},{10,120},{98,121},{34,122},{11,123},{89,124},{120,125},{114,126},{75,127},{126,128},{33,129},{40,130},{125,131},{96,132},{46,133},{130,134},{64,135},{22,136},{47,137},{61,138},{105,139},{44,140},{106,141},{83,142},{121,143},{68,144},{118,145},{139,146},{68,147},{84,148},{63,149},{1,150},{140,151},{40,152},{95,153},{10,154},{144,155},{66,156},{39,157},{71,158},{64,159},{94,160},{133,161},{66,162},{6,163},{65,164},{89,165},{156,166},{156,167},{126,168},{82,169},{58,170},{115,171},{80,172},{65,173},{63,174},{38,175},{168,176},{30,177},{34,178},{2,179},{22,180},{57,181},{93,182},{122,183},{38,184},{113,185},{59,186},{112,187},{2,188},{72,189},{140,190},{99,191},{15,192},{180,193},{176,194},{52,195},{18,196},{135,197},{26,198},{182,199},{160,200},{64,201},{76,202},{71,203},{137,204},{125,205},{161,206},{206,207},{50,208},{171,209},{98,210},{193,211},{162,212},{207,213},{63,214},{138,215},{129,216},{205,217},{60,218},{218,219},{189,220},{167,221},{168,222},{188,223},{81,224},{209,225},{117,226},{216,227},{79,228},{195,229},{127,230},{143,231},{153,232},{69,233},{110,234},{126,235},{136,236},{184,237},{156,238},{226,239},{233,240},{3,241},{1,242},{140,243},{129,244},{189,245},{186,246},{77,247},{245,248},{111,249},{156,250},{133,251},{135,252},{198,253},{165,254},{98,255},{191,256},{119,257},{37,258},{202,259},{8,260},{69,261},{31,262},{171,263},{100,264},{174,265},{216,266},{58,267},{255,268},{21,269},{108,270},{211,271},{31,272},{259,273},{20,274},{241,275},{38,276},{230,277},{115,278},{195,279},{245,280},{177,281},{183,282},{275,283},{85,284},{52,285},{236,286},{76,287},{218,288},{283,289},{259,290},{46,291},{193,292},{213,293},{164,294},{97,295},{46,296},{94,297},{151,298},{216,299},{68,300},{298,301},{118,302},{273,303},{249,304},{279,305},{274,306},{277,307},{65,308},{71,309},{206,310},{219,311},{14,312},{225,313},{225,314},{94,315},{141,316},{174,317},{216,318},{129,319},{266,320},{139,321},{223,322},{317,323},{283,324},{137,325},{168,326},{319,327},{3,328},{101,329},{24,330},{323,331},{241,332},{115,333},{158,334},{229,335},{203,336},{192,337},{291,338},{186,339},{206,340},{211,341},{324,342},{18,343},{196,344},{62,345},{97,346},{93,347},{293,348},{13,349},{274,350},{292,351},{154,352},{27,353},{61,354},{259,355},{129,356},{292,357},{17,358},{341,359},{166,360},{209,361},{301,362},{248,363},{232,364},{49,365},{188,366},{61,367},{56,368},{34,369},{359,370},{345,371},{125,372},{225,373},{222,374},{362,375},{2,376},{86,377},{46,378},{135,379},{124,380},{8,381},{279,382},{181,383},{193,384},{351,385},{280,386},{344,387},{331,388},{146,389},{74,390},{67,391},{132,392},{48,393},{234,394},{281,395},{96,396},{217,397},{13,398},{286,399},{197,400},{255,401},{319,402},{175,403},{203,404},{115,405},{63,406},{177,407},{53,408},{383,409},{115,410},{348,411},{274,412},{251,413},{77,414},{159,415},{209,416},{148,417},{84,418},{129,419}}).toArray()));


    }
}