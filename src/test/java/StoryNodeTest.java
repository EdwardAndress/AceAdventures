import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoryNodeTest {

    String rootDescription = "You arrive bleary eyed on the coast of Ghzxadghy and begin to walk. After walking for a few hours, there is a choice to make. Will you %s or %s?";
    String leftChildDecision = "explore the dark cave";
    String leftChildDescription = "You are in a dark cave do you %s or %s?";
    String rightChildDecision = "continue the path, which leads into a forest";
    String rightChildDescription = "The forest path becomes overgrown and unclear do you %s or %s?";

    String storySegment = String.format(rootDescription, leftChildDecision, rightChildDecision);


    @Test public void testStoryNodeHasADescription() {
        StoryNode node = new StoryNode(rootDescription);
        node.leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.rightChild = new StoryNode(rightChildDecision, rightChildDecision);
        Assertions.assertEquals(rootDescription, node.description);
    }

    @Test public void testStoryNodeGeneratesStorySegment() {
        StoryNode node = new StoryNode(rootDescription);
        node.leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.rightChild = new StoryNode(rightChildDecision, rightChildDescription);
        Assertions.assertEquals(storySegment, node.getStorySegment());
    }

    @Test public void testStoryNodeCanHaveLeftChild() {
        StoryNode node = new StoryNode(rootDescription);
        StoryNode leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.leftChild = leftChild;
        Assertions.assertEquals(leftChild, node.leftChild);
    }

    @Test public void testStoryNodeCanHaveRightChild() {
        StoryNode node = new StoryNode(rootDescription);
        StoryNode rightChild = new StoryNode(rightChildDecision, rightChildDescription);
        node.rightChild = rightChild;
        Assertions.assertEquals(rightChild, node.rightChild);
    }

    @Test public void testStoryNodeMapsInputToLeftChild() {
        StoryNode node = new StoryNode(rootDescription);
        StoryNode rightChild = new StoryNode(rightChildDecision, rightChildDescription);
        node.rightChild = rightChild;
        StoryNode leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.leftChild = leftChild;
        StoryNode nextNode = node.chooseNextNode("explore");
        Assertions.assertEquals(leftChild, nextNode);
    }
//
    @Test public void testStoryNodeMapsInputToRightChild() {
        StoryNode node = new StoryNode(rootDescription);
        StoryNode rightChild = new StoryNode(rightChildDecision, rightChildDescription);
        node.rightChild = rightChild;
        StoryNode leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.leftChild = leftChild;
        StoryNode nextNode = node.chooseNextNode("continue");
        Assertions.assertEquals(rightChild, nextNode);
    }

    @Test public void testStoryNodeMapsBadInputToSelf() {
        StoryNode node = new StoryNode(rootDescription);
        StoryNode rightChild = new StoryNode(rightChildDecision, rightChildDescription);
        node.rightChild = rightChild;
        StoryNode leftChild = new StoryNode(leftChildDecision, leftChildDescription);
        node.leftChild = leftChild;
        StoryNode nextNode = node.chooseNextNode("asdasd");
        Assertions.assertEquals(node, nextNode);
    }
}
