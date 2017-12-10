package np.com.hemshrestha.blog.model;

/**
 * Created by hereshem on 11/29/17.
 */

public class Blog {
    int id;
    String title, description, published_date, author;
    int views;

    public Blog(){}

    public Blog(String title, String description) {
        this.id = 0;
        this.title = title;
        this.description = description;
        this.published_date = System.currentTimeMillis()+"";
        this.author = "Me";
        this.views = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
