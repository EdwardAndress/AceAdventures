public class StoryNode {

    public String decision;
    public String description;
    public StoryNode leftChild;
    public StoryNode rightChild;
    public StoryNode(String description) {
        this.description = description;
    }

    public StoryNode(String decision, String description) {
        this.decision = decision;
        this.description = description;
    }

    public String getStorySegment() {
        return String.format(this.description, this.leftChild.decision, this.rightChild.decision);
    }

    public StoryNode chooseNextNode(String input) {
        if(this.leftChild.decision.contains(input)) {
            return this.leftChild;
        } else if(this.rightChild.decision.contains(input)) {
            return this.rightChild;
        } else {
            return this;
        }
    }
}
