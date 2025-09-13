package za.ac.readiculous.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class JoinPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joinId;
    private String memberName;
    private String email;
    private Long clubId;

    protected JoinPage() {}

    private JoinPage(Builder builder) {
        this.joinId = builder.joinId;
        this.memberName = builder.memberName;
        this.email = builder.email;
        this.clubId = builder.clubId;
    }

    public Long getJoinId() {
        return joinId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEmail() {
        return email;
    }

    public Long getClubId() {
        return clubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JoinPage)) return false;
        JoinPage joinPage = (JoinPage) o;
        return Objects.equals(joinId, joinPage.joinId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinId);
    }

    public static class Builder {
        private Long joinId;
        private String memberName;
        private String email;
        private Long clubId;

        public Builder joinId(Long joinId) {
            this.joinId = joinId;
            return this;
        }

        public Builder memberName(String memberName) {
            this.memberName = memberName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder clubId(Long clubId) {
            this.clubId = clubId;
            return this;
        }

        public JoinPage build() {
            return new JoinPage(this);
        }
    }
}
