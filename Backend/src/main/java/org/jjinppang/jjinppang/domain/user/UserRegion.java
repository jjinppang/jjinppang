package org.jjinppang.jjinppang.domain.user;

import com.nimbusds.oauth2.sdk.GrantType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class UserRegion {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRegionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public static UserRegion createUserRegion(User user) {
        UserRegion userRegion = new UserRegion();
        userRegion.user = user;

        return userRegion;
    }
}
