package org.kurdev.YM_music_down.controller;

import org.kurdev.YM_music_down.util.JavaScriptInterpreter;
import org.kurdev.YM_music_down.util.LinkProcessorUtil;
import org.kurdev.YM_music_down.util.MusicDownloader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @GetMapping("/process_link")
    public ResponseEntity<String> processLink(@RequestParam("playlist_link") String playlistLink) {
        String userId = LinkProcessorUtil.getUserId(playlistLink);
        System.out.println("User id is: " + userId);
        String playlistId = LinkProcessorUtil.getPlayListId(playlistLink);
        System.out.println("Playlist id id: " + playlistId);

        JavaScriptInterpreter.getPlayListWithYandexApi(userId, playlistId);
        return null;

//        return getPlaylist(userId, playlistId);
    }
//
//    @GetMapping("/get_playlist")
//    public ResponseEntity<String> getPlaylist(@RequestParam("user_id") String userId,
//                                              @RequestParam("playlist_id") String playlistId) {
//        JavaScriptInterpreter.getPlayListWithYandexApi(userId,playlistId);
//        return null;
//    }
    @GetMapping("/epta")
    public void download(){
        MusicDownloader musicDownloader = new MusicDownloader();
        musicDownloader.download();
    }

}
