package opgave01.models;

public class StringVault {
    private String secretString;
    private String password;

    public StringVault(String secretString, String password) {
        this.secretString = secretString;
        this.password = password;
    }

    public String getSecretString(String password) {
        if (password.equals(this.password)) {
            return this.secretString;
        }
        else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
