package org.jjinppang.jjinppang.api.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jjinppang.jjinppang.domain.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    String Nickname;
    String UserProfileImagePath;


    public static UserProfileResponse from(User user){
        if (user.getUserProfileImagePath() == null) {
            user.setUserProfileImagePath("https://jjinppang-user-profile.s3.ap-northeast-2.amazonaws.com/default/default_image.png");
        }
        return new UserProfileResponse(
                user.getUserNickname(),
                user.getUserProfileImagePath()
        );
    }

}
