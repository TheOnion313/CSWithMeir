import DS.Queue;

public class SetPoint4D {
    private Queue<Point4D> q; // Queue<Point4D> used to implement set

    public SetPoint4D() { // regular constructor, initiates empty queue
        this.q = new Queue<>();
    }

    public SetPoint4D(Queue<Point4D> q) { // iterates with null pointer over Q, inserts into our q meanwhile
        q.insert(null);
        while (q.head() != null) {
            this.add(q.head());
        }
        q.remove();
    }

    public boolean isIn(Point4D val) { // iterates over our Q with null pointer, if one of the arguments are equal returns true
        this.q.insert(null);
        boolean there = false;

        while (this.q.head() != null) {
            Point4D temp = this.q.remove(); // temporary for check
            if (val.equals(temp)) there = true; // checks if val searched is equal to current
            q.insert(temp); //back of the queue
        }
        q.remove(); // remove null

        return there;
    }

    public void add(Point4D val) { // inserts to q if not already existent, uses isIn
        if (!this.isIn(val)) this.q.insert(val);
    }

    public void delete(Point4D val) { // iterates over out q, if found val searched, it removes it from the queue, otherwise back of the queue
        this.q.insert(null); //null pointer
        while (this.q.head() != null) {
            if (this.q.head().equals(val)) { // if value wanted
                this.q.remove(); // delete from set
            }
            this.q.insert(new Point4D(this.q.remove())); // else back of the line
            //this doesnt need an else statement since argument will only apear once, so just goes over the next one
        }
        q.remove(); // remove null
    }

    public Queue<Point4D> getQ() { // get copy of our q
        Queue<Point4D> ret = new Queue<>(); // makes new empty q

        this.q.insert(null); //null pointer

        while (this.q.head() != null) {
            ret.insert(new Point4D(this.q.head())); // insert to new q
            this.q.insert(this.q.remove()); // back of the queue
        }
        this.q.remove(); // remove null

        return ret;
    }

    public SetPoint4D union(SetPoint4D s) { // returns the union of two sets
        SetPoint4D ret = new SetPoint4D(this.q); // return set, contains all the arguments of this set

        Queue<Point4D> tmp = s.getQ(); // gets arguments of other set
        tmp.insert(null); // null pointer

        while (!tmp.isEmpty()) { // for each argument in Set s, add to return set, if already there will not add, therefore union
            ret.add(new Point4D(tmp.head()));
        }

        return ret;
    }



    public boolean equals(SetPoint4D s) { // checks if two sets are equal


        Queue<Point4D> q1 = s.getQ(); // all arguments in s
        Queue<Point4D> q2 = this.getQ(); // all our arguments

        while (!q1.isEmpty()) { // checks all arguments in s are also in out set
            if (!this.isIn(q1.head())) {
                return false;
            }

            q1.remove();
        }

        q1 = s.getQ();

        while (!q2.isEmpty()) { // checks all arguments in our set is also in s
            if (!this.isIn(q1.head())) {
                return false;
            }

            q2.remove();
        }
        //both are contained within each other therefore they are equal

        return true;

    }

    @Override
    public String toString() { // toString according to java convention
        return "SetPoint4D{" +
                "q=" + q.toString() +
                '}';
    }
}
