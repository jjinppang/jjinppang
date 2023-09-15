package org.jjinppang.jjinppang.api.user.service;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jjinppang.jjinppang.api.user.request.UpdateUserProfileRequest;
import org.jjinppang.jjinppang.api.user.response.UserProfileResponse;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemNotFoundException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServicelmpl implements UserService{

    private final UserRepository userRepository;
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public UserProfileResponse findUser(User user) {
        User findUserProfile = userRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND));
        return UserProfileResponse.from(findUserProfile);
    }

    @Transactional
    @Override
    public void updateUserProfile(User user, UpdateUserProfileRequest request) {
        user.updateUserProfile(request.getUserNickname());
        userRepository.save(user);
        
    }

    @Transactional
    @Override
    public void updateUserProfileImage(User user, MultipartFile multipartFile) {
        String newUserProfileImagePath = upload(multipartFile,"upload");

        String prevUserProfileImage = user.getUserProfileImagePath();

        if (prevUserProfileImage != null) {
            deleteImage(getFileRandomName(prevUserProfileImage),"upload");
        }

        user.updateUserProfileImage(newUserProfileImagePath);
        userRepository.save(user);

    }
    public String upload(MultipartFile multipartFile, String dirName){
        String fileName = dirName + "/" + createFileName(multipartFile.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType()); // multipartfile 종류 확인

        try (InputStream inputStream = multipartFile.getInputStream()){
            amazonS3Client.putObject(
                    new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicReadWrite));
        } catch (IOException e){
            throw new FileSystemNotFoundException();
        }
        return amazonS3Client.getUrl(bucket, fileName).toString();

    }

    public void deleteImage(String fileName, String dirName) {
        amazonS3Client.deleteObject(new DeleteObjectRequest(bucket, dirName+"/"+fileName));
    }

    public String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    public String getFileRandomName(String userProfileImagePath){
        return userProfileImagePath.substring(userProfileImagePath.lastIndexOf("/")+1);
    }

    public String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }




}
