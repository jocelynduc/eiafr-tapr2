public class OSXInfo {

    int maj = 0;
    int min = 0;
    int bug = 0;
    String ver = "";

    public OSXInfo(int maj, int min, int bug, String ver) {
        this.maj = maj;
        this.min = min;
        this.bug = bug;
        this.ver = ver;
    }

    @Override
    public String toString() {
        return "Mac OS X: " + this.maj + "." + this.min + "." + this.bug + "\n(Ver:" + ver + ")";
    }
}
