package org.kurdev.YM_music_down.util;

public class LinkProcessorUtil {

    public static String getUserId(String link) {
        String userId = null;
        int userIdStartIndex = link.indexOf("users/");
        if (userIdStartIndex != -1) {
            userIdStartIndex += 6;
            userId = link.substring(userIdStartIndex, link.indexOf("/", userIdStartIndex));
        }
        return userId;
    }

    public static String getPlayListId(String link) {
        String playlistId = null;

        int linkIdStartIndex = link.indexOf("playlists/");
        if (linkIdStartIndex != -1) {
            linkIdStartIndex += 10;
            char[] linkArr = link.toCharArray();
            int linkIdEndIndex = linkArr[linkArr.length - 1] == '/' ? link.length() - 1 : link.length();

            playlistId = link.substring(linkIdStartIndex, linkIdEndIndex);
        }

        return playlistId;
    }
}
