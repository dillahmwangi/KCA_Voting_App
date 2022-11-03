package uk.cmd.kcauvotingapp;

public class single_view {
    private int profile_image;
    private String txtUsername,txtDescription;

    public single_view(int imageProfile, String txtUsernameusername, String txtDescription) {
        this.profile_image = profile_image;
        this.txtUsername= txtUsername;
        this.txtDescription = txtDescription;
    }

    public int getprofile_image() {
        return profile_image;
    }

    public void setprofile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String gettxtUsername() {
        return txtUsername;
    }

    public void settxtUsername(String txtUsername) {
        this.txtUsername = txtUsername;
    }

    public String gettxtDescription() {
        return txtDescription;
    }

    public void settxtDescription(String txtDescription) {
        this.txtDescription = txtDescription;
    }


}
