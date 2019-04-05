package pr4_1;

import java.util.HashMap;

public class UserInfo {
    private int userInfo;
    private String surmame;
    private HashMap userInfoMap;


    public UserInfo(String surmame, HashMap userInfoMap) {
        this.surmame = surmame;
        this.userInfoMap = userInfoMap;
    }

    public int getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(int userInfo) {
        this.userInfo = userInfo;
    }

    public String getSurmame() {
        return surmame;
    }

    public void setSurmame(String surmame) {
        this.surmame = surmame;
    }

    public HashMap getUserInfoMap() {
        return userInfoMap;
    }

    public void setUserInfoMap(HashMap userInfoMap) {
        this.userInfoMap = userInfoMap;
    }
}
