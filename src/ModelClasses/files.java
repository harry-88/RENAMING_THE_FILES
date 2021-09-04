package ModelClasses;

public class files {
    String previousName;
    String newName;

    public files(String previousName, String newName) {
        this.previousName = previousName;
        this.newName = newName;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public String toString() {
        return "files{" +
                "previousName='" + previousName + '\'' +
                ", newName='" + newName + '\'' +
                '}';
    }
}
