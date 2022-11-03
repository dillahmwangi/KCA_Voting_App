package uk.cmd.kcauvotingapp;

public class single_view {
    private int imageProfile;
    private String username,description;

    public single_view(int imageProfile, String username, String description) {
        this.imageProfile = imageProfile;
        this.username = username;
        this.description = description;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
