package ui.pages;

public interface GmailCreateLetterPage {

    void inputRecipientLetter(String recipient);

    void inputSubjectLetter(String subject);

    void inputTextBodyLetter(String textBody);

    void sendLetter();
}
