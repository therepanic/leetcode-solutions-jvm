package serializeAndDeserializeBST;

import structures.treeNode.TreeNode;

public class SerializeAndDeserializeBST {
    public static String serialize(TreeNode root) {
        StringBuilder dataBuilder = new StringBuilder();

        serializer(root, dataBuilder);

        return dataBuilder.toString();
    }

    public static void serializer(TreeNode root, StringBuilder dataBuilder) {
        if (root == null) {
            dataBuilder.append("@,");
            return;
        } else {
            dataBuilder.append(root.val).append(",");
        }

        serializer(root.left, dataBuilder);
        serializer(root.right, dataBuilder);
    }

    public static TreeNode deserialize(String data) {
        if (data.length() <= 1 || data.equals("@,")) {
            return null;
        }

        StringBuilder dataBuilder = new StringBuilder(data);
        TreeNode root = new TreeNode();

        deserialize(dataBuilder, root);

        return root;
    }

    public static void deserialize(StringBuilder dataBuilder, TreeNode root) {
        int commaIndex = -1;

        for (int i = 0 ; i < dataBuilder.length(); i++) {
            if (dataBuilder.charAt(i) == ',') {
                commaIndex = i;
                break;
            }
        }

        String valueString = dataBuilder.substring(0, commaIndex);

        root.val = Integer.parseInt(valueString);

        dataBuilder.delete(0, commaIndex + 1);

        if (dataBuilder.charAt(0) != '@') {
            root.left = new TreeNode();

            deserialize(dataBuilder, root.left);
        } else {
            for (int i = 0 ; i < dataBuilder.length(); i++) {
                if (dataBuilder.charAt(i) == ',') {
                    commaIndex = i;
                    break;
                }
            }

            dataBuilder.delete(0, commaIndex + 1);
        }

        if (dataBuilder.charAt(0) != '@') {
            root.right = new TreeNode();

            deserialize(dataBuilder, root.right);
        } else {
            for (int i = 0 ; i < dataBuilder.length(); i++) {
                if (dataBuilder.charAt(i) == ',') {
                    commaIndex = i;
                    break;
                }
            }

            dataBuilder.delete(0, commaIndex + 1);
        }
    }
}
