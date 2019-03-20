public class DziennikNiwelacyjny {
    private int id;
    private String name;
    private float distance;
    private float measure1;
    private float measure2;
    private float height1;
    private float height2;
    private float heightAverage;

    public DziennikNiwelacyjny() {
    }

    private boolean pass = false;
    private boolean middle = false;

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isMiddle() {
        return middle;
    }

    public void setMiddle(boolean middle) {
        this.middle = middle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getMeasure1() {
        return measure1;
    }

    public void setMeasure1(float measure1) {
        this.measure1 = measure1;
    }

    public float getMeasure2() {
        return measure2;
    }

    public void setMeasure2(float measure2) {
        this.measure2 = measure2;
    }

    public float getHeight1() {
        return height1;
    }

    public void setHight1(float height1) {
        this.height1 = height1;
    }

    public float getHeight2() {
        return height2;
    }

    public void setHight2(float height2) {
        this.height2 = height2;
    }

    public float getheightAverage() {
        return heightAverage;
    }

    public void setheightAverage(float heightAverage) {
        this.heightAverage = heightAverage;
    }

    public String toString() {
        String sort = "";
        if (pass) {
            sort = "4=" + measure1 + "\n5=" + measure2 + "\n7=" + heightAverage + "\n";

        } else if (middle) {
            sort = "6=" + measure1 + "\n7=" + heightAverage + "\n8=" + measure2 + "\n";
        }


        return "[" + id + "]\n1=" + name + "\n3=" + distance + "\n" + sort;
    }
}
