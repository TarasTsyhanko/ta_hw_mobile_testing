package utils;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.time.LocalTime;

public class Letter {

    private String recipient;
    private String subject;
    @JsonIgnore
    private final String textBody;

    {
        textBody = LocalTime.now().toString();
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getTextBody() {
        return textBody;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", textBody='" + textBody + '\'' +
                '}';
    }
}
