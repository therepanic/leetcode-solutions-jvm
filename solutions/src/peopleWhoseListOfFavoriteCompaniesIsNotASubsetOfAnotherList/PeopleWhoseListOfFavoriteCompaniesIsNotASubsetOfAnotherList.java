package peopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList;

import java.util.*;

public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        var sets = favoriteCompanies.stream().map(HashSet::new).toList();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = false;

            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (sets.get(j).containsAll(sets.get(i))) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                ans.add(i);
            }
        }
        return ans;
    }
}
