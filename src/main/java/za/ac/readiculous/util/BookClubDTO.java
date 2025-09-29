package za.ac.readiculous.util;

public class BookClubDTO {
    private long clubId;
    private String clubName;
    private String clubDescription;
    private int ownerId;

    public BookClubDTO(long clubId, String clubName, String clubDescription, int ownerId) {}

    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int userId) {
        this.ownerId = ownerId;
    }

    public long getClubId() {
        return clubId;
    }
    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }
    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

}
