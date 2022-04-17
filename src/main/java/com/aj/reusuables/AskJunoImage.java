package com.aj.reusuables;



import java.net.URI;


public class AskJunoImage {

    private String imageName;

    private String emotionType;

    private URI imageUrl;

    private String localFilePath;

    private String pixelDensity;

    private String resolution;

    private String imageType;

    private String creatorId;

    private String ownerId;

    private String reviewerId;

    public AskJunoImage() {
        super();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getEmotionType() {
        return emotionType;
    }

    public void setEmotionType(String emotionType) {
        this.emotionType = emotionType;
    }

    public URI getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URI imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPixelDensity() {
        return pixelDensity;
    }

    public void setPixelDensity(String pixelDensity) {
        this.pixelDensity = pixelDensity;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String relativePath) {
        this.localFilePath = relativePath;
    }

}
