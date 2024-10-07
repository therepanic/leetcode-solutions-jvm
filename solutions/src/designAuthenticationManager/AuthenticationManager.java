package designAuthenticationManager;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private final Map<String, Integer> map = new HashMap<>();
    private final int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        } else if (map.containsKey(tokenId) && map.get(tokenId) <= currentTime) {
            map.remove(tokenId);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;

        for (int value : map.values()) {
            if (value > currentTime) count++;
        }

        return count;
    }
}
