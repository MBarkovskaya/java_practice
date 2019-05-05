package pr4_1;
/*
any notices
 */

public class UserInfo {
    private String surmame;
    private String domainName;
    private String email;

    public UserInfo(String surmame, String domainName, String email) {
        this.surmame = surmame;
        this.domainName = domainName;
        this.email = email;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
//any notices
    public String getSurmame() {
        return surmame;
    }

    public void setSurmame(String surmame) {
        this.surmame = surmame;
    }
    //any notices
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
