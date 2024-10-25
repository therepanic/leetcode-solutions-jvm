package removeSubFoldersFromTheFilesystem;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> answer = new ArrayList<>();
        Set<String> folderSet = new HashSet<>();

        loop1: for (String f : folder) {
            String[] split = f.split("\\/");

            StringBuilder d = new StringBuilder();
            for (String v : split) {
                d.append("/").append(v);
                if (folderSet.contains(d.toString())) {
                    continue loop1;
                }
            }
            answer.add(d.toString());
            folderSet.add(d.toString());
        }
        return answer;
    }
}
