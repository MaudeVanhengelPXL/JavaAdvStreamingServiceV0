package be.pxl.ja.streamingservice.model;

import java.util.List;

public class Account {

    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile();
        profile.setName("profile1");
        profiles.add(profile);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }


}
