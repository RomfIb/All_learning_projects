public enum EnumWithValue {
    MAN(100),
    WOMAN(110),
    CHILD(50);
    private final int height;

    EnumWithValue(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int calculateWeight(int heightOfPerson) {
        return heightOfPerson - height;
    }
}
