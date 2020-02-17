package instagram.service.savepost;

import java.util.*;


public class SavedPostsContainer {
    private static Map<Long, List<Long>> savedPosts = new HashMap<>();

    public static void insert(Long userID, Long postID) {
        if (!savedPosts.containsKey(userID))
            savedPosts.put(userID, Collections.singletonList(postID));
        else
            savedPosts.get(userID).add(postID);
    }

    public static List<Long> getPostsByUserID(Long userID) {
        return savedPosts.get(userID);
    }
}
