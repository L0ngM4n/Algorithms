package exam160917;

import java.util.*;

/**
 * 16/09/2017
 */
public class _03_BlackMessup {

    public static void main(String[] args) {
//
//        3
//        1
//        Hydrogen 4 1
//        Argon 5 2
//        Iridium 7 1
//        Hydrogen Argon
        Map<String, Atom> atomsByName = new HashMap<>();
        Map<Atom, List<Atom>> graph = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] atomArgs = sc.nextLine().split(" ");
            Atom atom = new Atom(atomArgs[0], Integer.parseInt(atomArgs[1]), Integer.parseInt(atomArgs[2]));
            graph.put(atom, new ArrayList<>());
            atomsByName.put(atomArgs[0], atom);
        }


        for (int i = 0; i < k; i++) {
            String[] edge = sc.nextLine().split(" ");

            Atom from = atomsByName.get(edge[0]);
            Atom to = atomsByName.get(edge[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }


        System.out.println();
    }


    private static class Atom {
        String name;
        int mass;
        int decay;

        public Atom(String name, int mass, int decay) {
            this.name = name;
            this.mass = mass;
            this.decay = decay;
        }
    }
}
