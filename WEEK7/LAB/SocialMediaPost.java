// Parent class
class SocialMediaPost {
    String author;
    String content;
    String time;

    public SocialMediaPost(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println("Author: " + author + "\nContent: " + content + "\nTime: " + time);
    }
}

// Child class for Instagram
class InstagramPost extends SocialMediaPost {
    int likes;
    String hashtags;

    public InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Likes: " + likes + "\nHashtags: " + hashtags);
    }
}

// Child class for Twitter
class TwitterPost extends SocialMediaPost {
    int retweetCount;

    public TwitterPost(String author, String content, String time, int retweetCount) {
        super(author, content, time);
        this.retweetCount = retweetCount;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Character Count: " + content.length() + "\nRetweets: " + retweetCount);
    }
}

// Child class for LinkedIn
class LinkedInPost extends SocialMediaPost {
    int connectionCount;

    public LinkedInPost(String author, String content, String time, int connectionCount) {
        super(author, content, time);
        this.connectionCount = connectionCount;
    }

    @Override
    public void display() {
        System.out.println("Professional Post by " + author + "\n---\n" + content + "\n---\nConnections: " + connectionCount + "\nTime: " + time);
    }
}

class SocialMediaFeed {
    public static void main(String[] args) {
        SocialMediaPost[] feed = new SocialMediaPost[3];
        feed[0] = new InstagramPost("user123", "Enjoying the sun! ☀️", "2 hours ago", 150, "#vacation #travel");
        feed[1] = new TwitterPost("tech_guru", "New AI model released!", "30 minutes ago", 2000);
        feed[2] = new LinkedInPost("JaneDoe", "Thrilled to announce my new role as Project Manager!", "1 day ago", 500);

        for (SocialMediaPost post : feed) {
            System.out.println("\n--- New Post ---");
            post.display();
        }
    }
}