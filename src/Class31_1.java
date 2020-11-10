import DS.Queue;

public class Class31_1 {

    public static SetPoint4D intersection(SetPoint4D s, SetPoint4D s1) { // returns all arguments in both queues
        SetPoint4D ret = new SetPoint4D(); // return set

        Queue<Point4D> tmp = s1.getQ(); // q containing all arguments of our set

        while (!tmp.isEmpty()) { // goes over our arguments
            if (s.isIn(tmp.head())) { // if argument is in s, therefore it is in  both and will be included in the intersection
                ret.add(new Point4D(tmp.head())); // add to set
            }
            tmp.remove(); // remove null
        }

        return ret;
    }

    public static boolean isAInB(SetPoint4D a, SetPoint4D b) {
        return intersection(a, b).equals(a);
    }

    public static void main(String[] args) {
        SetPoint4D set1 = new SetPoint4D(); // make new Set

        //add a bunch of Points
        set1.add(new Point4D(1, 1, 1, 1));
        set1.add(new Point4D(1, 1, 1, 2));
        set1.add(new Point4D(1, 1, 2, 1));
        set1.add(new Point4D(1, 1, 2, 1)); // duplicate point, checks it doesnt add it twice

        System.out.println("Initial set: " + set1.toString()); // print to check all arguments are there


        set1.delete(new Point4D(1, 1, 1, 2)); // delete existing argument
        set1.delete(new Point4D(2, 1, 1, 2)); // delete non-existing argument, to check if it doesnt crash

        System.out.println("Removed some: " + set1.toString()); // see argument was in fact deleted


        System.out.println("This is in the set: " + set1.isIn(new Point4D(1, 1, 2, 1))); // check the isIn method
        System.out.println("This was never in the set: " + set1.isIn(new Point4D(3, 1, 2, 1))); // for true and false
        System.out.println("This just got deleted: " + set1.isIn(new Point4D(1, 1, 1, 2))); // also when an argument was deleted, just to make sure ;)

        SetPoint4D set2 = new SetPoint4D(); // another set
        set2.add(new Point4D(1, 1, 1, 1)); // contained withing set1

        System.out.println("A indeed is in B: " + isAInB(set2, set1)); // check isAInB func
        System.out.println("They only intersect on one Point: " + intersection(set1, set2)); // check intersection func
        set2.add(new Point4D(3, 3, 3, 3)); // add new point not in set1 by that set2 is no longer contained
        System.out.println("No longer true: " + isAInB(set2, set1)); // should return false
    }
}
