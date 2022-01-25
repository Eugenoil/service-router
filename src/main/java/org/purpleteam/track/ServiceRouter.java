package org.purpleteam.track;

import org.json.JSONObject;

public class ServiceRouter {

    public String makeTelegramResponse(String source) {
        try {
            JSONObject json = new JSONObject(source);
            JSONObject data = json.getJSONObject("result");
            Long fromId = data.getJSONObject("from").getLong("id");
            Long chatId = data.getJSONObject("chat").getLong("id");
            String text = data.getString("text");
            return (fromId + " : " + chatId + " : " + text);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
}
