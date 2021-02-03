import DS.Stack;

public class Pole {
    private Stack<Ring> p;


    public Pole() {
        this.p = new Stack<>();
    }

    public void add(Ring r) {
        this.p.push(r);
    }

    public Ring remove() {
        return this.p.pop();
    }

    public boolean isEmpty() {
        return this.p.isEmpty();
    }

    public void sort() {
        Pole small = new Pole();
        Pole big = new Pole();

        while (!this.isEmpty()) {
            Ring r = this.remove();

            if (r.getSize().equals("S")) {
                small.add(r);
            } else {
                big.add(r);
            }
        }

        while (!(small.isEmpty() && big.isEmpty())) {
            if (big.isEmpty()) {
                this.add(small.remove());
            } else {
                this.add(big.remove());
            }
        }
    }

    public String toString() {
        String ret = "";
        Pole tmp = new Pole();

        while (!this.isEmpty()) {
            Ring r = this.remove();
            ret += r.toString() + "\n";
            tmp.add(r);
        }
        while (!tmp.isEmpty()) {
            this.add(tmp.remove());
        }

        return ret;
    }

    public static void main(String[] args) {
        Pole pp = new Pole();

        for (int i = 0; i < 20; i++) {
            String size = Math.random() < 0.5 ? "L" : "S";
            int color = (int)(Math.random() * 11);

            pp.add(new Ring(size, color));
        }

        System.out.println("Before sort:\n" + pp);
        pp.sort();
        System.out.println("After sort:\n" + pp);
    }
}