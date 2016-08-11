package asdf.test;

import java.util.*;

/**
 * (设计Twittwe)
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * <p>
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {
    private final  static int NewsCount=10;
    private final  static Comparator<? super int[]> compareByTime=new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[1]-o1[1];
        }
    };

    private int count;
    private Map<Integer, Map<Integer, Boolean>> relationship;
    private Map<Integer, List<int[]>> tweets;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.count = 0;
        this.tweets=new HashMap<>();
        this.relationship = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<int[]> userTweets = tweets.get(userId);
        if (userTweets == null) {
            userTweets = new LinkedList<>();
            tweets.put(userId, userTweets);
        }
        userTweets.add(0, new int[]{userId, count++, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        //确定显示用户
        Map<Integer, Iterator<int[]>> users = new HashMap<>();
        List<int[]> userTweet;
        userTweet = tweets.get(userId);
        if (userTweet != null)
            users.put(userId, userTweet.iterator());
        Map<Integer, Boolean> userMap = relationship.get(userId);
        if (userMap != null) {
            for (int u : userMap.keySet()) {
                userTweet = tweets.get(u);
                if (userTweet != null)
                    users.put(u, userTweet.iterator());
            }
        }

        //选择
        List<Integer> res=new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>(compareByTime);
        Iterator<int[]> tweetIterator;
        int[] tweet;


        for (int i = 0; i < NewsCount; ) {
            if(queue.isEmpty()){
                for (int user:users.keySet()) {
                    tweetIterator=users.get(user);
                    if(tweetIterator!=null&&tweetIterator.hasNext())
                        queue.offer(tweetIterator.next());
                    if(tweetIterator!=null&&!tweetIterator.hasNext()){
                        users.put(user,null);
                    }
                }
                if(queue.isEmpty())
                    break;
            }else{
                tweet=queue.poll();
                tweetIterator=users.get(tweet[0]);
                if(tweetIterator!=null&&tweetIterator.hasNext())
                    queue.offer(tweetIterator.next());
                if(tweetIterator!=null&&!tweetIterator.hasNext()){
                    users.put(tweet[0],null);
                }
                res.add(tweet[2]);
                i++;
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Map<Integer, Boolean> userMap = relationship.get(followerId);
        if (userMap == null) {
            userMap = new HashMap<>();
            relationship.put(followerId, userMap);
        }
        userMap.put(followeeId, true);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Map<Integer, Boolean> userMap = relationship.get(followerId);
        if (userMap != null) {
            userMap.remove(followeeId);
        }
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        List list;

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        list = twitter.getNewsFeed(1);
        System.out.println(Arrays.toString(list.toArray()));

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        list = twitter.getNewsFeed(1);
        System.out.println(Arrays.toString(list.toArray()));

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        list = twitter.getNewsFeed(1);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
