package DB_1;

public class Data {
    String id;
    String password;
    String date;
    String name;

    String Tel;

    public Data(String id, String password, String date, String name, String tel) {
        this.id = id;
        this.password = password;
        this.date = date;
        this.name = name;
        Tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}