package za.ac.readiculous.util;

public class BookClubDTO {

    private Integer clubId;
    private String clubName;
    private String clubDescription;
    private Integer ownerId;

    public BookClubDTO() {}

    // Request DTO
    public BookClubDTO(String clubName, String clubDescription, Integer ownerId) {
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.ownerId = ownerId;
    }

    // Response DTO
    public BookClubDTO(Integer clubId, String clubName, String clubDescription, Integer ownerId) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.ownerId = ownerId;
    }

    public Integer getClubId() { return clubId; }
    public void setClubId(Integer clubId) { this.clubId = clubId; }
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    public String getClubDescription() { return clubDescription; }
    public void setClubDescription(String clubDescription) { this.clubDescription = clubDescription; }
    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }
}
