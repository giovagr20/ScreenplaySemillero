package in.practice.automationtesting.certification.models;

public class UserModel {

    private String _email;
    private String _password;

    public UserModel(String email, String password) {
        _email = email;
        _password = password;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
