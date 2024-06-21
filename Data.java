package DB_1;

public class Data {
    String id;
    String password;
    String date;
    String name;

    String tel;

    public Data(String id, String password, String date, String name, String tel) {
        this.id = id;
        this.password = password;
        this.date = date;
        this.name = name;
        this.tel = tel;
    }
    public Data(String id){
        this.id=id;
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
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}