package exam160917;

import java.util.*;

/**
 * 16/09/2017
 */
public class _03_BlackMessup {
    private static Map<String, Atom> atomsByName = new HashMap<>();
    private static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
//
//        3
//        1
//        Hydrogen 4 1
//        Argon 5 2
//        Iridium 7 1
//        Hydrogen Argon

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] atomArgs = sc.nextLine().split(" ");
            Atom atom = new Atom(atomArgs[0], Integer.parseInt(atomArgs[1]), Integer.parseInt(atomArgs[2]));
            graph.put(atom.name, new ArrayList<>());
            atomsByName.put(atomArgs[0], atom);
        }


        for (int i = 0; i < k; i++) {
            String[] edge = sc.nextLine().split(" ");

            String from = edge[0];
            String to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        List<SortedSet<Atom>> connectedComponents = getConnectedComponents();
        int maxMass = getMaxMass(connectedComponents);

        System.out.println(maxMass);
    }

    private static int getMaxMass(List<SortedSet<Atom>> connectedComponents) {
        int maxMass = 0;
        for (SortedSet<Atom> molecule : connectedComponents) {

            maxMass = Math.max(maxMass, getMass(molecule));
        }
        return maxMass;
    }

    private static int getMass(SortedSet<Atom> molecule) {
        int time = 1;
        int mass = 0;
        Set<String> taken = new HashSet<>();
        for (Atom atom : molecule) {
            if (time < atom.decay) {
                time = atom.decay;
                mass += atom.mass;
                taken.add(atom.name);
            } else if (time > taken.size()){
                //Todo maybe check decay
                mass += atom.mass;
                taken.add(atom.name);
            }
        }
        return mass;
    }

    private static List<SortedSet<Atom>> getConnectedComponents() {
        int id = 0;
        List<SortedSet<Atom>> connectedComponents = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String atom : graph.keySet()) {
            if (!visited.contains(atom)) {
                connectedComponents.add(new TreeSet<>());
                DFS(atom, visited, connectedComponents, id++);
            }
        }


        return connectedComponents;
    }

    private static void DFS(String atom, Set<String> visited, List<SortedSet<Atom>> connectedComponents, int id ) {

        visited.add(atom);
        if (id < connectedComponents.size())
        connectedComponents.get(id).add(atomsByName.get(atom));
        for (String child : graph.get(atom)) {
            if (!visited.contains(child)){
                DFS(child, visited, connectedComponents, id);
            }
        }

    }


    private static class Atom implements Comparable<Atom> {
        String name;
        int mass;
        int decay;

        public Atom(String name, int mass, int decay) {
            this.name = name;
            this.mass = mass;
            this.decay = decay;
        }


        @Override
        public int compareTo(Atom other) {
            return Integer.compare(this.mass, other.mass);
        }
    }
}
