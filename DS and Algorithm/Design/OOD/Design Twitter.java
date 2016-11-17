/*Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/

public class Twitter {


    
    class Tweet{
        int timestamp;
        int tweetId;
        Tweet next;
        
        public Tweet(int timestamp, int tweetId){
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    
    class User{
        int userId;
        Set<Integer> followees;
        Tweet headTweet;
        
        public User(int userId){
            this.userId = userId;
            followees = new HashSet<Integer>();
            follow(this.userId);
        }
        
        public void follow(int userId){
            followees.add(userId);
        }
        
        public void unfollow(int userId){
            followees.remove(userId);
        }
        
        //newest post always at head
        public Tweet post(Tweet t){
            t.next = headTweet;
            headTweet = t;
            return headTweet;
        }
    }
    
    private Map<Integer, User> userMap;
    private static int time = 0;
    
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    
        userMap.putIfAbsent(userId, new User(userId));
        Tweet t = new Tweet(time++ , tweetId);
        userMap.get(userId).post(t);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User u = userMap.get(userId);
        List<Integer> res = new ArrayList<>();
        if(u == null)   return res;
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a,b)->(b.timestamp-a.timestamp));
        for(int followee : u.followees){
            if(userMap.containsKey(followee) && userMap.get(followee).headTweet != null){
                heap.offer(userMap.get(followee).headTweet);
            }
        }
        int k = 0;
        while(!heap.isEmpty() && k < 10){
           Tweet t = heap.poll();
           if(t.next != null){
               heap.offer(t.next);
           }
           res.add(t.tweetId);
           k++;
        }
        return res;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        User u = userMap.get(followerId);
        u.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)||followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */