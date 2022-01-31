package hu.ak_akademia.participant;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Participant {

    private final String fullName;
    private final String company;
    private final String countryCode;
    private final boolean admitted;
    private final Timestamp admittanceTimestamp;

    private Participant(Builder builder) {
        this.fullName = builder.fullName;
        this.company = builder.company;
        this.countryCode = builder.countryCode;
        this.admitted = builder.admitted;
        this.admittanceTimestamp = builder.admittanceTimestamp;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isAdmitted() {
        return admitted;
    }

    public Timestamp getAdmittanceTimestamp() {
        return admittanceTimestamp;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "fullName='" + fullName + '\'' +
                ", company='" + company + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", admitted=" + admitted +
                ", admittanceTimestamp=" + admittanceTimestamp +
                '}';
    }

    public static class Builder {
        private String fullName;
        private String company;
        private String countryCode;
        private boolean admitted;
        private Timestamp admittanceTimestamp;

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder admitted(boolean admitted) {
            this.admitted = admitted;
            if (admitted) {
                this.admittanceTimestamp = Timestamp.valueOf(LocalDateTime.now());
            }
            return this;
        }

        public Participant build() {
            return new Participant(this);
        }
    }
}
