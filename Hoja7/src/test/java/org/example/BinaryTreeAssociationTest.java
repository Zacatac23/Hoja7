package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeAssociationTest {

    @Test
    public void testBinaryTreeInsert() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        assertNotNull(tree.find(5));
        assertNotNull(tree.find(3));
        assertNotNull(tree.find(7));
        assertNotNull(tree.find(1));
        assertNotNull(tree.find(4));

        assertNull(tree.find(2));
    }

    @Test
    public void testAssociationCreation() {
        Association<String, Integer> association = new Association<>("apple", 5);

        assertEquals("apple", association.getKey());
        assertEquals(5, association.getValue());
    }
}

