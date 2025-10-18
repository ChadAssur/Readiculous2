package za.ac.readiculous.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String address;

    /**
     * e.g. "EMAIL", "PHONE", "WHATSAPP" — stored as simple String for flexibility.
     * You may replace with an Enum if you prefer stricter typing.
     */
    private String preferredContactMethod;

    private LocalDate memberSince;
    private String notes;

    protected Contact() {} // For JPA

    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.preferredContactMethod = builder.preferredContactMethod;
        this.memberSince = builder.memberSince;
        this.notes = builder.notes;
    }

    public Integer getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public String getNotes() {
        return notes;
    }

    /* Convenience update methods */
    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public void updatePhone(String newPhone) {
        this.phone = newPhone;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setPreferredContactMethod(String method) {
        this.preferredContactMethod = method;
    }

    public void addNote(String additionalNote) {
        if (this.notes == null || this.notes.isEmpty()) {
            this.notes = additionalNote;
        } else {
            this.notes = this.notes + "\n" + additionalNote;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {
        private Integer contactId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private String preferredContactMethod;
        private LocalDate memberSince;
        private String notes;

        public Builder contactId(Integer contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder preferredContactMethod(String method) {
            this.preferredContactMethod = method;
            return this;
        }

        public Builder memberSince(LocalDate memberSince) {
            this.memberSince = memberSince;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Contact build() {
            // optional: add simple validation here, e.g. email not null
            return new Contact(this);
        }
    }
}

