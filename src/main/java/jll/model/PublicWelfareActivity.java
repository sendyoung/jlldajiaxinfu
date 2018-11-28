package jll.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ent_public_welfare_activity")
public class PublicWelfareActivity extends InformationPrivided {
    private String public_welfare_activity_id;//公益活动ID
    private String activity;//活动内容

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getPublic_welfare_activity_id() {
        return public_welfare_activity_id;
    }

    public void setPublic_welfare_activity_id(String public_welfare_activity_id) {
        this.public_welfare_activity_id = public_welfare_activity_id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
