package org.jjinppang.jjinppang.domain.user;

import lombok.*;
//import org.jjinppang.jjinppang.domain.common.BaseEntity;
import org.jjinppang.jjinppang.domain.user.type.Provider;
import org.jjinppang.jjinppang.domain.user.type.Role;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = true)
    private String userEmail;

    @Column(nullable = false)
    private String userName;

    @Column
    private String userPassword;

    @Column(nullable = false)
    private String userNickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider userProvider;

    @Column(nullable = false)
    private String userProviderId;

    @Column
    private String userProfileImagePath;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role userRole;

    public static User createUser(Provider userProvider, String userProviderId, String userName, Role role, String userNickname) {
        User user = new User();
        user.userProvider = userProvider;
        user.userProviderId = userProviderId;
        user.userName = userName;
        user.userRole = role;
        user.userNickname = userNickname;
        return user;
    }

    // 유저 프로필 수정
    public void updateUserProfile(String userNickname) {
        this.userNickname = userNickname;
    }

    // 유저 이미지 수정
    public void updateUserProfileImage(String userProfileImagePath) {
        this.userProfileImagePath = userProfileImagePath;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userProvider=" + userProvider +
                ", userProviderId='" + userProviderId + '\'' +
                ", userProfileImagePath='" + userProfileImagePath + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
